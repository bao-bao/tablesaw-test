package new_test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.github.lwhite1.tablesaw.api.BooleanColumn;
import com.github.lwhite1.tablesaw.api.IntColumn;
import com.github.lwhite1.tablesaw.util.Selection;

public class BooleanColumnTest {
	private final BooleanColumn column = BooleanColumn.create("Test");

	  @Before
	  public void setup() {
	    column.add(false);
	    column.add(false);
	    column.add(false);
	    column.add(false);
	    column.add(true);
	    column.add(true);
	    column.add(false);
	  }

	@Test
	public void testBooleanColumnStringSelectionInt() {
	//	fail("Not yet implemented");
		String para = null;
		Selection empty_sl = column.isFalse();
		int col_size = 10;
		
		para = "test";
		empty_sl = null;
		col_size = 10;
		
		para = null;
		empty_sl = null;
		col_size = 10;
		
		para = "test";
		empty_sl = column.isFalse();
		col_size = -10;
		
		col_size  = 0;
		
		col_size = 10;
		
		BooleanColumn bc = new BooleanColumn(para, empty_sl, col_size);
		//System.out.println(bc.size());
	}

	@Test
	public void testPrint() {
		BooleanColumn col = BooleanColumn.create("");
		String test = column.print();
		System.out.println(test);
	}

}
















