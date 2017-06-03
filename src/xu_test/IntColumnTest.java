package new_test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.lwhite1.tablesaw.api.IntColumn;

public class IntColumnTest {

	public void testUsual(int[] originalValues, int[] expectedValues){
		   IntColumn initial = new IntColumn("Test",originalValues.length);
		    for (int value : originalValues) {
		      initial.add(value);
		    }
		    IntColumn difference =  initial.difference();
		    assertEquals("Both sets of data should be the same size.", expectedValues.length, difference.size());
		    for (int index = 0; index < difference.size(); index++ ) {
		    	 int actual = difference.get(index);
		    	System.out.println("The expected value: " + expectedValues[index] + "   " + "The actual value is: " + actual);
		    	
		     
		      assertEquals("difference operation at index:" + index + " failed",  expectedValues[index], actual);
		    }
		    System.out.println();
	}
	@Test
	public void testDifference() {
				//正常数组
				int[] normal =new int[] {32,42,40,57,52};
				int[] normal_expected = new int[] {IntColumn.MISSING_VALUE, 10, -2, 17, -5};
				//首部为NaN
				int[] head = new int[] { IntColumn.MISSING_VALUE, 23, 34, 45 };
				int[] head_expected = new int[] {IntColumn.MISSING_VALUE, IntColumn.MISSING_VALUE, 11, 11};
				//尾部为NaN
				int[] tail = new int[] {23, 34, 45, IntColumn.MISSING_VALUE};
				int[] tail_expected = new int[] {IntColumn.MISSING_VALUE, 11, 11,IntColumn.MISSING_VALUE};
				//中部有NaN
				int[] middle = new int[] {23, 34, IntColumn.MISSING_VALUE, 45};
				int[] middle_expected = new int[] {IntColumn.MISSING_VALUE, 11, IntColumn.MISSING_VALUE,IntColumn.MISSING_VALUE};
				
			    testUsual(normal, normal_expected);
     		    testUsual(head, head_expected);
		   	   testUsual(middle, middle_expected);
         		testUsual(tail, tail_expected);
				
	}

}
