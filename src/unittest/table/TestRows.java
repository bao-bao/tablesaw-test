package table;

import com.github.lwhite1.tablesaw.api.ColumnType;
import com.github.lwhite1.tablesaw.api.Table;
import com.github.lwhite1.tablesaw.columns.Column;
import com.github.lwhite1.tablesaw.io.TypeUtils;
import com.github.lwhite1.tablesaw.table.Rows;
import com.github.lwhite1.tablesaw.util.BitmapBackedSelection;
import com.github.lwhite1.tablesaw.util.Selection;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;
/* Created by AMXPC on 2017/5/28. */

public class TestRows {

    Column column0 = null;
    Column column1 = null;
    Column column2 = null;
    Column column3 = null;
    Column column4 = null;
    Column column5 = null;
    Column column6 = null;
    Column column7 = null;
    Column column8 = null;
    Column column9 = null;
    Column column10 = null;
    Column column11 = null;
    Column column12 = null;
    Column column13 = null;
    Column column14 = null;
    Column column15 = null;
    Column column16 = null;
    Column column17 = null;
    Column column18 = null;
    Column column19 = null;
    Column column00 = null;
    Column column000 = null;
    Column column1l = null;
    Column column1ll = null;
    Column column1lll = null;
    Column column22 = null;
    Column column222 = null;
    Column column33 = null;
    Column column333 = null;
    Column column3333 = null;
    Column column44 = null;
    Column column444 = null;
    Column column55 = null;
    Column column555 = null;
    Column column66 = null;
    Column column666 = null;
    Column column77 = null;
    Column column777 = null;
    Column column88 = null;
    Column column888 = null;
    Column column99 = null;
    Column column999 = null;
    Column column1010 = null;
    Column column101010 = null;
    Column column1111 = null;
    Column column111111 = null;
    Column column11111111 = null;
    Column column1212 = null;
    Column column121212 = null;
    Column column1313 = null;
    Column column131313 = null;
    Column column1414 = null;
    Column column141414 = null;
    Column column1515 = null;
    Column column151515 = null;
    Column column15151515 = null;
    Column column1616 = null;
    Column column161616 = null;
    Column column1717 = null;
    Column column171717 = null;
    Column column1818 = null;
    Column column181818 = null;
    Column column1919 = null;
    Column column191919 = null;
    Column column19191919 = null;


    IntArrayList rows0 = null;
    IntArrayList rows1 = null;
    IntArrayList rows2 = null;

    BitmapBackedSelection row0 = null;
    BitmapBackedSelection row1 = null;
    BitmapBackedSelection row2 = null;


    Table table0 = null;
    Table table1 = null;
    Table table2 = null;
    Table table3 = null;
    Table table4 = null;
    Table table5 = null;
    Table table6 = null;
    Table table7 = null;
    Table table8 = null;
    Table table9 = null;
    Table table10 = null;
    Table table11 = null;
    Table table12 = null;
    Table table13 = null;
    Table table14 = null;
    Table table15 = null;
    Table table16 = null;
    Table table17 = null;
    Table table18 = null;
    Table table19 = null;
    Table table20 = null;
    Table table21 = null;
    Table table22 = null;
    Table table23 = null;
    Table table24 = null;
    Table table25 = null;
    Table table26 = null;
    Table table27 = null;


