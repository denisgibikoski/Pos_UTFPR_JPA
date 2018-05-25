/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utfpr.persistencia.pesquisa;

import com.utfpr.persistencia.conexao.Conect;
import com.utfpr.persistencia.crud.LivroJpaController;
import com.utfpr.persistencia.entity.Livro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author denis
 */
public class PesquisasImpl implements InterfacePesquisas {

    //Liste todos os livros.
    @Override
    public List<Livro> getTodosLivros() {

        LivroJpaController ljc = new LivroJpaController();

        List<Livro> todoslivros = ljc.findLivroEntities();

        return todoslivros;

    }

    //Dado um nome de paı́s X, a quantidade de usuários que avaliaram pelo menos 2 livros.
    @Override
    public int getPorPaisPegaQuantidadeDeUsuariodeAvaLiarao2Livros(String pais) {
        
        EntityManager  em  = Conect.getEntityManager();

        
        String consulta = "SELECT COUNT(a) FROM Aluno a";

        TypedQuery<Integer> query = (TypedQuery<Integer>) em.createQuery(consulta);

        int resultado = query.getSingleResult();

        return resultado;
    }

}
