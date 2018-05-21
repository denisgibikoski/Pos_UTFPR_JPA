/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplojdcb;

/**
 *
 * @author denis
 */
public class Cliente {
    
    private int cpf;
    private String nome;
    private String endereco;
    private String categoria;

    public Cliente(int cpf, String nome, String endereco, String categoria) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.categoria = categoria;
    }

    public String getCategoria() {return categoria;   }

    public void setCategoria(String categoria) { this.categoria = categoria;   }

    public int getCpf() { return cpf;   }

    public void setCpf(int cpf) {   this.cpf = cpf;   }

    public String getNome() { return nome;  }

    public void setNome(String nome) { this.nome = nome;   }

    public String getEndereco() { return endereco;  }

    public void setEndereco(String endereco) { this.endereco = endereco;  }

    @Override
    public String toString() {
        return "Cliente{" + "cpf=" + cpf + ", nome=" + nome + ", endereco=" + endereco + ", categoria=" + categoria + '}';
    }
    
    
    
}
