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

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class TestCsvReader {
    String fileName;
    ColumnType[] types;

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

    }

    @Test
    public void testRead() throws IOException {
        InputStream stream = new FileInputStream(fileName);
        boolean header = false;
        Table table = CsvReader.read(fileName, types, header, ',', stream);

        CSVReader reader = new CSVReader(new FileReader(fileName), ',');
        Compare.compare(reader, table, header);
    }

    @Test
    public void testHeaderOnly() throws IOException {
        InputStream stream = new FileInputStream(fileName);
        boolean header = true;
        Table table = CsvReader.headerOnly(fileName, types, header, ',', stream);

        CSVReader reader = new CSVReader(new FileReader(fileName), ',');
        Compare.compare(reader, table, header);
    }

    @Test
    public void testPrintColumnTypes() {

    }

    @Test
    public void testDetectColumnTypes() {

    }

    @Test
    public void testNextRow() {

    }

    @Test
    public void testDetectType() {

    }
}
