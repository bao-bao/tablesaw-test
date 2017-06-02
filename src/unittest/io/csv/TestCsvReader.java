package io.csv;

/* Created by AMXPC on 2017/5/28. */

import com.github.lwhite1.tablesaw.api.ColumnType;
import com.github.lwhite1.tablesaw.api.Table;
import com.github.lwhite1.tablesaw.io.csv.CsvReader;
import com.opencsv.CSVReader;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class TestCsvReader {
    String fileName;
    ColumnType[] types;
    boolean header;

    @Before
    public void setUp() {
        fileName = "src\\unittest\\io\\csv\\writeTest.csv";
        types = new ColumnType[]{
                ColumnType.INTEGER,
                ColumnType.BOOLEAN,
                ColumnType.LONG_INT,
                ColumnType.FLOAT,
                ColumnType.SHORT_INT,
                ColumnType.LOCAL_DATE,
                ColumnType.LOCAL_TIME,
                ColumnType.LOCAL_DATE_TIME,
                ColumnType.CATEGORY
        };
        header = true;
    }

    @Test
    public void testRead() throws IOException {
        InputStream stream = new FileInputStream(fileName);
        Table table = CsvReader.read(fileName, types, header, ',', stream);

        CSVReader reader = new CSVReader(new FileReader(fileName), ',');
        Compare.compare(reader, table, header);
    }

    @Test
    public void testHeaderOnly() throws IOException {
        InputStream stream = new FileInputStream(fileName);
        Table table = CsvReader.headerOnly(fileName, types, header, ',', stream);

        CSVReader reader = new CSVReader(new FileReader(fileName), ',');
        Compare.compare(reader, table, header);
    }

    @Test
    public void testPrintColumnTypes() throws IOException {
        String columnTypes = CsvReader.printColumnTypes(fileName, header, ',');
        String expected = "ColumnType[] columnTypes = {\n" +
                "INTEGER,        // 0     int         \n" +
                "BOOLEAN,        // 1     boolean     \n" +
                "LONG_INT,       // 2     long        \n" +
                "FLOAT,          // 3     float       \n" +
                "SHORT_INT,      // 4     short       \n" +
                "LOCAL_DATE,     // 5     date        \n" +
                "LOCAL_TIME,     // 6     time        \n" +
                "LOCAL_DATE_TIME, // 7     datetime    \n" +
                "CATEGORY,       // 8     category    \n" +
                "}\n";
        assertThat(columnTypes, is(expected));
    }

    @Test
    public void testDetectColumnTypes() throws IOException {
        ColumnType[] columnTypes = CsvReader.detectColumnTypes(fileName, header, ',');
        ColumnType[] expected = types;
        assertThat(columnTypes, is(expected));
    }

    @Test
    public void testNextRow() {
        int input = -1;
        int result = CsvReader.nextRow(input);
        int expected = 0;
        assertThat(result, is(expected));
    }

    @Test
    public void testDetectType() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("-34");
        strings.add("91");
        strings.add("0");
        strings.add("10");
        ColumnType result = CsvReader.detectType(null);
        ColumnType expected = ColumnType.SKIP;
        assertThat(result, is(expected));
    }
}
