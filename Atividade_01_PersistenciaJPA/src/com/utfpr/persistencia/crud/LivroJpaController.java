/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utfpr.persistencia.crud;

import com.utfpr.persistencia.conexao.Conect;
import com.utfpr.persistencia.entity.Livro;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author denis
 */
public class LivroJpaController implements Serializable {

   EntityManager em = Conect.getEntityManager();
    EntityTransaction et = null;

    public void create(Livro livro) throws Exception {

        et = em.getTransaction();
        et.begin();

        em.persist(livro);

        et.commit();

        em.close();

    }

    public void edit(Livro livro) throws Exception {
        et = em.getTransaction();
        et.begin();
        try {
            livro = em.merge(livro);
            et.commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = livro.getIsbn();
            }

            em.close();
        }

    }

    public void destroy(String id) {
        et = em.getTransaction();
        et.begin();
        try {
            Livro livro;

            livro = em.getReference(Livro.class, id);
            livro.getIsbn();

            em.remove(livro);
            et.commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Livro> findLivroEntities() {
        return findLivroEntities(true, -1, -1);
    }

    public List<Livro> findLivroEntities(int maxResults, int firstResult) {
        return findLivroEntities(false, maxResults, firstResult);
    }

    private List<Livro> findLivroEntities(boolean all, int maxResults, int firstResult) {
        et = em.getTransaction();
        et.begin();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Livro.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Livro findLivro(String id) {
        et = em.getTransaction();
        et.begin();
        try {
            return em.find(Livro.class, id);
        } finally {
            em.close();
        }
    }

    public int getLivroCount() {
        et = em.getTransaction();
        et.begin();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Livro> rt = cq.from(Livro.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
