import java.util.*;

public class Trie
{
    private TrieNode root;
    
    public TrieNode getRoot() { return this.root; }
    public void setRoot(TrieNode root) { this.root = root; }
    
    public Trie()
    {
        this.setRoot(new TrieNode());
    }
    
    public void add(String word, String language, String translatedWord)
    {
        root.add(word.toLowerCase(), language.toLowerCase(), translatedWord.toLowerCase());
    }

    public List<Dictionary> getWords(String prefix)
    {
        TrieNode lastNode = this.getRoot();
        
        for (int i = 0; i < prefix.length(); i++)
        {
            lastNode = lastNode.getNode(prefix.charAt(i));
            
            // no node match; no words exist for this.
            if (lastNode == null)return new ArrayList();
        }
        
        return lastNode.getWords();
    }
    
    public List<Dictionary> getWords(String prefix, String language)
    {
        TrieNode lastNode = this.getRoot();
        
        for (int i = 0; i < prefix.length(); i++)
        {
            lastNode = lastNode.getNode(prefix.charAt(i));
            
            // no node match; no words exist for this.
            if (lastNode == null)return new ArrayList();
        }
        
        return lastNode.getWords();
    }
    
    public String getWord(String word, String source, String language)
    {    	
    	for (Dictionary d : this.getWords(word, language))
    	{
    		System.out.println(d.get(source));
    		System.out.println(d.get(language));
    		
    		if (word.equals((String)d.get(source)))
    			return (String)d.get(language);
    		//	return 
    		//if (this.getWords(word, source) == word)
    		//	return d;
    	}
    	
    	return null;
    }
    

    public String translate(String input, String source, String language)
    {
    	// start by replacing words with known phrases.
    	
    	// split the input using space as a delimiter
    	String[] split = input.split(" ");
    	String temp = "";
    	
    	// NOTE TO SELF:
    	// REPLACE THE += WITH STRINGBUILDER, THIS SENDS THE GARBAGE COLLECTOR INTO OVERDRIVE OTHERWISE.
    	
    	for (String s : split)
    	{
    		String tempSplit = this.getWord(s.toLowerCase().replaceAll("\\p{P}", ""), source, language);
    		if (tempSplit != null)
    		{
    			temp += tempSplit + " ";
    		}
    		else
    		{
    			// it doesn't exist. oops.
    			temp += "~" + s + "~ ";
    		}
    	}
    	
    	temp = temp.trim();
    	return temp;
    }
}