    @Before
    public void setUp() {
       // Random rand = new Random(34872);
        //initialize columns
        column0 = TypeUtils.newColumn("column0", ColumnType.FLOAT);
        for (int i = 0; i < 2; i++) {
            column0.addCell(String.valueOf(Math.random()));
        }

        column00 = TypeUtils.newColumn("column00", ColumnType.FLOAT);
        for (int i = 0; i < 2; i++) {
            column00.addCell(String.valueOf(Math.random()));
        }

        column000 = TypeUtils.newColumn("column000", ColumnType.FLOAT);
        for (int i = 0; i < 2; i++) {
            column000.addCell(String.valueOf(Math.random()));
        }

        column1 = TypeUtils.newColumn("column1", ColumnType.FLOAT);
        for (int i = 0; i < 4; i++) {
            column1.addCell(String.valueOf(Math.random()));
        }

        column1l = TypeUtils.newColumn("column1l", ColumnType.FLOAT);
        for (int i = 0; i < 4; i++) {
            column1l.addCell(String.valueOf(Math.random()));
        }

        column1ll = TypeUtils.newColumn("column1ll", ColumnType.FLOAT);
        for (int i = 0; i < 4; i++) {
            column1ll.addCell(String.valueOf(Math.random()));
        }

        column1lll = TypeUtils.newColumn("column1lll", ColumnType.FLOAT);
        for (int i = 0; i < 4; i++) {
            column1lll.addCell(String.valueOf(Math.random()));
        }

        column2 = TypeUtils.newColumn("column2", ColumnType.FLOAT);
        for (int i = 0; i < 5; i++) {
            column2.addCell(String.valueOf(Math.random()));
        }

        column22 = TypeUtils.newColumn("column22", ColumnType.FLOAT);
        for (int i = 0; i < 5; i++) {
            column22.addCell(String.valueOf(Math.random()));
        }

        column222 = TypeUtils.newColumn("column222", ColumnType.FLOAT);
        for (int i = 0; i < 5; i++) {
            column222.addCell(String.valueOf(Math.random()));
        }

        column3 = TypeUtils.newColumn("column3", ColumnType.FLOAT);
        for (int i = 0; i < 6; i++) {
            column3.addCell(String.valueOf(Math.random()));
        }

        column33 = TypeUtils.newColumn("column33", ColumnType.FLOAT);
        for (int i = 0; i < 6; i++) {
            column33.addCell(String.valueOf(Math.random()));
        }

        column333 = TypeUtils.newColumn("column333", ColumnType.FLOAT);
        for (int i = 0; i < 6; i++) {
            column333.addCell(String.valueOf(Math.random()));
        }

        column3333 = TypeUtils.newColumn("column3333", ColumnType.FLOAT);
        for (int i = 0; i < 6; i++) {
            column3333.addCell(String.valueOf(Math.random()));
        }

        column4 = TypeUtils.newColumn("column4", ColumnType.INTEGER);
        for (int i = 0; i < 5; i++) {
            column4.addCell(String.valueOf((int) (Math.random() * 100)));
        }

        column44 = TypeUtils.newColumn("column44", ColumnType.INTEGER);
        for (int i = 0; i < 5; i++) {
            column44.addCell(String.valueOf((int) (Math.random() * 100)));
        }

        column444 = TypeUtils.newColumn("column444", ColumnType.INTEGER);
        for (int i = 0; i < 5; i++) {
            column444.addCell(String.valueOf((int) (Math.random() * 100)));
        }

        column5 = TypeUtils.newColumn("column5", ColumnType.INTEGER);
        for (int i = 0; i < 2; i++) {
            column5.addCell(String.valueOf((int) (Math.random() * 100)));
        }

        column55 = TypeUtils.newColumn("column55", ColumnType.INTEGER);
        for (int i = 0; i < 2; i++) {
            column55.addCell(String.valueOf((int) (Math.random() * 100)));
        }

        column555 = TypeUtils.newColumn("column555", ColumnType.INTEGER);
        for (int i = 0; i < 2; i++) {
            column555.addCell(String.valueOf((int) (Math.random() * 100)));
        }

        column6 = TypeUtils.newColumn("column6", ColumnType.SHORT_INT);
        for (int i = 0; i < 5; i++) {
            column6.addCell(String.valueOf((short) (Math.random() * 100)));
        }

        column66 = TypeUtils.newColumn("column66", ColumnType.SHORT_INT);
        for (int i = 0; i < 5; i++) {
            column66.addCell(String.valueOf((short) (Math.random() * 100)));
        }

        column666 = TypeUtils.newColumn("column666", ColumnType.SHORT_INT);
        for (int i = 0; i < 5; i++) {
            column666.addCell(String.valueOf((short) (Math.random() * 100)));
        }

        column7 = TypeUtils.newColumn("column7", ColumnType.SHORT_INT);
        for (int i = 0; i < 4; i++) {
            column7.addCell(String.valueOf((short) (Math.random() * 100)));
        }

        column77 = TypeUtils.newColumn("column77", ColumnType.SHORT_INT);
        for (int i = 0; i < 4; i++) {
            column77.addCell(String.valueOf((short) (Math.random() * 100)));
        }

        column777 = TypeUtils.newColumn("column777", ColumnType.SHORT_INT);
        for (int i = 0; i < 4; i++) {
            column777.addCell(String.valueOf((short) (Math.random() * 100)));
        }

        column8 = TypeUtils.newColumn("column8", ColumnType.LONG_INT);
        for (int i = 0; i < 5; i++) {
            column8.addCell(String.valueOf((long) (Math.random() * 100)));
        }

        column88 = TypeUtils.newColumn("column88", ColumnType.LONG_INT);
        for (int i = 0; i < 5; i++) {
            column88.addCell(String.valueOf((long) (Math.random() * 100)));
        }

        column888 = TypeUtils.newColumn("column888", ColumnType.LONG_INT);
        for (int i = 0; i < 5; i++) {
            column888.addCell(String.valueOf((long) (Math.random() * 100)));
        }

        column9 = TypeUtils.newColumn("column9", ColumnType.LONG_INT);
        for (int i = 0; i < 2; i++) {
            column9.addCell(String.valueOf((long) (Math.random() * 100)));
        }

        column99 = TypeUtils.newColumn("column99", ColumnType.LONG_INT);
        for (int i = 0; i < 2; i++) {
            column99.addCell(String.valueOf((long) (Math.random() * 100)));
        }

        column999 = TypeUtils.newColumn("column999", ColumnType.LONG_INT);
        for (int i = 0; i < 2; i++) {
            column999.addCell(String.valueOf((long) (Math.random() * 100)));
        }

        column10 = TypeUtils.newColumn("column10", ColumnType.CATEGORY);
        for (int i = 0; i < 5; i++) {
            column10.addCell(String.valueOf(Math.random()));
        }

        column1010 = TypeUtils.newColumn("column1010", ColumnType.CATEGORY);
        for (int i = 0; i < 5; i++) {
            column1010.addCell(String.valueOf(Math.random()));
        }

        column101010 = TypeUtils.newColumn("column101010", ColumnType.CATEGORY);
        for (int i = 0; i < 5; i++) {
            column101010.addCell(String.valueOf(Math.random()));
        }

        column11 = TypeUtils.newColumn("column11", ColumnType.CATEGORY);
        for (int i = 0; i < 4; i++) {
            column11.addCell(String.valueOf(Math.random()));
        }

        column1111 = TypeUtils.newColumn("column1111", ColumnType.CATEGORY);
        for (int i = 0; i < 4; i++) {
            column1111.addCell(String.valueOf(Math.random()));
        }

        column111111 = TypeUtils.newColumn("column111111", ColumnType.CATEGORY);
        for (int i = 0; i < 4; i++) {
            column111111.addCell(String.valueOf(Math.random()));
        }

        column11111111 = TypeUtils.newColumn("column11111111", ColumnType.CATEGORY);
        for (int i = 0; i < 4; i++) {
            column11111111.addCell(String.valueOf(Math.random()));
        }

        column12 = TypeUtils.newColumn("column12", ColumnType.BOOLEAN);
        for (int i = 0; i < 5; i++) {
            column12.addCell(Math.random() > 0.5 ? "TRUE" : "FALSE");
        }

        column1212 = TypeUtils.newColumn("column1212", ColumnType.BOOLEAN);
        for (int i = 0; i < 5; i++) {
            column1212.addCell(Math.random() > 0.5 ? "TRUE" : "FALSE");
        }

        column121212 = TypeUtils.newColumn("column121212", ColumnType.BOOLEAN);
        for (int i = 0; i < 5; i++) {
            column121212.addCell(Math.random() > 0.5 ? "TRUE" : "FALSE");
        }

        column13 = TypeUtils.newColumn("column13", ColumnType.BOOLEAN);
        for (int i = 0; i < 6; i++) {
            column13.addCell(Math.random() > 0.5 ? "TRUE" : "FALSE");
        }

        column1313 = TypeUtils.newColumn("column1313", ColumnType.BOOLEAN);
        for (int i = 0; i < 6; i++) {
            column1313.addCell(Math.random() > 0.5 ? "TRUE" : "FALSE");
        }

        column131313 = TypeUtils.newColumn("column131313", ColumnType.BOOLEAN);
        for (int i = 0; i < 6; i++) {
            column131313.addCell(Math.random() > 0.5 ? "TRUE" : "FALSE");
        }

        column14 = TypeUtils.newColumn("column14", ColumnType.LOCAL_DATE);
        for (int i = 0; i < 5; i++) {
            column14.addCell("1996-04-12");
        }

        column1414 = TypeUtils.newColumn("column1414", ColumnType.LOCAL_DATE);
        for (int i = 0; i < 5; i++) {
            column1414.addCell("1996-04-12");
        }

        column141414 = TypeUtils.newColumn("column141414", ColumnType.LOCAL_DATE);
        for (int i = 0; i < 5; i++) {
            column141414.addCell("1996-04-12");
        }

        column15 = TypeUtils.newColumn("column15", ColumnType.LOCAL_DATE);
        for (int i = 0; i < 6; i++) {
            column15.addCell("1996-04-12");
        }

        column1515 = TypeUtils.newColumn("column1515", ColumnType.LOCAL_DATE);
        for (int i = 0; i < 6; i++) {
            column1515.addCell("1996-04-12");
        }

        column151515 = TypeUtils.newColumn("column151515", ColumnType.LOCAL_DATE);
        for (int i = 0; i < 6; i++) {
            column151515.addCell("1996-04-12");
        }

        column15151515 = TypeUtils.newColumn("column15151515", ColumnType.LOCAL_DATE);
        for (int i = 0; i < 6; i++) {
            column15151515.addCell("1996-04-12");
        }

        column16 = TypeUtils.newColumn("column16", ColumnType.LOCAL_DATE_TIME);
        for (int i = 0; i < 5; i++) {
            column16.addCell("1996-04-12T13:43:51.484");
        }

        column1616 = TypeUtils.newColumn("column1616", ColumnType.LOCAL_DATE_TIME);
        for (int i = 0; i < 5; i++) {
            column1616.addCell("1996-04-12T13:43:51.484");
        }

        column161616 = TypeUtils.newColumn("column161616", ColumnType.LOCAL_DATE_TIME);
        for (int i = 0; i < 5; i++) {
            column161616.addCell("1996-04-12T13:43:51.484");
        }

        column17 = TypeUtils.newColumn("column17", ColumnType.LOCAL_DATE_TIME);
        for (int i = 0; i < 2; i++) {
            column17.addCell("1996-04-12T13:43:51.484");
        }

        column1717 = TypeUtils.newColumn("column1717", ColumnType.LOCAL_DATE_TIME);
        for (int i = 0; i < 2; i++) {
            column1717.addCell("1996-04-12T13:43:51.484");
        }

        column171717 = TypeUtils.newColumn("column171717", ColumnType.LOCAL_DATE_TIME);
        for (int i = 0; i < 2; i++) {
            column171717.addCell("1996-04-12T13:43:51.484");
        }

        column18 = TypeUtils.newColumn("column18", ColumnType.LOCAL_TIME);
        for (int i = 0; i < 5; i++) {
            column18.addCell("13:43:51.484");
        }

        column1818 = TypeUtils.newColumn("column1818", ColumnType.LOCAL_TIME);
        for (int i = 0; i < 5; i++) {
            column1818.addCell("13:43:51.484");
        }

        column181818 = TypeUtils.newColumn("column181818", ColumnType.LOCAL_TIME);
        for (int i = 0; i < 5; i++) {
            column181818.addCell("13:43:51.484");
        }

        column19 = TypeUtils.newColumn("column19", ColumnType.LOCAL_TIME);
        for (int i = 0; i < 4; i++) {
            column19.addCell("13:43:51.484");
        }

        column1919 = TypeUtils.newColumn("column1919", ColumnType.LOCAL_TIME);
        for (int i = 0; i < 4; i++) {
            column1919.addCell("13:43:51.484");
        }

        column191919 = TypeUtils.newColumn("column191919", ColumnType.LOCAL_TIME);
        for (int i = 0; i < 4; i++) {
            column191919.addCell("13:43:51.484");
        }

        column19191919 = TypeUtils.newColumn("column19191919", ColumnType.LOCAL_TIME);
        for (int i = 0; i < 4; i++) {
            column19191919.addCell("13:43:51.484");
        }

        //initialize tables
        table1 = Table.create("1", column0, column00);
        table2 = Table.create("2", column1, column1l, column1ll);
        table3 = Table.create("3", column2, column22, column222);
        table4 = Table.create("4", column1, column1l);
        table5 = Table.create("5", column0, column00, column000);
        table6 = Table.create("6", column1, column1l, column1ll, column1lll);
        table7 = Table.create("7", column3, column33);
        table8 = Table.create("8", column3, column33, column333, column3333);
        table9 = Table.create("9", column4, column44, column444);
        table10 = Table.create("10", column5, column55, column555);
        table11 = Table.create("11", column6, column66, column666);
        table12 = Table.create("12", column7, column77, column777);
        table13 = Table.create("13", column8, column88, column888);
        table14 = Table.create("14", column9, column99, column999);
        table15 = Table.create("15", column10, column1010, column101010);
        table16 = Table.create("16", column11, column1111, column111111, column11111111);
        table17 = Table.create("17", column12, column1212, column121212);
        table18 = Table.create("18", column13, column1313, column131313);
        table19 = Table.create("19", column14, column1414, column141414);
        table20 = Table.create("20", column15, column1515, column151515, column15151515);
        table21 = Table.create("21", column16, column1616, column161616);
        table22 = Table.create("22", column17, column1717, column171717);
        table23 = Table.create("23", column18, column1818, column181818);
        table24 = Table.create("24", column19, column1919, column191919, column19191919);
        table25 = Table.create("25", column2, column4);
        table26 = Table.create("26", column2, column4);


        //initialize rows
        rows1 = new IntArrayList(2);
        for (int index = 0, k = 3; index < 2; index++, k++) {
            rows1.add(index, k);
        }

        rows2 = new IntArrayList(3);
        for (int index = 0, k = -1; index < 3; index++, k++) {
            rows2.add(index, k);
        }

        //initialize row
        row1 = new BitmapBackedSelection();
        row1.addRange(3,5);

        row2 = new BitmapBackedSelection();
        row2.addRange(-1,2);
    }


