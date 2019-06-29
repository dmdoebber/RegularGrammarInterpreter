
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
    
    public Node getRoot()
    {
        return this.root;
    }
    
    public void setRoot(Node r)
    {
        this.root = r;
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
                Node no = new Node(prod.getKey().charAt(0), null, cont);
                for(Character c : str.toCharArray())
                {
                    Node newNode = new Node(c, no, cont);
                    no.children.add(newNode);
                }               
            }
            cont++;
        }
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
