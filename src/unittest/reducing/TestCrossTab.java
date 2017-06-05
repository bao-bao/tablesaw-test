package reducing;

/* Created by AMXPC on 2017/5/28. */

import com.github.lwhite1.tablesaw.api.ColumnType;
import com.github.lwhite1.tablesaw.api.DateColumn;
import com.github.lwhite1.tablesaw.api.Table;
import com.github.lwhite1.tablesaw.columns.Column;
import com.github.lwhite1.tablesaw.io.TypeUtils;
import com.github.lwhite1.tablesaw.io.csv.CsvReader;
import com.github.lwhite1.tablesaw.reducing.CrossTab;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Random;

public class TestCrossTab {
    Table firstName = null;
    Table table1 = null;
    Table table2 = null;
    Table table3 = null;
    Table table4 = null;
    Table table5 = null;
    Table table6 = null;


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

    IntArrayList date = null;
    DateColumn dateColumn = null;


    @Before
    public void setUp() throws IOException {
        //use case 5
        ColumnType[] columnTypes5 = {ColumnType.CATEGORY, ColumnType.INTEGER, ColumnType.CATEGORY, ColumnType.LOCAL_DATE};
        table5 = CsvReader.read(columnTypes5, "data/simple-data-sort_by_int_and_date_ascending.csv");
        column9 = table5.column(2);
        column10 = table5.column(3);


        //use case 4
        ColumnType[] columnTypes4 = {ColumnType.CATEGORY, ColumnType.CATEGORY, ColumnType.INTEGER};
        firstName = CsvReader.read(columnTypes4, "data/first_names.csv");
        column1 = firstName.column(1);
        column2 = firstName.column(2);

        //use case 3
        column3 = TypeUtils.newColumn("column3", ColumnType.FLOAT);
        for (int i = 0; i < 5; i++) {
            column3.addCell(String.valueOf(Math.random()));
        }

        column4 = TypeUtils.newColumn("column4", ColumnType.INTEGER);
        for (int i = 0; i < 5; i++) {
            column4.addCell(String.valueOf((int) (Math.random() * 100)));
        }

        column11 = TypeUtils.newColumn("column11", ColumnType.INTEGER);
        for (int i = 0; i < 5; i++) {
            column11.addCell(String.valueOf((int) (Math.random() * 100)));
        }

        column12 = TypeUtils.newColumn("column12", ColumnType.INTEGER);
        for (int i = 0; i < 5; i++) {
            column12.addCell(String.valueOf(3));
        }

        table3 = Table.create("3", column3, column4, column12, column11);

        //use case 2
        column5 = TypeUtils.newColumn("column5", ColumnType.INTEGER);
        for (int i = 0; i < 5; i++) {
            column5.addCell(String.valueOf((int) (Math.random() * 100)));
        }

        column6 = TypeUtils.newColumn("column6", ColumnType.LOCAL_DATE);
        for (int i = 0; i < 5; i++) {
            column6.addCell("1996-04-12");
        }

        column7 = TypeUtils.newColumn("column7", ColumnType.INTEGER);
        for (int i = 0; i < 5; i++) {
            column7.addCell(String.valueOf((int) (Math.random() * 100)));
        }

        column8 = TypeUtils.newColumn("column8", ColumnType.LOCAL_DATE_TIME);
        for (int i = 0; i < 5; i++) {
            column8.addCell("1996-04-12T13:43:51.484");
        }

        table2 = Table.create("2", column6, column5);

        //use case 1
        date = new IntArrayList(2);
        date.add(0, 822411551);
        date.add(0, -1627061218);
        date.add(0, 520552988);
        date.add(0, -603520483);
        date.add(0, 1895696408);
        dateColumn = DateColumn.create("dateColumn", date);
        table1 = Table.create("1", dateColumn, column5);
    }

    @Test
    public void testXCount() {
        Table t = CrossTab.xCount(table2, column5, column6);
        System.out.println(t.print());
    }

    @Test
    public void testxTabCount() {
        Table t = CrossTab.xTabCount(table5, column9, column10);
        System.out.println(t.print());
    }

    @Test
    public void testXTabCount() {
        Table t = CrossTab.xTabCount(table2, column6, column5);
        System.out.println(t.print());
    }

    @Test
    public void testRowPercents() {
        //Table t = CrossTab.xTabCount(table5, column9, column10);
        //Table rowPercents = CrossTab.rowPercents(t);
        //System.out.println(rowPercents.print());

        Table rowPercents = CrossTab.rowPercents(table5);
        System.out.println(rowPercents.print());
    }

    @Test
    public void testColumnPercents() {
        //Table t = CrossTab.xTabCount(table5, column9, column10);
        //Table rowPercents = CrossTab.columnPercents(t);
        //System.out.println(rowPercents.print());

        Table rowPercents = CrossTab.columnPercents(table3);
        System.out.println(rowPercents.print());
    }

    @Test
    public void testTablePercents() {
        //Table t = CrossTab.xTabCount(table5, column9, column10);
        //Table rowPercents = CrossTab.tablePercents(t);
        //System.out.println(rowPercents.print());

        Table rowPercents = CrossTab.tablePercents(table3);
        System.out.println(rowPercents.print());
    }
}
