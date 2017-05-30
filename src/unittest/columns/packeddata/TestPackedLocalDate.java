package columns.packeddata;

import com.github.lwhite1.tablesaw.columns.packeddata.PackedLocalDate;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/* Created by AMXPC on 2017/5/28. */

public class TestPackedLocalDate {

    @Test
    public void testToEpochDay() {
        long expected = -865389;
        int input = 1895696408;
        long result = PackedLocalDate.toEpochDay(input);
        assertThat(result, is(expected));
    }

}
