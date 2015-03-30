import java.util.*;

//from https://code.google.com/p/google-gson/
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.io.BufferedReader;
import java.io.FileReader;

public class WordDictionary {
    private List<HashTable> words;
    
    public List<HashTable> getWords() { return this.words; }
    public void setWords(List<HashTable> words) { this.words = words; }
    
    // an empty constructor is needed for Gson to work properly.
    // It was either do this or create an entirely new empty class to inherit WordDictionary.
    public WordDictionary() {
        
    }
    
    public WordDictionary(boolean load) {        
        this.setWords(new ArrayList<HashTable>());
        
        if (load)
            this.load();
        else
        {
        	this.add(newWord("hello", "bonjour", "hola"));
        	this.add(newWord("bye", "adieu", "adios"));
        	this.add(newWord("cheese", "fromage", "queso"));
        	this.add(newWord("i", "je", "yo"));
        	this.add(newWord("me", "moi", ""));
        	this.add(newWord("you", "vous", "usted"));
        	this.add(newWord("he", "il", "él"));
        	
        	
        	this.save();
        }
    }
    
    public HashTable newWord(String english, String french, String spanish)
    {
    	HashTable temp = new HashTable();
    	temp.set("english",  english);
    	temp.set("french", french);
    	temp.set("spanish", spanish);
    	
    	return temp;
    }
    
    public void add(HashTable word)
    {
        this.words.add(word);       
    }
    
    public void load()
    {
        try 
        {
            BufferedReader reader = new BufferedReader(new FileReader("dictionary.txt"));
            Gson gson = new GsonBuilder().create();
            WordDictionary temp = (WordDictionary)gson.fromJson(reader, WordDictionary.class);
            reader.close();
            
            this.setWords(temp.getWords());
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    public void save()
    {
        try 
        {
            Writer writer = new FileWriter("dictionary.txt");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(this, writer);
            writer.close();
        }
        catch (Exception ex)
        {
            
        }
    }
    
    public Trie createTrie(String sourceLanguage)
    {
    	// from this word database, construct a Trie tree.
        Trie t = new Trie();
        for (HashTable w : words)
        {
        	if (w != null)
        	{
        		Object[] temp = w.getEntries();
        		for (int i = 0; i < temp.length; i++)
        		{
        			if (temp[i] != null)
        			{
        			Object[] tempEntry;
                	if (temp[i] instanceof ArrayList)
                	{
                    	ArrayList tempList = (ArrayList)temp[i];
                        tempEntry = tempList.toArray();        		
                	}
                	else
                        tempEntry = (Object[])temp[i];
                	
                	for (int x = 0; x < tempEntry.length; x++)
                	{
                		if (tempEntry != null)
	                		if (tempEntry[0] != sourceLanguage)
	                    		t.add((String)w.get(sourceLanguage), (String)tempEntry[0], (String)w.get(tempEntry[0]));
                	}
        			}
        		}
        	}
        		//t.add((String)w.get(sourceLanguage), destinationLanguage, (String)w.get(destinationLanguage));
        
        }
        return t;
    }
}

