package Daqg;

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
        
        return lastNode.getWords(language);
    }
}
