/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utfpr.persistencia.entity;

import java.io.Serializable;
import java.util.HashSet;
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
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;

    private String location;

    private int Age;

    @ManyToMany
    @JoinTable(name = "avaliacao",
            joinColumns = {
                @JoinColumn(name = "userID")},
            inverseJoinColumns = {
                @JoinColumn(name = "isbn")})
    private Set<Avaliacao> avaliacoes;

    public Usuario() {
        this.avaliacoes = new HashSet<Avaliacao>();
    }

    public Usuario(int userID, String location, int Age) {
        this.avaliacoes = new HashSet<Avaliacao>();
        this.userID = userID;
        this.location = location;
        this.Age = Age;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public Set<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(Set<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    @Override
    public String toString() {
        return "Usuario{" + "userID=" + userID + ", location=" + location + ", Age=" + Age + ", avaliacoes=" + avaliacoes + '}';
    }

}
