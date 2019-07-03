import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
            
            if (!gr.validateGrammarGLD())
            {
                System.out.println("Gramatica inválida! ");
                return;
            }
            
            System.out.println(gr);
            
            
            System.out.println("\nEntre com a palavra a ser testada: ");
            String entrada = new Scanner(System.in).nextLine();
            
            SyntaticAnalyzer analyzer = new SyntaticAnalyzer();
            
            Node root = new Node(gr.getInitial_state(), null, 0);
            
            List<String> children = gr.getProduction_rules().get(gr.getInitial_state());
            
            for(String child : children)
                root.children.add(new Node(child, root, 0));
            
            analyzer.generateTree(root, gr.getProduction_rules());
            
            String s = "";
            for(Node n : analyzer.getRoot().children)
                analyzer.SearchSymbol(n, entrada, 0, s);
            
            if(analyzer.validWord)
                System.out.println("Palavra válida!");
            else
                System.out.println("Palavra inválida!");

            
        } catch (FileNotFoundException ex) {
            System.out.println("File not found! " + ex);
        } catch (IOException | ParseException ex) {
            System.out.println("Parse " + ex);
        }
    }
}