public class Tester
{
    public Trie test;
    public WordDictionary t;
    
    public Tester()
    {
        t = new WordDictionary(true);
        
        System.out.println(t.getWords());
        
        test = t.createTrie("spanish");
        
        System.out.println(test.getWords("adios", "english"));
        
        
    }
}