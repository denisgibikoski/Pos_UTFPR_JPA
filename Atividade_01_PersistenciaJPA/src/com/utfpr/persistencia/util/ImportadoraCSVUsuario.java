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
            if (tamVetor ==3) {
                String colAge = vetorArquivo[2].replaceAll("[^0-9]", "");
                if (colAge.equalsIgnoreCase("")) {
                   idade = 0;
                } else {
                   idade = Integer.parseInt(colAge);
                }
            } else {
               idade = 0;
            }
             Usuario usuario =  new Usuario();
             
            
             System.out.println(usuario.toString());
            System.out.println("Voce esta Aqui");
            UsuarioJpaController ujc = new UsuarioJpaController();
            
           
            System.out.println(usuario.toString());
           
            ujc.create(usuario);
            
       leitor.close();
        }
        
        
        
        
        
    
    }
    
}
