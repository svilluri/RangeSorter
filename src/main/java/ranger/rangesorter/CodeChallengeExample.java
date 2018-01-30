package ranger.rangesorter;

import java.util.List;

import org.apache.log4j.Logger;

public class CodeChallengeExample {

	final static Logger logger = Logger.getLogger(CodeChallengeExample.class);

	public static String[] inputArgs1 ={"[94133,94133]", "[94600,94699]", "[94200,94299]"};
	public static String[] inputArgs2 ={"[94133,94133]", "[94200,94299]","[94226,94399]"};
	public static String[] inputArgs3 ={"[94133,94133]", "[94205,94289]","[94205,94389]"};
	public static String[] inputArgs4 ={"[94133,94133]", " [ 94301,94499 ] ","[  94301,94499 ] "};
	public static String[] inputArgsNonNumeric ={"[94133,94133]", "[94200,ABC]","[94200,94299]"};
	public static String[] inputArgsWrongOrder ={"[94133,94133]", "[95450,95299]","[94200,94299]"};
	
	public static void main(String[] args) throws Exception {
		
		logger.info("Main: Begin");
		
//		sortRangeValues(args);
		List<Range> outList = RangeSorter.sortRangeValues(inputArgs1);
		print(inputArgs1,outList);
		
		outList = RangeSorter.sortRangeValues(inputArgs2);
		print(inputArgs2,outList);
		
		outList = RangeSorter.sortRangeValues(inputArgs3);
		print(inputArgs3,outList);
		
		outList = RangeSorter.sortRangeValues(inputArgs4);
		print(inputArgs4,outList);
		
		try {
			outList = RangeSorter.sortRangeValues(inputArgsNonNumeric);
			print(inputArgsNonNumeric,outList);
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println();
		try {
			outList = RangeSorter.sortRangeValues(inputArgsWrongOrder);
			print(inputArgsWrongOrder,outList);
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println();
		logger.info("Main: End");
	}

	/**
	 * This method shows the usage of the Java application.
	 */
	public static void usage() {
		System.out.print("java CodeChallengeExample [range1] [range2] [range3] ....");
		System.out.print("e.g., java CodeChallengeExample [94133,94133] [94200,94299] [94600,94699]");
	}
	
	/**
	 * This method prints list of Range values
	 * 
	 * @param listOfValues
	 */
	public static void printList(List<Range> listOfValues) {
		
		for ( Range rangeVal:listOfValues ) {
			System.out.print(rangeVal+ " ");
		}
		System.out.println("\n");
	}
	
	/**
	 * This method prints list of String arguments.
	 * 
	 * @param listOfValues
	 */
	public static void printArgs(String[] args) {
		
		for ( String arg:args ) {
			System.out.print(arg+ " ");
		}
		System.out.println("\n");
	}
	
	/**
	 * This method prints Input list of Strings and Output list of Range
	 * @param input
	 * @param output
	 */
	public static void print(String[] input, List<Range> output) {
//		System.out.println("Input List");
		logger.debug("Input List");
		printArgs(input);
		
//		System.out.println("Output List");
		logger.debug("Output List");
		printList(output);
	}
}
