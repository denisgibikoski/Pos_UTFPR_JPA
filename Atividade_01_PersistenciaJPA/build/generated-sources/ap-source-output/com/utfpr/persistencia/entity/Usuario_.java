package com.utfpr.persistencia.entity;

import com.utfpr.persistencia.entity.Avaliacao;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-21T16:13:53")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SetAttribute<Usuario, Avaliacao> avaliacoes;
    public static volatile SingularAttribute<Usuario, String> location;
    public static volatile SingularAttribute<Usuario, Integer> userID;
    public static volatile SingularAttribute<Usuario, Integer> Age;

}