import java.util.*;

public class Word {
	private Hashtable<String, String> word;
	
	public Hashtable<String, String> getWord() { return this.word; }
	
	public Word(Hashtable<String, String> word)
	{
		this.word = word;
	}
}