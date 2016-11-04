import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.Before;
import org.junit.After;


public class LineTest {
	
	public Line line;
	
	@Before
	public void setup()
	{
		line = new Line(123,"onetwothree");
	}
	
	@After
	public void tearDown()
	{
		line = null;
	}

	@Test
	public void testGettersSetters()
	{
		assertEquals(123,line.getWeight(),0.01);
		assertEquals("onetwothree",line.getWord());
		line.setWord("fivesix");
		assertEquals("fivesix",line.getWord());
		line.setWeight(21);
		assertEquals(21,line.getWeight(),0.01);
		line.setWeight(-1);
		assertEquals(0,line.getWeight(),0.01);
	}
	
	@Test
	public void testContructor()
	{
		Line ln = new Line(12,"ONETWOTHREE");
		assertEquals("onetwothree",ln.getWord());
		assertEquals(12,ln.getWeight(),0.01);
		Line ln1 = new Line(-12,null);
		assertEquals(null,ln1.getWord());
		assertEquals(0,ln1.getWeight(),0.01);
	}
	
	@Test
	public void testToString() {
		assertEquals("Line [weight=123.0, word=onetwothree]",line.toString());
	}

}
