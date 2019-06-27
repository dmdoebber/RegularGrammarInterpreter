import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.json.simple.parser.ParseException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author danie
 */
public class main {
    
    public static void main(String[] args){
        try {
            GrammarReader gr = new GrammarReader("gr.json");
            String entrada = new Scanner(System.in).nextLine();
            StringTokenizer str = new StringTokenizer(entrada);
            
            System.out.println(gr.validateGrammarGLD());
            
            while(str.hasNext())
            {
                char token = str.nextToken();
                String sToken = Character.toString(token);
                
                System.out.println(token);
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("File not found! " + ex);
        } catch (IOException | ParseException ex) {
            System.out.println("Parse " + ex);
        }
    }
    
    /*
    public List<String> findProduction(String token){
        List<String> ok = new ArrayList<>();
        
        for(String prod : producoes){
            if (prod.startsWith(token))
                ok.add(prod);
        }
        
        return ok;
    }*/
}