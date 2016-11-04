import java.util.ArrayList;
import java.io.IOException;
import java.net.*;
import java.io.*;

public class WordList {
	private ArrayList<Line> wordList = new ArrayList<Line>();
	private String url = "https://wit-computing.github.io/algorithms-2016/topic04/book-2/data/wiktionary.txt";

	public WordList() {
		try {
			getUrlContents(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Line> getWordList() {
		return wordList;
	}

	public void getUrlContents(String theUrl) throws IOException {
		String line;

		URL url = new URL(theUrl); // create a url object.
		URLConnection urlConnection = url.openConnection();	//create a url connection object.
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));	//wrap the url connection in a bufferedreader.
		while ((line = bufferedReader.readLine()) != null) {
			String[] splitLine = line.split("\\s+");	//split the line between sequences of one or more whitespace characters.
			if (splitLine.length == 3) {	//the desired terms are split in three.
				double weight = Double.parseDouble(splitLine[1]);	//first split is the number.
				wordList.add(new Line(weight, splitLine[2]));	//second split is the word. Wrap the two splits in the Line object and add that object to the wordList ArrayList.
			}
		}
	}
	
	//compares each term against every other term and removes the other term if it's the same as itself.
	public void removeDuplicates()
	{
		for (int i = 0; i < wordList.size(); i++) {
			for (int j = 0; j < wordList.size(); j++) {
				if (!wordList.get(i).equals(wordList.get(j)) && wordList.get(i).getWord().equals(wordList.get(j).getWord())) {
					wordList.remove(j);
					i--;	//bug fix (the arraylist would change index of all remaining terms to fill the empty gap after a removed object and with many duplicate terms it would skip a portion of them and not remove all duplicates.
				}
			}
		}
	}
	
	//compares each term against every other and if the other one has a bigger weight, it swaps them around
	public void sortWords() {

		for (int i = 0; i < wordList.size(); i++) {
			for (int j = 0; j < wordList.size(); j++) {
				
				if (wordList.get(i).getWeight() > wordList.get(j).getWeight()) {
					
					Line temporaryObject = wordList.get(i);	//a temporary object to put the first object into
					wordList.set(i, wordList.get(j));	//replace the current, smaller term with the other bigger one
					wordList.set(j, temporaryObject);	//replace the other bigger term with the smaller one.
				} 
			}
		}
	}

}
