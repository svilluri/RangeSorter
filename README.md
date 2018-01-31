Steps to setup workspace and code
1. Open Eclipse
2. In Git Repository view, Clone from
    https://github.com/svilluri/RangeSorter
3. In Project Explorer View, import as "Projects from Git"

Steps to run Java Program from Eclipse
1. Open CodeChallengeExample.java 
2. Run as "Java Application". This Java application has different input params


How to run from Command Line ( Spring Boot )
1. Open command prompt
2. goto (cd) to directory where this project is saved
    e.g., c:/RangeSorterProj/RangeSorter
3. Run following command
    java -jar target/rangesorter-0.1.0.jar

Steps to run JUnits
1. Select "test/java" package
2. Run as "JUnit Test"

Technologies Used

1. Java 1.8
2. Spring Boot
3. Maven
4. log4j
5. Junit


Pseudo Code

1. Sort input list of ranges that are in the format <min,max> value by ascending order of min and then max value
2. Iterate to the list and compare values in sequence and add to new list(result list).
3. If it is first element, add to result list and save as previous value.
4. If previous value contains next value, ignore next value.
5. if previous value overlaps with next value, merge both by taking the outer range of two values and save it in the new list.
   Remove previous value from the new list.
6. if previous value doesn't contain next value or overlaps with next value, add to the result list and 
   save next value as previous value.


   
