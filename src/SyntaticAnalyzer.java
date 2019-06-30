
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
            Node exists = FindNode(root, prod.getKey());
            if(exists == null)
                exists = new Node(prod.getKey(), null, cont);
                    
            for(String str : prod.getValue())
            {
                if(!prod.getKey().equals(root.getSymbol()))
                {
                    Node newNode = new Node(str, exists, cont);                        
                    exists.children.add(newNode);
                }                    
            }
            if(!prod.getKey().equals(root.getSymbol()))
                insertNode(root, exists.getSymbol(), exists);
            //cont++;
        }
    }
    
    public void SearchSymbol(Node n, String symbol, int position, String alreadyValidated)
    {          
        if(symbol.equals(alreadyValidated.toString()))
            System.out.println("Palavra válida!");
        else
            return;                  
        
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
                    //for(Node nodezinho : n.children)
                    Node nodezinho = FindNode(root, c.toString());
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
    
    public void insertNode(Node n, String symbol, Node toBeInserted)
    {
        if(n.getSymbol().contains(symbol))
        {
            n.children = toBeInserted.children;
        }
        else
            for(Node m : n.children)
                insertNode(m, symbol, toBeInserted);      
        
    }
    
    public Node FindNode(Node n, String symbol)
    {
        if(n.getSymbol().contains(symbol))
            return n;
        
        for(Node m : n.children)
            n = FindNode(m, symbol);
        
        return n;
    }
    
}
