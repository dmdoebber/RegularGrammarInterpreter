
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
public class GrammarReader {
    private final List<String> non_terminal;
    private final List<String> terminal;
    private final HashMap<String, List<String>> production_rules;
    private final String initial_state;

    public GrammarReader(String filename) throws IOException, FileNotFoundException, ParseException{
        FileReader reader = new FileReader(filename);
        JSONObject json = (JSONObject) new JSONParser().parse(reader);
        
        non_terminal = (JSONArray) json.get("V");
        terminal = (JSONArray) json.get("T");
        production_rules = (JSONObject) json.get("P");
        initial_state = (String) json.get("S");
    }
    
    public boolean validateGrammarGLD(){
        for(Map.Entry<String, List<String>> prod : production_rules.entrySet()){
            for(String str : prod.getValue()){
                
                for (int i = 0; i < str.length(); i++){
                    if (Character.isUpperCase(str.charAt(i))){
                        if (i == str.length() - 1)
                            return true;
                        return false;
                    }
                }
            }
        }
        
        return true;
    }

    public List<String> getNon_terminal() {
        return non_terminal;
    }

    public List<String> getTerminal() {
        return terminal;
    }

    public HashMap<String, List<String>> getProduction_rules() {
        return production_rules;
    }

    public String getInitial_state() {
        return initial_state;
    }
    
    @Override
    public String toString() {
        String s = "";
        
        s += "Não terminais =" + non_terminal + "\n";
        
        s += "Terminais = " + terminal + "\n";
        
        for (Map.Entry<String, List<String>> entry : production_rules.entrySet())
        {
            s += entry.getKey() + "-> " + entry.getValue() + "\n";
        }

        production_rules.entrySet().forEach((entry) -> {
            Map.Entry pair = (Map.Entry) entry;
            String key = pair.getKey().toString();            
            JSONArray array = (JSONArray) pair.getValue();
        });
        
        s += "Estado Inicial = [";
        s += initial_state;
        s += "]\n";       
            
        return s;
    }
}
