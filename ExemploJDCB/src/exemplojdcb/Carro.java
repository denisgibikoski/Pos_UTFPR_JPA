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
public class Carro {
    
    private 
            String renavam;
            String modelo;
            int ano;
            String cor;
            int proprietario;

    public 
        
        Carro(String renavam, String modelo, int ano, String cor, int proprietario) {
        this.renavam = renavam;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.proprietario = proprietario;
    }

    public String getRenavam() {return renavam;  }

    public void setRenavam(String renavam) { this.renavam = renavam;  }

    public String getModelo() {  return modelo;  }

    public void setModelo(String modelo) {this.modelo = modelo;   }

    public int getAno() { return ano;  }

    public void setAno(int ano) {this.ano = ano;  }

    public String getCor() { return cor;   }

    public void setCor(String cor) {  this.cor = cor;  }

    public int getProprietario() { return proprietario;   }

    public void setProprietario(int proprietario) {  this.proprietario = proprietario;  }

    @Override
    public String toString() {
        return "Carro{" + "renavam=" + renavam + ", modelo=" + modelo + ", ano=" + ano + ", cor=" + cor + ", proprietario=" + proprietario + '}';
    }
            
    
}
