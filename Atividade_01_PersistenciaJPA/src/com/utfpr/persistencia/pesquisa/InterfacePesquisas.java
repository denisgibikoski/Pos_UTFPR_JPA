/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utfpr.persistencia.pesquisa;

import com.utfpr.persistencia.entity.Livro;
import java.util.List;

/**
 *
 * @author denis
 */
public interface InterfacePesquisas {

    //Consultas para implementar. Parâmetros são indicados por X e Y.
    //Liste todos os livros.
    public List<Livro> getTodosLivros();

    //Dado um nome de paı́s X, a quantidade de usuários que avaliaram pelo menos 2 livros.
    public void getPorPaisPegaQuantidadeDeUsuariodeAvaLiarao2Livros(String pais);

    //Liste os tı́tulos dos livros que brasileiros avaliaram e as suas notas.
    //Liste os tı́tulos dos X livros livros mais bem avaliados no ano Y.
    //Para cada autor, liste o número de livros avaliados e sua média de nota.
    //Para cada editora, o número de livros cadastrados.
    public void getEditoraLivrosCadastrados();
    
    //O número de livros classificados em cada nota de avaliação.
    //Os tı́tulos e autores dos X livros com média de nota maior que Y.
    //Os tı́tulos dos livros, a idade mı́nima, máxima e a média dos usuários que o avaliaram.
    //Para um ano X, o número de avaliações para cada idade de usuário.
}
