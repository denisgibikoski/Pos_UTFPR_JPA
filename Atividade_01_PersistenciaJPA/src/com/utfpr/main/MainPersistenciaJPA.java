/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utfpr.main;


import com.utfpr.persistencia.util.Importacoes;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author denis
 */
public class MainPersistenciaJPA {

    public MainPersistenciaJPA() throws SQLException, IOException {

       
        Importacoes i = new Importacoes();
        i.Importa();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, IOException {

        new MainPersistenciaJPA();

    }

}
