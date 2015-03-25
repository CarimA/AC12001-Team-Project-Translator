import java.util.*;

/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tester
{
    List<HashTable> words;
    
    // instance variables - replace the example below with your own
    static void main(String[] args)
    {
        Tester t = new Tester();
        //System.out.println(hash.get("test2"));
    }
    
    public Tester()
    {
        words = new ArrayList<HashTable>();
        
        words.add(addWord("hello", "hola", "bonjour"));
        words.add(addWord("bye", "adios", "au revoir"));        
        
        System.out.println(getWord("hello", "english", "french"));
       // System.out.println(getWord(0, "spanish"));
    }
    
    String getWord(int index, String language)
    {
        return ((HashTable)(words.get(index).get("word"))).get(language).toString();
    }
    
    String getWord(String baseWord, String baseLanguage, String targetLanguage)
    {
        for (HashTable h : words)
        {
            HashTable temp = (HashTable)h.get("word");
            
            if (temp.get(baseLanguage) == baseWord)
                return temp.get(targetLanguage).toString();                
        }
        
        return null;
    }
    
    HashTable addWord(String eng, String spa, String fre)
    {
        HashTable hash;
        HashTable lang;
        
        hash = new HashTable();
 
        lang = new HashTable();
        lang.set("english", eng);
        lang.set("spanish", spa);
        lang.set("french", fre);
        
        hash.set("word", lang);
        
        return hash;
    }
}
