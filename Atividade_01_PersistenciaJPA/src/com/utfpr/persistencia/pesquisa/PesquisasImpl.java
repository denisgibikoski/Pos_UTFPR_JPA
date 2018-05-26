/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utfpr.persistencia.pesquisa;

import com.utfpr.persistencia.conexao.Conect;
import com.utfpr.persistencia.crud.LivroJpaController;
import com.utfpr.persistencia.entity.Livro;
import com.utfpr.persistencia.entity.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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

        todoslivros.forEach(System.out::println);
        return null;

    }

    //Dado um nome de paı́s X, a quantidade de usuários que avaliaram pelo menos 2 livros.
    @Override
    public void getPorPaisPegaQuantidadeDeUsuariodeAvaLiarao2Livros(String pais) {

        EntityManager em = Conect.getEntityManager();

        String consulta = "select count(u) from Usuario u where u.location like :pais";

        
        Query query = em.createQuery(consulta);
        query.setParameter("pais", pais);

        Long quantidade = (Long) query.getSingleResult();
        System.out.println(quantidade);

    }

}
