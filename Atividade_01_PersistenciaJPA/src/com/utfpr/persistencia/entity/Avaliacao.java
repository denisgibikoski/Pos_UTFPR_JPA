/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utfpr.persistencia.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 *
 * @author denis
 */
public class Avaliacao implements Serializable {
    
     @Embeddable
    public static class key_Imp implements Serializable {

        private int userID;
        private String isbn;

        public key_Imp() {
        }

        public key_Imp(int userID, String isbn) {
            this.userID = userID;
            this.isbn = isbn;
        }

        

    }
    

    @EmbeddedId
    private key_Imp id;

    @ManyToOne
    @MapsId("userID")
    private Usuario usuario;
    @ManyToOne
    @MapsId("isbn")
    private Livro livro;

    private Double rating;

    public Avaliacao() {
    }

    public Avaliacao(Usuario usuario, Livro livro, Double rating) {
        id = new key_Imp(usuario.getUserID(), livro.getIsbn());
        this.usuario = usuario;
        this.livro = livro;
        this.rating = rating;
    }

    public key_Imp getId() {
        return id;
    }

    public void setId(key_Imp id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Avaliacao{" + "id=" + id + ", usuario=" + usuario + ", livro=" + livro + ", rating=" + rating + '}';
    }
    
    

}
