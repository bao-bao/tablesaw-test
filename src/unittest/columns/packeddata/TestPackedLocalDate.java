package columns.packeddata;

import com.github.lwhite1.tablesaw.columns.packeddata.PackedLocalDate;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/* Created by AMXPC on 2017/5/28. */

public class TestPackedLocalDate {

    @Test
    public void testToEpochDay() {
//        int i = PackedLocalDate.pack((short)1329, (byte)1, (byte)31);
//        System.out.println(i);
        long expected = -234090;
        int input = 822411551;
        long result = PackedLocalDate.toEpochDay(input);
        assertThat(result, is(expected));
    }

}
