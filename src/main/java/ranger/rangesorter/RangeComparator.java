package ranger.rangesorter;

import java.util.Comparator;

/**
 * This is a Range Comparator used when sorting.
 * 
 * @author svilluri
 *
 */
public class RangeComparator implements Comparator<Range>{

    public int compare(Range r1, Range r2) {
        return r1.compareTo(r2);
    }
}
