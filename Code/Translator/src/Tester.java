import java.util.*;

public class Tester
{
    public Trie test;
    
    public static void main(String[] args)
    {
    	Tester t = new Tester();
    	
    }
    
    public Tester()
    {
        test = new Trie();
        
        // A
        test.add("air", "", "");
        test.add("a", "", "");
        test.add("aeroplane", "", "");        
        // B
        test.add("buy", "", "");
        test.add("balloon", "", "");        
        // C
        test.add("cake", "", "");
        test.add("cool", "", "");        
        // D
        test.add("door", "", "");        
        test.add("dare", "", "");       
        // E
        test.add("egg", "", "");
        test.add("exe", "", "");        
        // F
        test.add("face", "", "");
        test.add("fake", "", "");       
        // G
        test.add("gear", "", "");
        test.add("gray", "", "");        
        // H
        test.add("hello", "", "");
        test.add("hero", "", "");        
        // I 
        test.add("ignite", "", "");
        test.add("individual", "", "");        
        // J
        test.add("jelly", "", "");
        test.add("joy", "", "");        
        // K
        test.add("krill", "", "");
        test.add("kill", "", "");        
        // L
        test.add("line", "", "");
        test.add("lock", "", "");        
        // M
        test.add("maze", "", "");
        test.add("my", "", "");        
        // N
        test.add("no", "", "");
        test.add("nice", "", "");
        // O
        test.add("orange", "", "");
        test.add("origami", "", "");
        // P
        test.add("picture", "", "");
        test.add("perfect", "", "");
        // Q
        test.add("queen", "", "");
        test.add("queue", "", "");        
        // R
        
        // S
        
        test.add("in", "french", "test1");
        test.add("inn", "french", "test43");
        
        System.out.println(test.getWords("in", "french"));
    }
}
