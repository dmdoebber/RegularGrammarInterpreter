/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danie
 */
public class StringTokenizer{
    private final String word;
    private int tokenPosition;
    
    public static final int EOF = -1;
    public static final int UPPER = -2;
    public static final int LOWER = -3;
    
    public StringTokenizer(String word){
        this.word = word;
        tokenPosition = 0;
    }
    
    public boolean hasNext(){
        return tokenPosition < word.length();
    }
    
    public Character nextToken(){
        if (tokenPosition < word.length())
            return word.charAt(tokenPosition++);
        else
            return null;
    }
}
