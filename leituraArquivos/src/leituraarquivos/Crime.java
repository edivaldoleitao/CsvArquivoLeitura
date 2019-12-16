
package leituraarquivos;

import java.io.Serializable;


public class Crime implements Comparable{
    private String data;
    private String nome;
    private String sexo;
    private String objeto_utilizado;
    private String municipio;
    private int idade;
    private String natureza;
    private int total_vitimas;
    
    
    public Crime(String data, String nome, String sexo ,String objeto_utilizado, String municipio, int idade, String natureza, int total_vitimas){
        this.data = data;
        this.idade = idade;
        this.municipio = municipio;
        this.natureza = natureza;
        this.nome = nome;
        this.objeto_utilizado = objeto_utilizado;
        this.total_vitimas = total_vitimas;
        this.sexo  = sexo;
    }

    public Crime() {
        
    }
    
    public String getData() {
        return data;
    }

    public String getNome() {
        return nome;
    }

    public String getObjeto_utilizado() {
        return objeto_utilizado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public int getIdade() {
        return idade;
    }

    public String getNatureza() {
        return natureza;
    }

    public int getTotal_vitimas() {
        return total_vitimas;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setObjeto_utilizado(String objeto_utilizado) {
        this.objeto_utilizado = objeto_utilizado;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setNatureza(String natureza) {
        this.natureza = natureza;
    }

    public void setTotal_vitimas(int total_vitimas) {
        this.total_vitimas = total_vitimas;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Crime{" + "data=" + data + ", nome=" + nome + ", sexo=" + sexo + ", objeto_utilizado=" + objeto_utilizado + ", municipio=" + municipio + ", idade=" + idade + ", natureza=" + natureza + ", total_vitimas=" + total_vitimas + '}';
    }
    
    @Override
    public int compareTo(Object c) {
        if(this.total_vitimas > ((Crime)c).getTotal_vitimas())
            return 1;
        if(this.total_vitimas < ((Crime)c).getTotal_vitimas())
            return -1;
        return 0;
    }

 
    
}
