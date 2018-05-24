/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utfpr.persistencia.util;

import com.utfpr.persistencia.crud.UsuarioJpaController;
import com.utfpr.persistencia.entity.Usuario;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
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
public class ImportadoraCSVUsuario {

    public void importaArquivo(String localArquivo) throws FileNotFoundException, IOException, Exception {

        String arquivo = localArquivo;
        // Criação do objeto leito para executar a leitura de um arquivo csv
        BufferedReader leitor = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo)));
        String linha = null;
        int idade;
        List<Usuario> arquivoTeste = new ArrayList<>();
        // laço para popular o Usuario, usamos um vetor para realizar as conversoes e retirar caracteres desnecessários.
        while ((linha = leitor.readLine()) != null) {
            String[] vetorArquivo = linha.split(";");
            // apaga os caracteres != de numeral.
            String colUser = vetorArquivo[0].replaceAll("[^0-9]", "");
            int userId = 0;
            if (colUser.equalsIgnoreCase("")) {
                userId = 0;
            } else {
                userId = Integer.parseInt(colUser);
            }
            // limpa as aspas
            String colLocal = vetorArquivo[1].replaceAll("\"", "").toUpperCase();
            String local = colLocal;
            // limpa as àspas e quando for valor igual a NULL atribui 0 para idade.
            int tamVetor = vetorArquivo.length;
            if (tamVetor == 3) {
                String colAge = vetorArquivo[2].replaceAll("[^0-9]", "");
                if (colAge.equalsIgnoreCase("")) {
                    idade = 0;
                } else {
                    idade = Integer.parseInt(colAge);
                }
            } else {
                idade = 0;
            }
            // Criando e populando um Array com os dados do arquivo csv...
            Usuario u = new Usuario();
            u.setUserID(userId);
            u.setLocation(local);
            u.setAge(idade);
            arquivoTeste.add(u);

        }
        leitor.close();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = null;

        et = em.getTransaction();
        et.begin();

        arquivoTeste.forEach((Usuario u) -> {
            try {

                em.persist(u);

            } catch (Exception ex) {
                Logger.getLogger(ImportadoraCSVUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        et.commit();
        em.close();

    }

}
