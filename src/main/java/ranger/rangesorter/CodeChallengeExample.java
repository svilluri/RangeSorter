package ranger.rangesorter;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
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

		SpringApplication.run(CodeChallengeExample.class, args);
        
		logger.info("Main: End");
	}

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {		
        return args -> {
    		logger.info("commandLineRunner: Begin");
    		
	//		sortRangeValues(args);
    		System.out.println("Scenario1\n");
    		
			List<Range> outList = RangeSorter.sortRangeValues(inputArgs1);
			print(inputArgs1,outList);
			
    		System.out.println("----------------------------\n");
    		
    		System.out.println("Scenario2\n");
    		
			outList = RangeSorter.sortRangeValues(inputArgs2);
			print(inputArgs2,outList);
			
    		System.out.println("----------------------------\n");			
    		System.out.println("Scenario3\n");
    		
			outList = RangeSorter.sortRangeValues(inputArgs3);
			print(inputArgs3,outList);
			
    		System.out.println("----------------------------\n");			
    		System.out.println("Scenario4\n");
    		
			outList = RangeSorter.sortRangeValues(inputArgs4);
			print(inputArgs4,outList);
			
			try {
	    		System.out.println("----------------------------\n");				
	    		System.out.println("Scenario5\n");
	    		
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
		       
			logger.info("commandLineRunner: End");	  		
       };
     
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
		
		logger.info("printList: Begin");
		
		for ( Range rangeVal:listOfValues ) {
			System.out.print(rangeVal+ " ");
		}
		System.out.println("\n");

		logger.info("printList: End");
	}
	
	/**
	 * This method prints list of String arguments.
	 * 
	 * @param listOfValues
	 */
	public static void printArgs(String[] args) {
		
		logger.info("printArgs: Begin");
		
		for ( String arg:args ) {
			System.out.print(arg+ " ");
		}
		
		System.out.println("\n");
		
		logger.info("printArgs: End");		
	}
	
	/**
	 * This method prints Input list of Strings and Output list of Range
	 * @param input
	 * @param output
	 */
	public static void print(String[] input, List<Range> output) {
		
		logger.info("print: Begin");
		
//		System.out.println("Input List");
		System.out.println("Input List");
		printArgs(input);
		
//		System.out.println("Output List");
		System.out.println("Output List");
		printList(output);
		
		logger.info("print: End");		
	}
}
