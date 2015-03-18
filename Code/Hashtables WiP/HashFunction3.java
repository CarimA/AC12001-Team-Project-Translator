
import java.util.Scanner;

/*The following code is a modified version Derek banas Hastable code from
 * http://www.newthinktank.com/2013/03/java-hash-tables-3/
 * which is completely open source and free to use
 * 
 */
public class HashFunction3 {

	WordList[] theArray;
	int arraySize;
	int itemsInArray = 0;

	public String[][] elementsToAdd = {
			{ "Good Morning", "Bonjour", "Buenos Días" },
			{ "act", "Take action", "" },
			{ "add", "Join (something) to something else", "" },
			{ "age", "Grow old", "" },
			{ "ago", "Before the present", "" },
			};

	public int stringHashFunction(String wordToHash) {

		int hashKeyValue = 0;

		for (int i = 0; i < wordToHash.length(); i++) {

			int charCode = wordToHash.charAt(i) - 96;

			int hKVTemp = hashKeyValue;

			hashKeyValue = (hashKeyValue * 27 + charCode) % arraySize;
		}
		System.out.println();

		return hashKeyValue;

	}

	HashFunction3(int size) {

		arraySize = size;

		theArray = new WordList[size];

		for (int i = 0; i < arraySize; i++) {

			theArray[i] = new WordList();

		}

		addTheArray(elementsToAdd);

	}

	public void insert(Word newWord) {

		String wordToHash = newWord.theWord;

		int hashKey = stringHashFunction(wordToHash);

		theArray[hashKey].insert(newWord, hashKey);

	}

	public Word find(String wordToFind) {

		int hashKey = stringHashFunction(wordToFind);

		Word theWord = theArray[hashKey].find(hashKey, wordToFind);

		return theWord;

	}

	public void addTheArray(String[][] elementsToAdd) {

		for (int i = 0; i < elementsToAdd.length; i++) {

			String word = elementsToAdd[i][0];
			String french = elementsToAdd[i][1];
			String spanish = elementsToAdd[i][2];

			Word newWord = new Word(word, french, spanish);

			insert(newWord);

		}

	}

	public void displayTheArray() {

		for (int i = 0; i < arraySize; i++) {

			System.out.println("theArray Index " + i);

			theArray[i].displayWordList();

		}

	}

}

class Word {

	public String theWord;
	public String french;
	public String spanish;

	public int key;

	public Word next;

	public Word(String theWord, String french, String spanish) {

		this.theWord = theWord;
		this.french = french;
		this.spanish = spanish;

	}

	public String toString() {

		return theWord + " : " + french+ ":" +spanish;

	}

}

class WordList {


	public Word firstWord = null;

	public void insert(Word newWord, int hashKey) {

		Word previous = null;
		Word current = firstWord;

		newWord.key = hashKey;

		while (current != null && newWord.key > current.key) {

			previous = current;
			current = current.next;

		}

		if (previous == null)
			firstWord = newWord;

		else
			previous.next = newWord;

		newWord.next = current;

	}

	public void displayWordList() {

		Word current = firstWord;

		while (current != null) {

			System.out.println(current);
			current = current.next;

		}

	}

	public Word find(int hashKey, String wordToFind) {

		Word current = firstWord;

		while (current != null && current.key <= hashKey) {

			// NEW

			if (current.theWord.equals(wordToFind))
				return current;

			current = current.next;

		}

		return null;

	}

	public static void main(String [] args){
	    
		Scanner input = new Scanner(System.in);

		HashFunction3 wordHashTable = new HashFunction3(5);
		
		String wordLookUp = "a";

		while (!wordLookUp.equalsIgnoreCase("x")) {

			System.out.println(": ");

			wordLookUp = Genio.getString();

			System.out.println(wordHashTable.find(wordLookUp));

		}

		wordHashTable.displayTheArray();

	}
}