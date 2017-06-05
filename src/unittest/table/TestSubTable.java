package table;

/* Created by AMXPC on 2017/5/28. */

import com.github.lwhite1.tablesaw.api.ColumnType;
import com.github.lwhite1.tablesaw.api.Table;
import com.github.lwhite1.tablesaw.columns.Column;
import com.github.lwhite1.tablesaw.io.TypeUtils;
import com.github.lwhite1.tablesaw.table.SubTable;
import org.junit.Before;

import java.util.Random;

public class TestSubTable {
    Column column0 = null;
    Column column00 = null;
    Column column000 = null;
    Table table1 = null;
    SubTable subTable1 = null;

    @Before
    public void setUp() {
        Random rand = new Random(34872);
        //initialize columns
        column0 = TypeUtils.newColumn("column0", ColumnType.FLOAT);
        for (int i = 0; i < 2; i++) {
            column0.addCell(String.valueOf(Math.random()));
        }

        column00 = TypeUtils.newColumn("column00", ColumnType.FLOAT);
        for (int i = 0; i < 2; i++) {
            column00.addCell(String.valueOf(Math.random()));
        }

        table1 = Table.create("1", column0, column00);
        //subTable1 = new SubTable(table1);

    }


}
