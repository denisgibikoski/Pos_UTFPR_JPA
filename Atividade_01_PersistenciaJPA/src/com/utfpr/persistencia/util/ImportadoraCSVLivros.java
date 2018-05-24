/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utfpr.persistencia.util;

import com.utfpr.persistencia.entity.Livro;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author denis
 */
class ImportadoraCSVLivros {

    void importaArquivo(String localArquivo) throws FileNotFoundException, IOException, Exception {

        String arquivo = localArquivo;
        // Criação do objeto leito para executar a leitura de um arquivo csv
        BufferedReader leitor = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo)));
        String linha = null;
        int ano = 0;
        // laço para popular o Usuario, usamos um vetor para realizar as conversoes e retirar caracteres desnecessários.
        List<Livro> arquivoTeste = new ArrayList<>();
        while ((linha = leitor.readLine()) != null) {
            String[] vetorArquivo = linha.split(";");
            // String isbn;
            String colisbn = vetorArquivo[0].replaceAll("\"", "").toUpperCase();
            String isbn = colisbn;

            // String title
            String coltitulo = vetorArquivo[1].replaceAll("\"", "").toUpperCase();
            String titulo = coltitulo;

            // String author
            String colautor = vetorArquivo[2].replaceAll("\"", "").toUpperCase();
            String autor = colautor;

            // lint yearOfPublication
            int tamVetor = vetorArquivo.length;
            String colAge = "";
            if (tamVetor == 4) {
                colAge = vetorArquivo[3].replaceAll("[^0-9]", "");

                if (colAge.equalsIgnoreCase("")) {
                    ano = 0;
                } else {
                    ano = Integer.parseInt(colAge);
                }
            }
            // String publishe
            String colpublishe = vetorArquivo[4].replaceAll("\"", "").toUpperCase();
            String publishe = colpublishe;
            Livro l  = new Livro();
            l.setIsbn(isbn);
            l.setAuthor(autor);
            l.setPublisher(publishe);
            l.setTitle(titulo);
            l.setYearOfPublication(ano);
            
            arquivoTeste.add(l);

        }
        leitor.close();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = null;

        et = em.getTransaction();
        et.begin();

        arquivoTeste.forEach((Livro l) -> {
            try {

                em.persist(l);

            } catch (Exception ex) {
                Logger.getLogger(ImportadoraCSVUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        et.commit();
        em.close();

    }
}

