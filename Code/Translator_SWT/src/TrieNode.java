import java.util.*;

public class TrieNode
{
    private TrieNode parent;
    private HashTable children;
    
    private boolean isLeaf;
    private char character;
    
    private boolean isWord;
    private Dictionary translatedWords;
    
    public Dictionary getTranslatedWords() { return this.translatedWords; }
    
    public TrieNode()
    {
        children = new HashTable();
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
            children.set(charPos, new TrieNode(word.charAt(0)));
            ((TrieNode)children.get(charPos)).parent = this;
        }
        
        if (word.length() > 1)
        {
            ((TrieNode)children.get(charPos)).add(word.substring(1), language, translatedWord);
        }
        else
        {
            if (((TrieNode)children.get(charPos)).translatedWords == null)
                ((TrieNode)children.get(charPos)).translatedWords = new Hashtable();
                
            ((TrieNode)children.get(charPos)).isWord = true;
            ((TrieNode)children.get(charPos)).translatedWords.put(language, translatedWord);
        }
        
        System.out.println(children);
    }
    
    public TrieNode getNode(char c)
    {
        return (TrieNode)children.get(c - 'a');
    }
    public List<Dictionary> getWords()
    {
        List<Dictionary> list = new ArrayList<Dictionary>();

        if (isWord)
        {
            list.add(translatedWords);
        }
        
        if (!isLeaf)
        {
            for (int i = 0; i < children.size(); i++)
            {
            	//System.out.println(children.get(i));
            	if (children.get(i) != null)
            		list.add(((TrieNode)children.get(i)).getTranslatedWords());
            	//list.addAll(((TrieNode)temp[i]).getWords());
            	//list.addAll(temp[i].getWords());
                //list.addAll(((TrieNode)temp[i]).getWords());
            }
        }
        
        return list;
    }
    
    /*public List getWords()
    {
        List list = new ArrayList();

        
        if (isWord)
        {
            list.add(toString());
        }
        
        if (!isLeaf)
        {
            for (int i = 0; i < children.size(); i++)
            {
            	//System.out.println(children.get(i));
            	if (children.get(i) != null)
            		list.addAll((ArrayList)((TrieNode)children.get(i)).getWords());
            	//list.addAll(((TrieNode)temp[i]).getWords());
            	//list.addAll(temp[i].getWords());
                //list.addAll(((TrieNode)temp[i]).getWords());
            }
        }
        
        return list;
    }*/
    
    public List<Dictionary> getWords(String language)
    {
    	List<Dictionary> list = new ArrayList();
        
        if (isWord)
        {
            list.add(translatedWords);
        }
        
        if (!isLeaf)
        {
            Object[] temp = children.getEntries();
            
            for (int i = 0; i < temp.length; i++)
            {
                list.add(((TrieNode)temp[i]).getTranslatedWords());
            }
        }
        
        return list;
    }
    
    /*public List getWords(String language)
    {
        List list = new ArrayList();
        
        if (isWord)
        {
            list.add(translatedWords.get(language));
        }
        
        if (!isLeaf)
        {
            Object[] temp = children.getEntries();
            
            for (int i = 0; i < temp.length; i++)
            {
                list.addAll(((TrieNode)temp[i]).getWords());
            }
        }
        
        return list;
    }*/
   
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