import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danie
 */
public class Pair {
    private final String nome;
    private final List<String> producoes;
    
    public Pair(String nome){
        this.nome = nome;
        this.producoes = new ArrayList<>();
    }
    
    public void AddProductions(List<String> productions){
        producoes.addAll(productions);
    }

    @Override
    public String toString() {
        String s = nome + ":";
        
        for(String str : producoes)
            s += " '" + str + "' ";
        
        return s;
    }
}