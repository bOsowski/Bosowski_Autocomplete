import java.util.ArrayList;

public class BruteAutocomplete implements AutoComplete {
	WordList wordList;
	private boolean sorted = false;
	private boolean removedDuplicates = false;

	public BruteAutocomplete() {
		wordList = new WordList();
		
		if(removedDuplicates == false){
		wordList.removeDuplicates();
		removedDuplicates = true;
		}
		if(sorted == false){
		wordList.sortWords();
		sorted = true;
		}
	}

	public double weightOf(String term) { // Returns the weight of the term, or
											// 0.0 if no such term.
		for (Line line : wordList.getWordList()) {
			if (line.getWord().equals(term)) {
				return line.getWeight();
			}
		}
		return 0;
	}

	// Returns the highest weighted matching term, or null if no matching term.
	public String bestMatch(String prefix) {
		for (Line line : wordList.getWordList()) {
			if (line.getWord().startsWith(prefix)) {
				return line.getWord();
			}
		}
		return null;
	}

	// Returns the highest weighted k matching terms (in descending order of
	// weight), as an
	// iterable.
	// If fewer than k matches, return all matching terms (in descending order
	// of weight).
	public Iterable<String> matches(String prefix, int k) {
		ArrayList<String> matchingTerms = new ArrayList<String>();
		for (Line line : wordList.getWordList()) {
			if (line.getWord().startsWith(prefix) && k != 0) {
				matchingTerms.add(line.getWord());
				k--;
			}
		}

		return matchingTerms;
	}

}
