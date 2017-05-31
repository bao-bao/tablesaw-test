package io;

import com.github.lwhite1.tablesaw.api.ColumnType;
import com.github.lwhite1.tablesaw.api.FloatColumn;
import com.github.lwhite1.tablesaw.columns.Column;
import com.github.lwhite1.tablesaw.io.TypeUtils;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/* Created by AMXPC on 2017/5/28. */

public class TestTypeUtils {

    @Test
    public void testNewColumn() {
        String errorMessage = "";
        Column result = null;
        try {
            result = TypeUtils.newColumn("canvas", ColumnType.valueOf(""));
        }
        catch (IllegalArgumentException e) {
            errorMessage = e.getMessage();
        }
        assertThat(result, is(nullValue()));
        if(result != null) {
            assertThat(result.name(), is("canvas"));
        }
        assertThat(errorMessage, is(""));
    }
}
