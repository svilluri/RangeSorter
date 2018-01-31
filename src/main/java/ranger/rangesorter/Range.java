package ranger.rangesorter;

public class Range implements Comparable<Range>{
	Long min;
	Long max;
	
	Range() {
		min=0l;
		max=0l;
	}
	
	public Range(Long minVal, Long maxVal) {
		min = minVal;
		max = maxVal;
	}
	
	public Long getMin() {
		return min;
	}
	public void setMin(Long min) {
		this.min = min;
	}
	public Long getMax() {
		return max;
	}
	public void setMax(Long max) {
		this.max = max;
	}
	
	public String toString() {
		return "["+min+","+max+"]";
	}
	
	/**
	 * This method compares min values of two range objects
	 */
	public int compareTo(Range range){
		if (min == range.getMin()) {
			if ( max == range.getMax()) {
				return 0;
			}
			else
			if ( max > range.getMax()) {
				return 1;
			}
			return -1;
		}
		else
		if (min > range.getMin()) {
			return 1;
		}
		else
			return -1;
	}
	
	/**
	 * This method checks to see if passed in range values falls between this object's range values
	 *
	 * @param range
	 * @return true if it falls between. false otherwise.
	 */
	public boolean contains(Range range) {
		
		boolean flag=false;
		if ( min <= range.min && max >= range.max ) {
			flag = true;
		}
		
		return flag;
	}
	
	/**
	 * This method checks to see if passed in range values overlaps with this object's range values
	 *
	 * @param range
	 * @return Overlap range value if overlaps, null otherwise.
	 * 
	 */
	public Range overlaps(Range range) {
		Range combinedRangeVal = null;

		if ( max > range.min && max < range.max ) {
			combinedRangeVal = new Range();
			combinedRangeVal.min=min;
			combinedRangeVal.max=range.max;
		}
		
		return combinedRangeVal;
	}
	

	/**
	 * This method compares current object with passed in object
	 * and return true if both have same values. Otherwise false.
	 * 
	 * returns true, if both have same values.
	 * 		   false, otherwise
	 */
	public boolean equals(Object object) {
		boolean flag = false;
		Range rangeObj = (Range)object;
		if ( this.min.longValue() == rangeObj.min.longValue() && this.max.longValue() == rangeObj.max.longValue() ) {
			flag = true;
		}
		return flag;
	}
}
