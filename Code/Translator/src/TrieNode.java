import java.util.*;

public class TrieNode
{
    private TrieNode parent;
    private Hashtable<Integer, TrieNode> children;
    
    private boolean isLeaf;
    private char character;
    
    private boolean isWord;
    private Dictionary translatedWords;
    
    public TrieNode()
    {
        children = new Hashtable();
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
        
        if (children.get(charPos) == null)
        {
            children.put(charPos, new TrieNode(word.charAt(0)));
            children.get(charPos).parent = this;
        }
        
        if (word.length() > 1)
        {
            children.get(charPos).add(word.substring(1), language, translatedWord);
        }
        else
        {
            if (children.get(charPos).translatedWords == null)
                children.get(charPos).translatedWords = new Hashtable();
                
            children.get(charPos).isWord = true;
            children.get(charPos).translatedWords.put(language, translatedWord);
        }
    }
    
    public TrieNode getNode(char c)
    {
        return children.get(c - 'a');
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
            for (Integer key: children.keySet())
            {
                list.addAll(children.get(key).getWords());
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
            for (Integer key: children.keySet())
            {
                list.addAll(children.get(key).getWords(language));
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
