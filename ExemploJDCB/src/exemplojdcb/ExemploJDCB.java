package exemplojdcb;

import java.sql.*;
import java.util.*;

public class ExemploJDCB {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:postgresql://localhost:5432/Pos-Java";

        String user = "root";

        String pass = "root";

        Connection db = DriverManager.getConnection(url, user, pass);

        Statement st = db.createStatement();
        /*
        st.execute("create table cliente("+
                "cpf integer primary key,"+
                "nome char(30) not null,"+
                "endereco varchar(40) not null,"+
                "categoria char(7)check (categoria in('ouro','prata','bronze')))"
        );
        System.out.println("Tabela Cliente criada.");
        st.close();
        
        st.execute("create table carro("
                + "renavam char(11) primary key,"
                + "modelo char(20) not null,"
                + "ano integer not null,"
                + "cor char(10) not null,"
                + "proprietario integer references cliente (cpf))");

        System.out.println("Tabela Carro criada.");
        st.close();
            
        
        
        
        List<Carro> carros = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();

        clientes.add(new Cliente(111, "eu", "rua: u", "bronze"));
        carros.add(new Carro("1234566", "goo", 1989, "branco", 111));
        clientes.add(new Cliente(112, "eu", "rua: u", "bronze"));
        carros.add(new Carro("12345623", "gol", 1999, "branco", 111));
        
        Statement st3 = db.createStatement();
        
        String sql1 = "insert INTO cliente values(?,?,?,?)";
        String sql2 = "insert INTO carro values(?,?,?,?,?)";
        
        PreparedStatement ps1 = db.prepareStatement(sql1);
        PreparedStatement ps2 = db.prepareStatement(sql2);
        
         for(int i=0; i < clientes.size();i++){
            ps1.setInt(1, clientes.get(i).getCpf());
             ps1.setString(2, clientes.get(i).getNome());
            ps1.setString(3, clientes.get(i).getEndereco());
            ps1.setString(4, clientes.get(i).getCategoria());
            ps1.executeUpdate();
        }
        ps1.close();
        
        for(int i=0; i < carros.size();i++){
            ps2 .setString(1, carros.get(i).getRenavam());
            ps2 .setString(2, carros.get(i).getModelo());
            ps2 .setInt(3, carros.get(i).getAno());
            ps2 .setString(4, carros.get(i).getCor());
            ps2 .setInt(5, carros.get(i).getProprietario());
            ps2 .executeUpdate();
        }
        ps2 .close();
        */
        String sql3 = "select nome,modelo, ano from cliente join carro on cpf = proprietario";
        
        Statement st4 = db.createStatement();
        ResultSet rs =st.executeQuery(sql3);
        
        while (rs.next()) {
            System.out.println(rs.getString("nome")+":" + rs.getString("modelo")+","+rs.getString("ano"));
            
        }
        

        db.close();
    }

}
