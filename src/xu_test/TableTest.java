package new_test;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.lwhite1.tablesaw.api.FloatColumn;
import com.github.lwhite1.tablesaw.api.IntColumn;
import com.github.lwhite1.tablesaw.api.Table;
import com.github.lwhite1.tablesaw.columns.Column;
import com.github.lwhite1.tablesaw.sorting.Sort;
import com.github.lwhite1.tablesaw.sorting.Sort.Order;
import com.github.lwhite1.tablesaw.util.IntComparatorChain;

public class TableTest {
	 
	 private Table table;
	  private FloatColumn column = new FloatColumn("index1");
	  private IntColumn icol = new IntColumn("index2");
	  private IntColumn icol2 = new IntColumn("index3");

	  @Before
	  public void setUp() throws Exception {
	    table = Table.create("t");
	    
	    column.add((float)12.2);
	    column.add((float)10.2);
	    column.add((float)-1.6);
	    
	    icol.add(23);
	    icol.add(-20);
	    icol.add(12);
	    
	    icol2.add(10);
	    icol2.add(-1);
	    icol2.add(20);
	    
	    table.addColumn(column);
	    table.addColumn(icol);
	    table.addColumn(icol2);
	 }
	@Test
	public void testColumnIndexString() {
		assertEquals(0, table.columnIndex("index1"));
		try{
			int index1 = table.columnIndex("asdf_test2");
		} catch(Exception e){
			assertTrue( e instanceof java.lang.IllegalArgumentException);
		}
		try {
			String col_name = null;
			int index2 = table.columnIndex(col_name);
		} catch(Exception e){
			assertTrue( e instanceof java.lang.IllegalArgumentException);
		}
	}
	
	
	@Test
	public void testColumnIndexColumn() {
		assertEquals(1, table.columnIndex(icol));
		try {
			IntColumn test_col = new IntColumn("test");
			int index1 = table.columnIndex(test_col);
		} catch(Exception e){
			assertTrue( e instanceof java.lang.IllegalArgumentException);
		}
		try {
			IntColumn test_col = null;
			int index2 = table.columnIndex(test_col);
		} catch(Exception e){
			assertTrue( e instanceof java.lang.NullPointerException);
		}
	}
	
	
	
	public void testSortOnHelper(String... paras) {
		Table afterSort = table.sortOn(paras);
		List<Column> cols = afterSort.columns();
		for(Column col: cols) {
			System.out.println(col.name());
			for(int i = 0; i < col.size(); ++ i) {
				System.out.print(col.getString(i) + "    ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	@Test
	public void testSortOnStringArray() {
		String empty_para = null;
		String para = "asdf_test";
		String[] def_para_arr = {"index1", "index2"};
		String[] def_para_arr_reverse = {"index2", "index1" };
		String[] para_arr = {"+index1", "+index2"};
		String[] para_arr_reverse = {"+index2", "+index1"};
		String[] des_para_arr = {"-index1", "-index2" };
		String[] des_para_arr_reverse = {"-index2", "-index1"};
		
		try{
			testSortOnHelper(empty_para);
		} catch(Exception e) {
			assertTrue( e instanceof java.lang.NullPointerException);
		}
		try {
			testSortOnHelper(para);
		} catch(Exception e){
			assertTrue( e instanceof java.lang.IllegalStateException);
		}
		
		testSortOnHelper(def_para_arr);
		testSortOnHelper(def_para_arr_reverse);
		testSortOnHelper(para_arr);
		testSortOnHelper(para_arr_reverse);
		testSortOnHelper(des_para_arr);
		testSortOnHelper(des_para_arr_reverse);
	}
	
	public void printUniformBitmap(int[] ans) {
		System.out.println("Start ans");
		for(int i = 0; i < ans.length; ++ i){
			System.out.print(ans[i] + "  ");
		}
		System.out.println();
	}
	@Test
	public void testGenerateUniformBitmap() {
		int[] ans1 = Table.generateUniformBitmap(20, 10);
		printUniformBitmap(ans1);
		int[] ans2 = Table.generateUniformBitmap(20, -2);
		printUniformBitmap(ans2);
		int[] ans3 = Table.generateUniformBitmap(-2, -10);
		printUniformBitmap(ans3);
		int[] ans4 = Table.generateUniformBitmap(2, 0);
		printUniformBitmap(ans4);
		
		int[] ans5 = Table.generateUniformBitmap(0, 2);
		printUniformBitmap(ans5);
		int[] ans6 = Table.generateUniformBitmap(-2, 5);
		printUniformBitmap(ans6);
		
		int[] ans7 = Table.generateUniformBitmap(5, 10);
		printUniformBitmap(ans7);
		int[] ans8 = Table.generateUniformBitmap(10,  10);
		printUniformBitmap(ans8);
	}
	
	private final Method[] methods = Table.class.getDeclaredMethods();
   
	@Test
	public void testGetChain() throws Exception {
		Table  t = Table.create("Test");
		 Table newT  = null;
		
		for(int i  = 0; i < methods.length; ++ i) {
			if(methods[i].getName().equals("getChain")) {
				methods[i].setAccessible(true);
				Object para[] = {1, 2, 3};
				Order order_asc = Order.ASCEND;
				Order order_des = Order.DESCEND;
				
				Sort empty_key = null;
				
				Sort not_key1 = new Sort("asdf_test", order_asc);
				Sort not_key2 = new Sort("", order_asc);
				
				Sort key1 = new Sort("index2", order_asc);
				Sort key2 = new Sort("index2", order_des);
				
				IntComparatorChain chain = (IntComparatorChain) methods[i].invoke(table, not_key1);
			    newT = table.sortOn(chain);
			}
		}
		System.out.println("getChianTest: ");
		System.out.println(newT.print());
	}
}
