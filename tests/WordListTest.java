import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WordListTest {
	public WordList wordlist;
	
	@Before
	public void setup(){
		wordlist = new WordList();
	}
	
	@After
	public void teardown(){
	}
	
	@Test //checks if there are the appropriate amount of terms in the list
	public void testGetUrlContents(){
		assertEquals(10000,wordlist.getWordList().size());
	}	
	
	@Test
	public void testSortWords(){
		wordlist.getWordList().add(new Line(0.0,"aaa11"));
		assertEquals(10001,wordlist.getWordList().size());
		wordlist.getWordList().add(new Line(5627187201.0,"QQQ11"));
		assertEquals(10002,wordlist.getWordList().size());
		wordlist.sortWords();
		assertEquals("qqq11",wordlist.getWordList().get(0).getWord());
		assertEquals("aaa11",wordlist.getWordList().get(wordlist.getWordList().size()-1).getWord());
		assertEquals(10002,wordlist.getWordList().size());
	}
	
	@Test
	public void testRemoveDuplicates(){
		assertEquals(10000,wordlist.getWordList().size());
		wordlist.getWordList().add(new Line(3,"333"));
		wordlist.getWordList().add(new Line(3,"333"));
		wordlist.getWordList().add(new Line(3,"333"));
		wordlist.getWordList().add(new Line(3,"222"));
		wordlist.getWordList().add(new Line(3,"222"));
		wordlist.getWordList().add(new Line(3,"222"));
		wordlist.getWordList().add(new Line(3,"222"));
		wordlist.getWordList().add(new Line(3,"222"));
		wordlist.getWordList().add(new Line(3,"222"));
		wordlist.getWordList().add(new Line(3,"222"));
		wordlist.getWordList().add(new Line(3,"222"));
		wordlist.getWordList().add(new Line(3,"222"));
		wordlist.getWordList().add(new Line(3,"222"));
		wordlist.getWordList().add(new Line(3,"222"));
		wordlist.getWordList().add(new Line(3,"222"));
		wordlist.getWordList().add(new Line(3,"222"));
		assertEquals(10016,wordlist.getWordList().size());
		wordlist.removeDuplicates();
		assertEquals(10002,wordlist.getWordList().size());
		
	}

}
