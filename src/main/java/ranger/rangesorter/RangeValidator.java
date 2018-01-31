package ranger.rangesorter;

import java.util.ArrayList;

import org.apache.log4j.Logger;

/**
 * Utility class to validate Range arguments.
 * 
 * @author svilluri
 *
 */
public class RangeValidator {
	
	final static Logger logger = Logger.getLogger(RangeValidator.class);
	
	/**
	 * This method parses String list and validates if Range in proper format.
	 * 
	 * @param args List of Arguments of each in <min,max> format
	 * @return parsed array list of Range.
	 * 
	 * @throws Exception
	 */
	public static ArrayList<Range> parseAndValidate(String[] args) throws Exception{
		
		logger.info("parseAndValidate:Begin");
		
		ArrayList<Range> rangeList = new ArrayList<Range>();
		for ( String arg: args) {
			String trimmedArg = arg.trim();
			int leftIdx = trimmedArg.indexOf('[');
			int rightIdx = trimmedArg.indexOf(']');
			
			if ( leftIdx < 0 || rightIdx < 0) {
				throw new Exception("Invalid Range: Missing brackets...'[' or ']' in argument: " + arg);
			}
			
			String rangeArg = trimmedArg.substring(leftIdx+1, rightIdx);
			
			String[] splittedRange = rangeArg.split(",");
			
			if ( splittedRange.length != 2 ) {
				throw new Exception("Invalid Range: Should have only two numbers in one range argument: " + splittedRange);
			}
			
			try {
				Long minVal = Long.parseLong(splittedRange[0].trim());
				Long maxVal = Long.parseLong(splittedRange[1].trim());
				
				Range rangeVal = new Range(minVal,maxVal);
				rangeList.add(rangeVal);
				
				if ( minVal > maxVal ) {
					throw new Exception("Invalid Range: Min: "+minVal+" cannot be more than Max: "+maxVal);
				}
			}
			catch (NumberFormatException ex) {
				throw new Exception("Invalid Range: Range cannot have non-numeric characters");
			}
			

		}
		
		logger.info("parseAndValidate:End");
		
		return rangeList;
	}
}
