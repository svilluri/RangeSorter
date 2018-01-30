package ranger.rangesorter;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeSorterTest {

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
	public void testSortRangeValuesValidArgs() {
	String[] validArgs = {"[94133,94133]", "[94600,94699]", "[94200,94299]"};
		ArrayList<Range> expectedRangeList = new ArrayList<Range>();
		Range range1 = new Range(94133l,94133l);
		expectedRangeList.add(range1);
		
		Range range2 = new Range(94200l,94299l);
		expectedRangeList.add(range2);		
		
		Range range3 = new Range(94600l,94699l);
		expectedRangeList.add(range3);
		
		try {
			List<Range> sortedArgs = RangeSorter.sortRangeValues(validArgs);
			assertArrayEquals(expectedRangeList.toArray(), sortedArgs.toArray());
		}
		catch ( Exception ex ) {
			fail("Failed with Exception:"+ex.getMessage());
		}	
	}

	@Test
	public void testSortRangeValuesOverlapdArgs() {
	String[] validArgs = {"[94133,94133]", "[94200,94299]","[94226,94399]"};
		ArrayList<Range> expectedRangeList = new ArrayList<Range>();
		Range range1 = new Range(94133l,94133l);
		expectedRangeList.add(range1);
		
		Range range2 = new Range(94200l,94399l);
		expectedRangeList.add(range2);		
		
		try {
			List<Range> sortedArgs = RangeSorter.sortRangeValues(validArgs);
			assertArrayEquals(expectedRangeList.toArray(), sortedArgs.toArray());
		}
		catch ( Exception ex ) {
			fail("Failed with Exception:"+ex.getMessage());
		}	
	}
}
