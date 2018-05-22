package com.utfpr.persistencia.entity;

import com.utfpr.persistencia.entity.Avaliacao;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-21T16:13:53")
@StaticMetamodel(Livro.class)
public class Livro_ { 

    public static volatile SingularAttribute<Livro, Integer> yearOfPublication;
    public static volatile SingularAttribute<Livro, String> author;
    public static volatile SetAttribute<Livro, Avaliacao> avaliacoes;
    public static volatile SingularAttribute<Livro, String> isbn;
    public static volatile SingularAttribute<Livro, String> publisher;
    public static volatile SingularAttribute<Livro, String> title;

}