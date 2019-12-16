package leituraarquivos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RepositorioCrimes {
    List<Crime> lista;
    
    public RepositorioCrimes() {
        lista = new ArrayList<>();
    }
    
    public void adicionarCrime(Crime crime) {
        if(crime!= null)
            this.lista.add(crime);
    }

    public List<Crime> getLista() {
        return this.lista;
    }
    
    public int getQuantidadeHomicidios() {
        int i = 0;
        for(Crime c : lista) {
            if(c.getNatureza().equals("HOMICIDIO"))
                i++;
        }
        return i;
    }
    
    public  void municipiosComMaisCrimes() {
        Map<String,Integer> map = new TreeMap<>();
        
        for(int i =0; i < this.lista.size(); i++) {
            if(!map.containsKey(this.lista.get(i).getMunicipio()))
                map.put(this.lista.get(i).getMunicipio(),1 );
            else 
                map.replace(this.lista.get(i).getMunicipio(),map.get(this.lista.get(i).getMunicipio()) + 1) ;
        }
        int cont = 0;
        int maxValue = -1;
        String maxKey = null;
        while(cont < 3) {
            maxValue = Collections.max(map.values());
            
            for (Map.Entry<String,Integer> entry : map.entrySet()) {
                if(maxValue == entry.getValue()) {
                    maxKey = entry.getKey();
                }
            }
            map.remove(maxKey,maxValue);
            cont++;
            System.out.println("Municipio :" + maxKey + " |Qtd Crimes :" + maxValue);

        }
    }
    
    public float    getMediaIdades() {
        float total = 0;
        for(Crime c : this.lista) {
            total = total + c.getIdade();
        }
        return (total/this.lista.size());
    }
    
    public void proporcaoHomemMulher() {
        float totalMulheres = 0;
        float totalHomens = 0;
        String masculino = "MASCULINO";
        String feminino = "FEMININO";
        for(Crime c : this.lista) {
            if(c.getSexo().equals(masculino))
                totalHomens = totalHomens + 1;
            if(c.getSexo().equals(feminino))
                totalMulheres++;
        }
        float proporcaoM = (totalMulheres/this.lista.size());
        float proporcaoH = totalHomens/this.lista.size();
        
        System.out.println("proporcao Homens :" + proporcaoH + "\n" + "proporcao Mulheres :" + proporcaoM);
    }
    
    public void dataComMaisCrimes() {
        Map<String, Integer> map = new TreeMap<>();
        for(int i = 0; i < this.lista.size(); i++) {
            if(!map.containsKey(this.lista.get(i).getData()))
                map.put(this.lista.get(i).getData(), this.lista.get(i).getTotal_vitimas());
            else 
                map.replace(this.lista.get(i).getData(), map.get(this.lista.get(i).getData()) + 1);
        }
        int maxValue = Collections.max(map.values());
        String maxKey = null;
        for(Map.Entry<String,Integer> entry : map.entrySet()) {
            if(entry.getValue() == maxValue)
                maxKey = entry.getKey();
        }
        System.out.println("data com mais vitimas :" + maxKey + "| Qtd vitimas :" + maxValue);
    }
    
}
