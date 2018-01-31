package ranger.rangesorter;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeValidatorTest {

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
	public void testParseAndValidateSuccess() {
		
		String[] validArgs = {"[94133,94133]", "[94200, 94299]"," [ 94200, 94399 ]"};
		ArrayList<Range> expectedRangeList = new ArrayList<Range>();
		Range range1 = new Range(94133l,94133l);
		expectedRangeList.add(range1);
		
		Range range2 = new Range(94200l,94299l);
		expectedRangeList.add(range2);		
		
		Range range3 = new Range(94200l,94399l);
		expectedRangeList.add(range3);
		
		try {
			List<Range> parsedArgs = RangeValidator.parseAndValidate(validArgs);
			assertArrayEquals(expectedRangeList.toArray(), parsedArgs.toArray());
		}
		catch ( Exception ex ) {
			fail("Failed with Exception:"+ex.getMessage());
		}		
	}

	@Test
	public void testParseAndValidateFailureInvalidRange() {
		
		String[] validArgs = {"[94133,94133]", "[94299, 94200]"," [ 94200, 94399 ]"};
		ArrayList<Range> expectedRangeList = new ArrayList<Range>();
		Range range1 = new Range(94133l,94133l);
		expectedRangeList.add(range1);
		
		Range range2 = new Range(94200l,94299l);
		expectedRangeList.add(range2);		
		
		Range range3 = new Range(94200l,94399l);
		expectedRangeList.add(range3);
		
		try {
			List<Range> parsedArgs = RangeValidator.parseAndValidate(validArgs);
			fail("Supposed to throw exception with parsing error");
		}
		catch ( Exception ex ) {
			//Suppose to fail.
		}	
	}
	
	@Test
	public void testParseAndValidateFailureNonNumeric() {
		
		String[] validArgs = {"[94133,94133]", "[94200,ABC]","[94200,94399]"};
			
		try {
			List<Range> parsedArgs = RangeValidator.parseAndValidate(validArgs);
			fail("Supposed to throw exception with parsing error");
		}
		catch ( Exception ex ) {
			//Suppose to fail.
		}		
	}
}
