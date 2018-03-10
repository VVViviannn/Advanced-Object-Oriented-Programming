package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import implementation.Counter;

public class TestCounter {
	
	@Test
	public void testInitValZeroThenInc() {
		Counter c = new Counter(0);
		assertTrue(c.getValue() == 0);
		c.increment();
		assertTrue(c.getValue() == 1);
	}

	@Test
	public void testInitValZeroThenDec() {
		Counter c = new Counter(0);
		assertTrue(c.getValue() == 0);
		try {
			c.decrement();
			/* Expected precondition violation did not occur. */
			fail("Too small to decrement, but no exception thrown.");
		}
		catch(IllegalArgumentException e) {
			/* Expected precondition violation occurred. */
		}
	}

}
