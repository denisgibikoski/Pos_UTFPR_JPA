/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utfpr.main;

import com.utfpr.persistencia.entity.Livro;
import com.utfpr.persistencia.pesquisa.PesquisasImpl;
import com.utfpr.persistencia.pesquisa.InterfacePesquisas;
import com.utfpr.persistencia.util.Importacoes;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author denis
 */
public class MainPersistenciaJPA {

    public MainPersistenciaJPA() throws Exception {

        
        /* importacoes veitas
        Importacoes i = new Importacoes();
        i.Importa();
        */
        
        //Liste todos os livros.
        InterfacePesquisas ip = new PesquisasImpl();

        List<Livro> list = ip.getTodosLivros();

        list.forEach(System.out::println);
        
        String pais = "Brasil";
        
        int resultado = ip.getPorPaisPegaQuantidadeDeUsuariodeAvaLiarao2Livros(pais);
        
        
    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     *
     */
    public static void main(String[] args) throws IOException, Exception {

        MainPersistenciaJPA mainPersistenciaJPA = new MainPersistenciaJPA();

    }

}
