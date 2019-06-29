
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author carol
 */
public class Node {
    
    private Node parent;    
    private boolean isTerminal;
    private Character symbol;
    private int index;
    
    public List<Node> children;
    
    public Node(Character s, Node p, int i)
    {
        this.parent = p;
        this.symbol = s;
        this.index = i;
        
        this.children = new ArrayList<>();
    }
    
    public Node getParent()
    {
        return this.parent;
    }
    
    public void setParent(Node p)
    {
        this.parent = p;
    }
    
    public boolean isTerminal()
    {
        return this.isTerminal;
    }
    
    public void setIfIsTerminal(boolean isT)
    {
        this.isTerminal = isT;
    } 
    
    public Character getSymbol()
    {
        return this.symbol;
    }
    
    public void setSymbol(Character c)
    {
        this.symbol = c;
    }
    
    public void AddChildNode(Node n)
    {
        children.add(n);
    }
}
