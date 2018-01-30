package ranger.rangesorter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testToString() {
		Range newRangeVal = new Range(1000l, 1350l);
		String expectedResult = "[1000,1350]";
		assertEquals(expectedResult,newRangeVal.toString());
	}

	@Test
	public void testCompareToLesser() {
		Range firstVal = new Range(2000l, 2500l);
		Range secondVal = new Range(2100l, 2400l);
		assertEquals(-1, firstVal.compareTo(secondVal));
	}

	@Test
	public void testCompareToHigher() {
		Range firstVal = new Range(2100l, 2500l);
		Range secondVal = new Range(2000l, 2300l);
		assertEquals(1, firstVal.compareTo(secondVal));
	}
	
	@Test
	public void testContains() {
		Range firstVal = new Range(2100l, 2500l);
		Range secondVal = new Range(2300l, 2400l);
		assertTrue(firstVal.contains(secondVal));
	}

	@Test
	public void testContainsNot() {
		Range firstVal = new Range(2100l, 2500l);
		Range secondVal = new Range(2600l, 2700l);
		assertFalse(firstVal.contains(secondVal));
	}
	
	@Test
	public void testOverlaps() {
		Range firstVal = new Range(2100l, 2300l);
		Range secondVal = new Range(2200l, 2400l);
		Range expectedVal = new Range(2100l, 2400l);
		Range overlappedVal = firstVal.overlaps(secondVal);
		assertTrue(expectedVal.equals(overlappedVal));
	}

	@Test
	public void testOverlapsNot() {
		Range firstVal = new Range(2100l, 2300l);
		Range secondVal = new Range(2600l, 2700l);
		Range overlappedVal = firstVal.overlaps(secondVal);
		assertTrue(overlappedVal == null);
	}
	
	@Test
	public void testEquals() {
		Range firstVal = new Range(2100l, 2300l);
		Range secondVal = new Range(2100l, 2300l);
		assertTrue(firstVal.equals(secondVal));
	}
	
	@Test
	public void testEqualsNot() {
		Range firstVal = new Range(2100l, 2300l);
		Range secondVal = new Range(2400l, 2500l);
		assertFalse(firstVal.equals(secondVal));
	}
}
