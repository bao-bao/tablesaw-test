package io.csv;

/* Created by AMXPC on 2017/6/1. */

import com.github.lwhite1.tablesaw.api.Table;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Compare {
    public static void compare(CSVReader reader, Table table, boolean header) throws IOException {
        String[] nextLine;
        String[] tableLine = new String[table.columnCount()];
        int row = header ? -1 : 0;
        while ((nextLine = reader.readNext()) != null) {
            if( row == -1) {
                for(int i = 0; i < table.columnCount(); i++) {
                    tableLine[i] = table.column(i).name();
                }
            }
            else {
                for (int i = 0; i < table.columnCount(); i++) {
                    tableLine[i] = table.get(i, row);
                }
            }
            assertThat(nextLine, is(tableLine));
            row++;
        }
    }
}
