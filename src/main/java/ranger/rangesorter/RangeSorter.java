package ranger.rangesorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Utility class to validate Range arguments.
 * 
 * @author svilluri
 *
 */
public class RangeSorter {

	final static Logger logger = Logger.getLogger(RangeSorter.class);
	
	/**
	 * This method parses and sorts input range array and returns sorted Range list
	 * 
	 * @param args List of Strings
	 * 
	 * @return sorted list of Ranges. If parsing fails, it returns null
	 */
	public static List<Range> sortRangeValues(String[] args) throws Exception {
		
		logger.info("sortRangeValues: Begin");
		
		List<Range> newList = new ArrayList<Range>();
		
		try {
			List<Range> ranges = RangeValidator.parseAndValidate(args);
			Collections.sort(ranges, new RangeComparator());

			Range previousVal = null;
			for (Range rangeVal:ranges) {
				if ( previousVal == null ) {
					previousVal = rangeVal;
					newList.add(rangeVal);
				}
				else
				if ( !previousVal.equals(rangeVal) ) {
					if ( !previousVal.contains(rangeVal) ) {
						Range combinedVal = previousVal.overlaps(rangeVal);
						if ( combinedVal != null ) {
							newList.add(combinedVal);
							newList.remove(previousVal);
							previousVal=combinedVal;
						}
						else { //Doesn't contains or Overlaps
							newList.add(rangeVal);
							previousVal=rangeVal;
						}
					}
				}
			}

		}
		catch ( Exception ex ) {
			System.out.println("Failed with reason: " + ex.getMessage() );
			throw ex;
		}
		
		logger.info("sortRangeValues: End");
		
		return newList;
	}
}
