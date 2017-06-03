package new_test;

import static org.junit.Assert.*;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.junit.Test;

import com.github.lwhite1.tablesaw.api.FloatColumn;

public class FloatColumnTest {
	public void testUsual(float[] originalValues, float[] expectedValues) {
		FloatColumn initial = new FloatColumn("Test",originalValues.length);
	    for (float value : originalValues) {
	      initial.add(value);
	    }
	    FloatColumn difference =  initial.difference();
	    assertEquals("Both sets of data should be the same size.", expectedValues.length, difference.size());
	    for (int index = 0; index < difference.size(); index++ ) {
	      float actual = difference.get(index);
	      if (index == 0) {
	         assertTrue("difference operation at index:" + index + " failed", Float.isNaN(actual));
	      } else {
	        assertEquals("difference operation at index:" + index + " failed", expectedValues[index], actual, 0);
	      }
	    }
	}
	@Test
	  public void testDifference() {
		//正常数组
		float[] normal =new float[] {32,42,40,57,52};
		float[] normal_expected = new float[] {Float.NaN, 10, -2, 17, -5};
		//首部为NaN
		float[] head = new float[] { Float.NaN, 23, 34, 45 };
		float[] head_expected = new float[] {Float.NaN, Float.NaN, 11, 11};
		//尾部为NaN
		float[] tail = new float[] {23, 34, 45, Float.NaN};
		float[] tail_expected = new float[] {Float.NaN, 11, 11, Float.NaN};
		//中部有NaN
		float[] middle = new float[] {23, 34, Float.NaN, 45};
		float[] middle_expected = new float[] {Float.NaN, 11, Float.NaN, Float.NaN};
		
		testUsual(normal, normal_expected);
		testUsual(head, head_expected);
		testUsual(middle, middle_expected);
		testUsual(tail, tail_expected);
	  }

}
