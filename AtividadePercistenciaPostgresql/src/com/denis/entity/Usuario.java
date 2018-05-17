/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.denis.entity;

/**
 *
 * @author denis
 */
public class Usuario {
    
   private int idUser; 
   private String Location;
   private int Age;

    public Usuario(int idUser, String Location, int Age) {
        this.idUser = idUser;
        this.Location = Location;
        this.Age = Age;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUser=" + idUser + ", Location=" + Location + ", Age=" + Age + '}';
    }
   
   
    
    
}
