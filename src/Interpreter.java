
import java.io.IOException;
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
public final class Interpreter {
    List<Character> terminais;
    
    public Interpreter(List<Character> terminais, String entrada) throws IOException
    {
        this.terminais = terminais;
        Parse(entrada);
    }
    
    void Parse(String entrada)
    {
       char[] ent = entrada.toCharArray();
       
       for(int i = 0; i < ent.length; i++){
           if (!terminais.contains(ent[i])){
               System.out.println("invalido " + ent[i]);
           }
       }
    }
}
