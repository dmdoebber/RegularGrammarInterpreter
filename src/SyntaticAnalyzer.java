
import static java.lang.System.in;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author carol
 */
public class SyntaticAnalyzer {
    
    private Node root;
    private HashMap<String, List<String>> rules;
    public boolean symbolFound = false;
    
    public Node getRoot()
    {
        return this.root;
    }
    
    public void setRoot(Node r)
    {
        this.root = r;
    }
    
    public void VerifyGR(HashMap<String, List<String>> hashRules, String entrada, String ini)
    {
        this.rules = hashRules;
        
        int cont = 0;
        for(Map.Entry<String, List<String>> prod : rules.entrySet())
        {
            for(String str : prod.getValue())
            {
                
            }
        }
    }
    
    public void generateTree(Node r, HashMap<String, List<String>> hashRules)
    {
        this.root = r;  
        this.rules = hashRules;
        
        int cont = 0;
        for(Map.Entry<String, List<String>> prod : rules.entrySet())
        {
            for(String str : prod.getValue())
            {
                if(!root.getSymbol().equals(prod.getKey()))
                {
                    Node no = new Node(prod.getKey(), null, cont);
                
                    Node newNode = new Node(str, no, cont);                        
                    no.children.add(newNode);
                }
                else
                {                  
                    Node newNode = new Node(str, root, cont);                        
                    root.children.add(newNode);                  
                }
            }
            cont++;
        }
    }
    
    public void SearchSymbol(Node n, String symbol, int position, String alreadyValidated)
    {   
        if(n == null)
        {
            if(symbol.equals(alreadyValidated.toString()))
                System.out.println("Palavra válida!");
            else
                return;
        }            
        
        if(!n.getSymbol().isEmpty())
        {
            int countPosChanged = 0;
            String analyzed = "";
            StringBuilder strB = new StringBuilder(analyzed);
            StringBuilder strBuilder = new StringBuilder(alreadyValidated);
            for(Character c : n.getSymbol().toCharArray())
            {               
                if(c.toString().equals(c.toString().toUpperCase()))
                {
                    position += countPosChanged;
                    strBuilder.append(analyzed);
                    alreadyValidated = strBuilder.toString();
                    //Node parent = FindNode(root, c.toString());
                    for(Node nodezinho : n.children)
                        SearchSymbol(nodezinho, symbol, position, alreadyValidated);
                }
                else
                    if(c.equals(symbol.charAt(position+countPosChanged)))
                    {
                        countPosChanged++;
                        strB.append(c.toString());
                        analyzed = strB.toString();
                    }
                
            }
        }
        
        /*for(Node m : n.children)
        {
            SearchSymbol(m, symbol, position, alreadyValidated);
        }*/
    }
    
    public Node FindNode(Node n, String symbol)
    {
        if(n.getSymbol().equals(symbol))
            return n;
        
        for(Node m : n.children)
            FindNode(m, symbol);
        
        return null;
    }
    
}
