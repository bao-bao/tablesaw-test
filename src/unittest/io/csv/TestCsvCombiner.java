package io.csv;

import com.github.lwhite1.tablesaw.io.csv.CsvCombiner;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/* Created by AMXPC on 2017/5/28. */

public class TestCsvCombiner {
    private String target;
    private FileWriter writer;
    private CSVWriter csvWriter;

    @Before
    public void setUp() throws IOException {
        this.target = "src\\unittest\\io\\csv\\combined.csv";
        this.writer = new FileWriter(this.target);
        this.csvWriter = new CSVWriter(this.writer, ',');
    }

    @Test
    public void testAppend() throws IOException {
        String filePath = "src\\unittest\\io\\csv\\test1.csv";
        File file = new File(filePath);
        if (Files.isRegularFile(file.toPath()) && file.toPath().toString().endsWith(".csv")) {
            CsvCombiner.append(file.toPath().toString(), csvWriter, ',', false);
        }
        filePath = "src\\unittest\\io\\csv\\test2.csv";
        file = new File(filePath);
        if (Files.isRegularFile(file.toPath()) && file.toPath().toString().endsWith(".csv")) {
            CsvCombiner.append(file.toPath().toString(), csvWriter, ',', true);
        }
        this.writer.flush();

        CSVReader reader = null;
        CSVReader source = null;
        try {
            reader = new CSVReader(new FileReader(this.target), ',');
            source = new CSVReader(new FileReader("src\\unittest\\io\\csv\\test1.csv"), ',');
            String[] nextLine;
            String[] sourceLine;
            while ( (sourceLine = source.readNext()) != null && (nextLine = reader.readNext()) != null) {
                assertThat(nextLine, is(sourceLine));
            }
            try {
                source.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            source = new CSVReader(new FileReader("src\\unittest\\io\\csv\\test2.csv"), ',');
            source.readNext();     // skip header
            while ((sourceLine = source.readNext()) != null && (nextLine = reader.readNext()) != null) {
                assertThat(nextLine, is(sourceLine));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (source != null) {
                try {
                    source.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
