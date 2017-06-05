package table;

/* Created by AMXPC on 2017/5/28. */

import com.github.lwhite1.tablesaw.api.ColumnType;
import com.github.lwhite1.tablesaw.api.LongColumn;
import com.github.lwhite1.tablesaw.api.Table;
import com.github.lwhite1.tablesaw.columns.Column;
import com.github.lwhite1.tablesaw.io.TypeUtils;
import com.github.lwhite1.tablesaw.table.TemporaryView;
import com.github.lwhite1.tablesaw.util.BitmapBackedSelection;
import com.github.lwhite1.tablesaw.util.Selection;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class TestTemporaryView {
    BitmapBackedSelection selection0 = null;
    BitmapBackedSelection selection1 = null;

    Column column0 = null;
    Column column1 = null;
    Column column2 = null;
    Column column3 = null;
    Column column4 = null;
    Column column5 = null;
    Column column6 = null;
    Column column7 = null;
    Column column8 = null;

    Table table0 = null;
    Table table1 = null;

    TemporaryView view0 = null;
    TemporaryView view1 = null;
    TemporaryView view2 = null;


    @Before
    public void setUp() {
        //initialize selection
        selection0 = new BitmapBackedSelection();
        selection1 = new BitmapBackedSelection();
        selection1.addRange(0,3);


        //Random rand = new Random(34872);
        //initialize columns
        column0 = TypeUtils.newColumn("column0", ColumnType.FLOAT);
        for (int i = 0; i < 5; i++) {
            column0.addCell(String.valueOf(Math.random()));
        }

        column1 = TypeUtils.newColumn("column1", ColumnType.INTEGER);
        for (int i = 0; i < 5; i++) {
            column1.addCell(String.valueOf((int) (Math.random() * 100)));
        }

        column2 = TypeUtils.newColumn("column2", ColumnType.SHORT_INT);
        for (int i = 0; i < 5; i++) {
            column2.addCell(String.valueOf((short) (Math.random() * 100)));
        }

        column3 = TypeUtils.newColumn("column3", ColumnType.LONG_INT);
        for (int i = 0; i < 5; i++) {
            column3.addCell(String.valueOf((long) (Math.random() * 100)));
        }

        column4 = TypeUtils.newColumn("column4", ColumnType.CATEGORY);
        for (int i = 0; i < 5; i++) {
            column4.addCell(String.valueOf(Math.random()));
        }

        column5 = TypeUtils.newColumn("column5", ColumnType.BOOLEAN);
        for (int i = 0; i < 5; i++) {
            column5.addCell(Math.random() > 0.5 ? "TRUE" : "FALSE");
        }

        column6 = TypeUtils.newColumn("column6", ColumnType.LOCAL_DATE);
        for (int i = 0; i < 5; i++) {
            column6.addCell("1996-04-12");
        }

        column7 = TypeUtils.newColumn("column7", ColumnType.LOCAL_DATE_TIME);
        for (int i = 0; i < 5; i++) {
            column7.addCell("1996-04-12T13:43:51.484");
        }

        column8 = TypeUtils.newColumn("column8", ColumnType.LOCAL_TIME);
        for (int i = 0; i < 5; i++) {
            column8.addCell("13:43:51.484");
        }

        //initialize tables
        table1 = Table.create("1", column0, column1, column2, column3, column4, column5, column6, column7, column8);

        //initialize views
        view1 = new TemporaryView(table1, selection0);
        view2 = new TemporaryView(table1, selection1);
    }

    @Test
    public void testColWidths() {
        int[] widths = view2.colWidths();
        //System.out.println(((LongColumn)column3).get(2));
        for(int i : widths) {
            System.out.println(i);
        }
    }

    @Test
    public void testPrint() {
        String printView = view2.print();
        System.out.println(printView);
    }

    @Test
    public void testFirst() {
        Table t = view2.first(2);
        System.out.println(t.print());
    }
}