    @Test
    public void testCopyRowsToTable () {
        //Rows.copyRowsToTable(row1, table2, table1);
        //System.out.println(table1.columnCount());
        //System.out.println(table1.rowCount());

        //Rows.copyRowsToTable(row0, table1, table1);
        //System.out.println(table1.columnCount());
        //System.out.println(table1.rowCount());

        //Rows.copyRowsToTable(row1, table1, table1);
        //System.out.println(table1.columnCount());
        //System.out.println(table1.rowCount());

        //Rows.copyRowsToTable(row1, table3, table4);
        //System.out.println(table4.columnCount());
        //System.out.println(table4.rowCount());

        //Rows.copyRowsToTable(row1, table3, table5);
        //System.out.println(table5.columnCount());
        //System.out.println(table5.rowCount());

        System.out.println(table6.print());
        Rows.copyRowsToTable(rows1, table3, table6);
        System.out.println(table3.print());
        System.out.println(table6.print());
        //System.out.println(table6.columnCount());
        //System.out.println(table6.rowCount());

        //Rows.copyRowsToTable(row1, table3, table7);
        //System.out.println(table7.columnCount());
        //System.out.println(table7.rowCount());

        //System.out.println(table8.print());
        //Rows.copyRowsToTable(rows1, table3, table8);
        //System.out.println(table3.print());
        //System.out.println(table8.print());
        //System.out.println(table8.columnCount());
        //System.out.println(table8.rowCount());

        //Rows.copyRowsToTable(rows1, table9, table10);
        //System.out.println(table10.columnCount());
        //System.out.println(table10.rowCount());

        Rows.copyRowsToTable(rows1, table11, table12);
        System.out.println(table12.columnCount());
        System.out.println(table12.rowCount());

        //TODO: usecase 14
        System.out.println(table16.print());
        Rows.copyRowsToTable(row1, table15, table16);
        System.out.println(table15.print());
        System.out.println(table16.print());

        //Rows.copyRowsToTable(rows1, table17, table18);
        //System.out.println(table18.columnCount());
        //System.out.println(table18.rowCount());

        //System.out.println(table20.print());
        //Rows.copyRowsToTable(rows1, table19, table20);
        //System.out.println(table19.print());
        //System.out.println(table20.print());
        //System.out.println(table20.columnCount());
        //System.out.println(table20.rowCount());

        //Rows.copyRowsToTable(rows1, table21, table22);
        //System.out.println(table22.columnCount());
        //System.out.println(table22.rowCount());

        //System.out.println(table24.print());
        //Rows.copyRowsToTable(rows1, table23, table24);
        //System.out.println(table23.print());
        //System.out.println(table24.print());
        //System.out.println(table23.columnCount());
        //System.out.println(table24.rowCount());

        //Rows.copyRowsToTable(rows1, table25, table26);
        //System.out.println(table26.columnCount());
        //System.out.println(table26.rowCount());

        //Rows.copyRowsToTable(rows1, table3, table9);
        //System.out.println(table9.columnCount());
        //System.out.println(table9.rowCount());

        //Rows.copyRowsToTable(rows2, table1, table2);
        //System.out.println(table2.columnCount());
        //System.out.println(table2.rowCount());




        //assertThat(table1.columnCount(), is(3));
        //assertThat(table1.rowCount(), is(4));
        //assertThat()
    }
}
