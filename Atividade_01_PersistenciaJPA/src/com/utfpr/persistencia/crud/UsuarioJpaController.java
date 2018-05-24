/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utfpr.persistencia.crud;

import com.utfpr.persistencia.entity.Usuario;
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
public class UsuarioJpaController implements Serializable {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = null;

    public void create(Usuario usuario) throws Exception {

        et = em.getTransaction();
        et.begin();

        em.persist(usuario);

        et.commit();

        em.close();
    }

    public void edit(Usuario usuario) throws Exception {

        try {
            et = em.getTransaction();
            et.begin();
            usuario = em.merge(usuario);
            et.commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = usuario.getUserID();

            }
            throw ex;
        } finally {

            em.close();

        }
    }

    public void destroy(int id) {

        et = em.getTransaction();
        et.begin();
        Usuario usuario;

        usuario = em.getReference(Usuario.class, id);
        usuario.getUserID();

        em.remove(usuario);
        et.commit();

        em.close();

    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        et = em.getTransaction();
        et.begin();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
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

    public Usuario findUsuario(int id) {
        et = em.getTransaction();
        et.begin();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        et = em.getTransaction();
        et.begin();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
