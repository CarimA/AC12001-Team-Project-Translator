
public class Tester
{
    public Trie test;
    public Tester()
    {
        test = new Trie();
        
        test.add("hello", "spanish", "hola");
        test.add("hello", "french", "bonjour");
        
        System.out.println(test.getWords("h").toString());
    }
}
