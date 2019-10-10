import java.util.ArrayList;
public class Word 
{
	protected String word;
	protected ArrayList<String> list;
	//initializes the instance variables, adds words to the list
	//sets word to a random String in the list 
	public Word()
	{
		list = new ArrayList<String>();
		list.add("cat");
		list.add("dog");
		list.add("man");
		list.add("woman");
		list.add("ball");
		list.add("duck");
		list.add("apple");
		list.add("soul");
		list.add("food");
		list.add("boat");
		list.add("banana");
		list.add("truck");
		word = list.get((int) (Math.random()*list.size()));
	}
	//returns a random word in the list
	public String getWord()
	{
		return word;
	}
	//takes a String as a parameter and returns the number of letters in that String
	public int getNumLetters(String word)
	{
		int count = 0;
		for(int i = 0; i < word.length(); i ++)
		{
			count++;
		}
		return count;
	}
	//checks to see if the letter guessed is in the word, and if it is, it returns true, else, false
	public boolean correctGuess(String word, String guess)
	{
		if(word.indexOf(guess) == -1)
		{
			return false;
		}
		else 
		{
			return true;
		}
	}
	//Takes two strings as a parameter and creates arrayList of integers that contains the indexes 
	//where guess appears in word
	public ArrayList<Integer> getIndex(String word, String guess)
	{
		String lost = "";
		ArrayList<Integer> index = new ArrayList<Integer>();
		while(word.indexOf(guess) != -1 && word.length()>=0)
		{
			index.add(word.indexOf(guess) + this.getNumLetters(lost));
			word = word.substring(word.indexOf(guess)+1);
			lost = word.substring(0, word.indexOf(guess)+1) +lost;
		}
		return index;
	}
	//Takes an arrayList of Strings as a parameter and formats these as a String 
	//to make it easier to draw the incorrect guesses
	public String toStringWrong(ArrayList<String> wrong)
	{
		String str = "";
		for(int i = 0; i < wrong.size(); i++)
		{
			str += wrong.get(i) + "   ";
		}
		return str;
	}
}
