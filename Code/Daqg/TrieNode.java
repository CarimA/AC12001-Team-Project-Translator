import java.util.*;

public class TrieNode
{
    private TrieNode parent;
    private TrieNode[] children;
    
    private boolean isLeaf;
    private char character;
    
    private boolean isWord;
    private Dictionary translatedWords;
    
    public TrieNode()
    {
        children = new TrieNode[26];
        isLeaf = true;
        isWord = false;
    }
    
    public TrieNode(char character)
    {
        this();
        this.character = character;
    }
    
    public void add(String word, String language, String translatedWord)
    {
        this.isLeaf = false;
        
        int charPos = word.charAt(0) - 'a';
        
        if (children[charPos] == null)
        {
            children[charPos] = new TrieNode(word.charAt(0));
            children[charPos].parent = this;
        }
        
        if (word.length() > 1)
        {
            children[charPos].add(word.substring(1), language, translatedWord);
        }
        else
        {
            if (children[charPos].translatedWords == null)
                children[charPos].translatedWords = new Hashtable();
                
            children[charPos].isWord = true;
            children[charPos].translatedWords.put(language, translatedWord);
        }
    }
    
    public TrieNode getNode(char c)
    {
        return children[c - 'a'];
    }
    
    public List getWords()
    {
        List list = new ArrayList();
        
        if (isWord)
        {
            list.add(toString());
        }
        
        if (!isLeaf)
        {
            for (int i = 0; i < children.length; i++)
            {
                if (children[i] != null)
                    list.addAll(children[i].getWords());
            }
        }
        
        return list;
    }
    
    public List getWords(String language)
    {
        List list = new ArrayList();
        
        if (isWord)
        {
            list.add(translatedWords.get(language));
        }
        
        if (!isLeaf)
        {
            for (int i = 0; i < children.length; i++)
            {
                if (children[i] != null)
                    list.addAll(children[i].getWords(language));
            }
        }
        
        return list;
    }

    public String toString()
    {
        if (parent == null)
        {
            return "";
        }
        else
        {
            return parent.toString() + new String(new char[] {character});
        }
    } 
}
