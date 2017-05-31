package util.collections.IntRange;

import com.github.lwhite1.tablesaw.util.collections.IntRange;
import com.google.common.collect.BoundType;
import org.junit.Test;

import static com.google.common.collect.BoundType.CLOSED;
import static com.google.common.collect.BoundType.OPEN;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by yikui on 2017/5/29.
 */
public class ForUpTo {

    @Test(expected = NumberFormatException.class)
    public void TU_IR_11_01_001() throws Exception {
        IntRange intrange1 = IntRange.upTo(Integer.parseInt(""), BoundType.valueOf("OPEN"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void TU_IR_11_01_002() throws Exception {
        IntRange intrange1 = IntRange.upTo(Integer.parseInt("0"), BoundType.valueOf(""));
    }

    @Test(expected = NumberFormatException.class)
    public void TU_IR_11_02_001() throws Exception {
        IntRange intrange1 = IntRange.upTo(Integer.parseInt("-2200000000"), BoundType.valueOf("OPEN"));
    }

    @Test(expected = NumberFormatException.class)
    public void TU_IR_11_02_002() throws Exception {
        IntRange intrange1 = IntRange.upTo(Integer.parseInt("2200000000"), BoundType.valueOf("OPEN"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void TU_IR_11_03_001() throws Exception {
        IntRange intrange1 = IntRange.upTo(Integer.parseInt("0"), BoundType.valueOf("SEMI_OPEN"));
    }

    @Test
    public void TU_IR_11_04_001() throws Exception {
        IntRange intrange1 = IntRange.upTo(Integer.parseInt("0"), BoundType.valueOf("OPEN"));
        assertEquals("(-∞..0)", intrange1.toString());
    }

    @Test
    public void TU_IR_11_04_002() throws Exception {
        IntRange intrange1 = IntRange.upTo(Integer.parseInt("0"), BoundType.valueOf("CLOSED"));
        assertEquals("(-∞..0]", intrange1.toString());
    }
}
