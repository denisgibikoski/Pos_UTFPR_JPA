/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utfpr.persistencia.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author denis
 */
public class Importacoes {

   public void Importa() throws SQLException {

        //Mult Thread para importar 
        new Thread(new Runnable() {
            @Override
            public void run() {
                // importa planilha User
                ImportadoraCSVUsuario importCSV = new ImportadoraCSVUsuario();
                try {
                    importCSV.importaArquivo("/home/denis/Documentos/Pos Java/atividade pos percistencia/BX-CSV-Dump/BX-Users.csv");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Importacoes.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Importacoes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
/*
        new Thread(() -> {

            //importa Planilha Livro
            ImportadoraCSVLivros livros = new ImportadoraCSVLivros();
            livros.importaArquivo("/home/denis/Documentos/Pos Java/atividade pos percistencia/BX-CSV-Dump/BX-Books-rev.csv");

        }).start();

        new Thread(() -> {

            //importa Planilha Avaliaçao
            ImportadoraCSVAvaliaçao avaliaçao = new ImportadoraCSVAvaliaçao();
            avaliaçao.importaArquivo("/home/denis/Documentos/Pos Java/atividade pos percistencia/BX-CSV-Dump/BX-Book-Ratings.csv");

        }).start();
*/
    }

}
