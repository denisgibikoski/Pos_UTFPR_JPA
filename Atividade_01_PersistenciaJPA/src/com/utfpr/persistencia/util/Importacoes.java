/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utfpr.persistencia.util;

import java.sql.SQLException;

/**
 *
 * @author denis
 */
public class Importacoes {

    public void Importa() throws SQLException, Exception {

        // importa planilha User
        ImportadoraCSVUsuario importCSV = new ImportadoraCSVUsuario();
        importCSV.importaArquivo("/home/denis/Documentos/Pos Java/atividade pos percistencia/BX-CSV-Dump/BX-Users.csv");

        //importa Planilha Livro
        ImportadoraCSVLivros livros = new ImportadoraCSVLivros();
        livros.importaArquivo("/home/denis/Documentos/Pos Java/atividade pos percistencia/BX-CSV-Dump/BX-Books-rev.csv");

        //importa Planilha Avaliaçao
        ImportadoraCSVAvaliaçao avaliaçao = new ImportadoraCSVAvaliaçao();
        avaliaçao.importaArquivo("/home/denis/Documentos/Pos Java/atividade pos percistencia/BX-CSV-Dump/BX-Book-Ratings.csv");

    }

}
