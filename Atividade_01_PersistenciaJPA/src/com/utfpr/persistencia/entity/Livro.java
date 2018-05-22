/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utfpr.persistencia.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author denis
 */
@Entity
public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String isbn;

    private String title;

    private String author;

    private int yearOfPublication;

    private String publisher;

     @ManyToMany
    @JoinTable(name = "avaliacao",
            joinColumns = {
                @JoinColumn(name = "userID")},
            inverseJoinColumns = {
                @JoinColumn(name = "isbn")})
    private Set<Avaliacao> avaliacoes;

    public Livro() {
    }

    public Livro(String isbn, String title, String author, int yearOfPublication, String publisher) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Set<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(Set<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    @Override
    public String toString() {
        return "Livro{" + "isbn=" + isbn + ", title=" + title + ", author=" + author + ", yearOfPublication=" + yearOfPublication + ", publisher=" + publisher + ", avaliacoes=" + avaliacoes + '}';
    }

}
