package io.csv;

import com.github.lwhite1.tablesaw.api.*;
import com.github.lwhite1.tablesaw.columns.Column;
import com.github.lwhite1.tablesaw.io.TypeUtils;
import com.github.lwhite1.tablesaw.io.csv.CsvWriter;
import com.opencsv.CSVReader;
import org.junit.Before;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/* Created by AMXPC on 2017/5/28. */

public class TestCsvWriter {
    Table table;

    @Before
    public void setUp() {
        Random rand = new Random(24235);
        Column column1 = TypeUtils.newColumn("int", ColumnType.INTEGER);
        Column column2 = TypeUtils.newColumn("boolean", ColumnType.BOOLEAN);
        Column column3 = TypeUtils.newColumn("long", ColumnType.LONG_INT);
        Column column4 = TypeUtils.newColumn("float", ColumnType.FLOAT);
        Column column5 = TypeUtils.newColumn("short", ColumnType.SHORT_INT);
        Column column6 = TypeUtils.newColumn("date", ColumnType.LOCAL_DATE);
        Column column7 = TypeUtils.newColumn("time", ColumnType.LOCAL_TIME);
        Column column8 = TypeUtils.newColumn("datetime", ColumnType.LOCAL_DATE_TIME);
        Column column9 = TypeUtils.newColumn("category", ColumnType.CATEGORY);
        for(int i = 0; i < 5; i++) {
            column1.addCell(String.valueOf(rand.nextInt()));
            column2.addCell(String.valueOf(Math.random() < 0.5 ? "TRUE" : "FALSE"));
            column3.addCell(String.valueOf(rand.nextLong()));
            column4.addCell(String.valueOf(rand.nextFloat()));
            column5.addCell(String.valueOf((short)rand.nextInt()));
            column6.addCell("1932-11-" + String.valueOf(19 + i));
            column7.addCell("09:42:53." + String.valueOf(234 + i));
            column8.addCell("2023-03-12T01:49:10." + String.valueOf(321 + i));
            column9.addCell("test" + i);
        }
        table = Table.create("table", column1, column2, column3, column4, column5, column6, column7, column8, column9);
    }

    @Test
    public void testWrite() throws IOException {
        String fileName = "src\\unittest\\io\\csv\\writeTest.csv";
        CsvWriter.write(fileName, table);
        CSVReader reader = new CSVReader(new FileReader(fileName), ',');
        Compare.compare(reader, table, true);
    }

}
