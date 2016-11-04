import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BruteAutocompleteTest {
	public BruteAutocomplete autocomplete;

	@Before
	public void setUp(){
		autocomplete = new BruteAutocomplete();
	}

	@After
	public void tearDown(){
	}

	@Test //checks weights of the words as they should be on the wiktionary
	public void testWeightOf() {
		assertEquals(5627187200.0,autocomplete.weightOf("the"),0.01);
		assertEquals(925310.0,autocomplete.weightOf("aimed"),0.01);
		assertEquals(435440.0,autocomplete.weightOf("tackle"),0.01);
		assertEquals(392323.0,autocomplete.weightOf("calves"),0.01);
	}
	
	@Test //tests if the best match returns the correct best matching term
	public void testBestMatch(){
		assertEquals("the",autocomplete.bestMatch("t"));
		assertEquals("that",autocomplete.bestMatch("tha"));
		assertEquals("could",autocomplete.bestMatch("co"));
		
	}

	
	@Test //tests if the method displays correct terms and the number of them
	public void testMatches(){
		assertEquals("[the, that, this]", autocomplete.matches("th", 3).toString());
		assertEquals("[the, of, and, to, in]", autocomplete.matches("", 5).toString());
		assertEquals("[calves]", autocomplete.matches("calv", 3).toString());
	}
}
