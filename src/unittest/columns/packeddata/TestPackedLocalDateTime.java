package columns.packeddata;

import com.github.lwhite1.tablesaw.columns.packeddata.PackedLocalDateTime;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/* Created by AMXPC on 2017/5/28. */

public class TestPackedLocalDateTime {

    @Test
    public void testToString() {
//        char mill = 32194;
//        byte s = (byte) mill;
//        byte n = (byte) ((mill >> 8) & 0xff);
//        long l = PackedLocalDateTime.pack((short)482,(byte)13,(byte)4,(byte)12, (byte) 49,n,s);
//        System.out.print(l);
//        System.out.println(PackedLocalDateTime.toString(input));

        String expected = "Error";
        long input = 0x23985f4394da82L;
        String result = PackedLocalDateTime.toString(input);
        assertThat(result, is(expected));
    }
}
