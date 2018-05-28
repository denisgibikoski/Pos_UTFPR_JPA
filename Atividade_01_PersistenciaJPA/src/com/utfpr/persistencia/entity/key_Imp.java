/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utfpr.persistencia.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author denis
 */
@Embeddable
public class key_Imp implements Serializable {

    private int userID;
    private String isbn;

    public key_Imp() {
    }

    public key_Imp(int userID, String isbn) {
        this.userID = userID;
        this.isbn = isbn;
    }

}
