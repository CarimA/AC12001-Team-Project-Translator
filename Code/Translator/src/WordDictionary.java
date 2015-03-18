import java.util.*;

//from https://code.google.com/p/google-gson/
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.io.BufferedReader;
import java.io.FileReader;

public class WordDictionary {
	private List<Word> words;
	
	public List<Word> getWords() { return this.words; }
	public void setWords(List<Word> words) { this.words = words; }
	
	public WordDictionary() {
		Hashtable<String, String> t = new Hashtable<String, String>();
		t.put("english", "hello");
		t.put("french", "bonjour");
		t.put("spanish", "hola");
		
		add(new Word(t));
		
	}
	
	public void add(Word word)
	{
		this.words.add(word);		
	}
	
	public void save()
	{
		try 
		{
			BufferedReader reader = new BufferedReader(new FileReader("dictionary.json"));
			Gson gson = new GsonBuilder().create();
			WordDictionary temp = gson.fromJson(reader, WordDictionary.class);
			reader.close();
			
			this.setWords(temp.getWords());
		}
		catch (Exception ex)
		{
			
		}
	}
	
	public void load()
	{
		try 
		{
			Writer writer = new FileWriter("dictionary.json");
			Gson gson = new GsonBuilder().create();
			gson.toJson(this, writer);
		}
		catch (Exception ex)
		{
			
		}
	}
	
	public Trie createTrie(String sourceLanguage, String destinationLanguage)
	{
		Trie t = new Trie();
		for (Word w : words)
		{
			t.add(w.getWord().get(sourceLanguage), destinationLanguage, w.getWord().get(destinationLanguage);
		}
		return t;
	}
}


