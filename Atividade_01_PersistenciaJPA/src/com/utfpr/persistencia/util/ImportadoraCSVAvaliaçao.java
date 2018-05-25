/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utfpr.persistencia.util;

import com.utfpr.persistencia.crud.AvaliacaoJpaController;
import com.utfpr.persistencia.entity.Avaliacao;
import com.utfpr.persistencia.entity.Livro;
import com.utfpr.persistencia.entity.Usuario;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author denis
 */
class ImportadoraCSVAvaliaçao {

    void importaArquivo(String localArquivo) throws FileNotFoundException, IOException {

        String arquivo = localArquivo;
        // Criação do objeto leito para executar a leitura de um arquivo csv
        BufferedReader leitor = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo)));
        String linha = null;
        int nota = 0;
        // laço para popular o Usuario, usamos um vetor para realizar as conversoes e retirar caracteres desnecessários.
        List<Avaliacao> arquivoTeste = new ArrayList<>();
        while ((linha = leitor.readLine()) != null) {
            String[] vetorArquivo = linha.split(";");
            // apaga os caracteres != de numeral.
            String colUser = vetorArquivo[0].replaceAll("[^0-9]", "");
            Usuario u = new Usuario();
            if (colUser.equalsIgnoreCase("")) {
                u.setUserID(0);
            } else {
                u.setUserID(Integer.parseInt(colUser));
            }
            // limpa as aspas
            Livro l = new Livro();
            String colLocal = vetorArquivo[1].replaceAll("\"", "").toUpperCase();
            l.setIsbn(colLocal);
            // limpa as àspas e quando for valor igual a NULL atribui 0 para nota.
            int tamVetor = vetorArquivo.length;
            if (tamVetor == 3) {
                String colAge = vetorArquivo[2].replaceAll("[^0-9]", "");
                if (colAge.equalsIgnoreCase("")) {
                    nota = 0;
                } else {
                    nota = Integer.parseInt(colAge);
                }
            } else {
                nota = 0;
            }
            Avaliacao a = new Avaliacao();
            a.setLivro(l);
            a.setUsuario(u);
            a.setRating(nota);
            arquivoTeste.add(a);
        }

        leitor.close();

        arquivoTeste.forEach((Avaliacao a) -> {
            try {

                AvaliacaoJpaController ajc = new AvaliacaoJpaController();
                ajc.create(a);

            } catch (Exception ex) {
                Logger.getLogger(ImportadoraCSVLivros.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

}
