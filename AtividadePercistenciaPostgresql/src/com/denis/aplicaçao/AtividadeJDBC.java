package com.denis.aplicaçao;

import com.denis.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AtividadeJDBC {

    public static void main(String[] args) throws SQLException {

        Connection cf = new ConnectionFactory().getConnection();
        cf.setCatalog("atividadeJDBC");
        cf.setSchema("atividadeJDBC");
        System.out.println("Conexao aberta, e agora?");

        Statement s = cf.createStatement();
        String sqlImportTable = "COPY usuario (idUser,Location,Age)"+
                "FROM '/home/denis/Documentos/Pos Java/atividade pos percistencia/BX-CSV-Dump/BX-Users.csv'"+
                " DELIMITER ',' CSV HEADER;";
        s.execute(sqlImportTable);

    }

}
