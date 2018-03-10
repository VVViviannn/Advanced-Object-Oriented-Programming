package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import implementation.Person;

public class TestPerson {

	@Test
	public void testPositiveWeight() {
		Person p = new Person("");
		p.getWeight();
		assertTrue(p.getWeight() >= 0);
	}
	
	public void testPositiveHeight() {
		Person p = new Person("");
		assertTrue(p.getHeight() == 0);
		try {
			p.getHeight();
			/* Expected precondition violation did not occur. */
			fail("not positive, but no exception thrown.");
		}
		catch(IllegalArgumentException e) {
			/* Expected precondition violation occurred. */
		}
	}
	
	public void testBMIvalue() {
		
		Person p = new Person("");
	    p.setWeight(76.2);
	    p.setHeight(1.73);
		assertTrue(p.getBMI() == 25.5);
	}
}
