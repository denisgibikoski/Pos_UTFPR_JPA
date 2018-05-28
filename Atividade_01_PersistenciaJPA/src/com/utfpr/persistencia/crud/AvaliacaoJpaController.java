/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utfpr.persistencia.crud;

import com.utfpr.persistencia.conexao.Conect;
import com.utfpr.persistencia.entity.Avaliacao;
import com.utfpr.persistencia.entity.key_Imp;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author denis
 */
public class AvaliacaoJpaController implements Serializable {

  
    EntityManager em = Conect.getEntityManager();

    EntityTransaction et = null;

    public void create(Avaliacao avaliacao) throws Exception {

        et = em.getTransaction();
        et.begin();

        em.persist(avaliacao);

        et.commit();

        em.close();

    }

    public void edit(Avaliacao avaliacao) throws Exception {
        et = em.getTransaction();
        et.begin();
        try {
            avaliacao = em.merge(avaliacao);
            et.commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                key_Imp id = avaliacao.getId();
            }

            em.close();
        }

    }

    public void destroy(String id) {
        et = em.getTransaction();
        et.begin();
        try {
            Avaliacao avaliacao;

            avaliacao = em.getReference(Avaliacao.class, id);
            avaliacao.getId();

            em.remove(avaliacao);
            et.commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Avaliacao> findAvaliacaoEntities() {
        return findAvaliacaoEntities(true, -1, -1);
    }

    public List<Avaliacao> findAvaliacaoEntities(int maxResults, int firstResult) {
        return findAvaliacaoEntities(false, maxResults, firstResult);
    }

    private List<Avaliacao> findAvaliacaoEntities(boolean all, int maxResults, int firstResult) {
        et = em.getTransaction();
        et.begin();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Avaliacao.class));
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

    public Avaliacao findAvaliacao(String id) {
        et = em.getTransaction();
        et.begin();
        try {
            return em.find(Avaliacao.class, id);
        } finally {
            em.close();
        }
    }

    public int getAvaliacaoCount() {
        et = em.getTransaction();
        et.begin();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Avaliacao> rt = cq.from(Avaliacao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
