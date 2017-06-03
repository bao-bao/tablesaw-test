package new_test;

import static org.junit.Assert.*;

import java.io.Console;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.github.lwhite1.tablesaw.api.BooleanColumn;
import com.github.lwhite1.tablesaw.api.CategoryColumn;
import com.github.lwhite1.tablesaw.api.Table;
import com.github.lwhite1.tablesaw.columns.Column;
import com.github.lwhite1.tablesaw.util.Selection;

public class CategoryColumnTest {
	///含有重复项
	private CategoryColumn repeat = CategoryColumn.create("repeat");
	//含有单一项
	private CategoryColumn single = CategoryColumn.create("single");
	//空项
	private CategoryColumn empty  = CategoryColumn.create("empty");
		
	@Before
	public void setUp() throws Exception {
		//初始重复项
		repeat.add("value1");
		repeat.add("value2");
		repeat.add("value3");
		repeat.add("value4");
		repeat.add("value1");
		//初始化单一项
		single.add("single1");
		single.add("single2");
		single.add("single3");
	}

	@Test
	public void testCountByCategory() {
		Table repeatT = repeat.countByCategory();
		Table singleT = single.countByCategory();
		Table emptyT = empty.countByCategory();
		
		System.out.println(repeatT.name());
		List<Column> columnList = repeatT.columns();
		for(Column col: columnList) {
			System.out.println(col.name());
			for(int i = 0; i < col.size(); ++ i) {
				System.out.println(col.getString(i));
			}
		}
		//判断非空
		assertNotNull(repeatT);
		assertNotNull(singleT);
		assertNotNull(emptyT);
		//判断长度
		assertEquals(4, repeatT.columns().get(0).size());
		assertEquals(single.size(), singleT.columns().get(0).size());
		assertEquals(0, emptyT.columns().get(0).size());
	}

	@Test
	public void testIsEqualTo() {
		Selection empty = repeat.isEqualTo(null);
		Selection in = repeat.isEqualTo("value1");
		Selection not_in = repeat.isEqualTo("asdf");
		//判断非空
		assertNotNull(empty);
		assertNotNull(in);
		assertNotNull(not_in);
		//判断长度
		assertEquals(0, empty.size());
		assertEquals(2, in.size());
		assertEquals(0, not_in.size());
	}

	@Test
	public void testIsNotEqualTo() {
		Selection empty = repeat.isNotEqualTo(null);
		Selection in = repeat.isNotEqualTo("value1");
		Selection not_in = repeat.isNotEqualTo("asdf");
		//判断非空
		assertNotNull(empty);
		assertNotNull(in);
		assertNotNull(not_in);
		//判断长度
		assertEquals(0, empty.size());
		assertEquals(repeat.size() - 2, in.size());
		assertEquals(0, not_in.size());
	}

	@Test
	public void testGetDummies() {
		List<BooleanColumn> repeatD = repeat.getDummies();
		List<BooleanColumn> singleD  = single.getDummies();
		List<BooleanColumn> emptyD = empty.getDummies();
		
		for(BooleanColumn bc: repeatD) {
			System.out.println(bc.name());
			for(int i = 0;i < bc.size(); ++ i) {
				System.out.println(bc.get(i));
			}
		}
		//判断非空
		assertNotNull(repeatD);
		assertNotNull(singleD);
		assertNotNull(emptyD);
		//判断长度
		assertEquals(4, repeatD.size());
		assertEquals(single.size(), singleD.size());
		assertEquals(0, emptyD.size());
	}

}























