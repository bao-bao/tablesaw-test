package util.collections.IntRange;

import com.github.lwhite1.tablesaw.util.collections.IntRange;
import com.google.common.collect.BoundType;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by yikui on 2017/5/30.
 */
public class ForDownTo {
    @Test(expected = NumberFormatException.class)
    public void TU_IR_12_01_001() throws Exception {
        IntRange intrange1 = IntRange.downTo(Integer.parseInt(""), BoundType.valueOf("OPEN"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void TU_IR_12_01_002() throws Exception {
        IntRange intrange1 = IntRange.downTo(Integer.parseInt("0"), BoundType.valueOf(""));
    }

    @Test(expected = NumberFormatException.class)
    public void TU_IR_12_02_001() throws Exception {
        IntRange intrange1 = IntRange.downTo(Integer.parseInt("-2200000000"), BoundType.valueOf("OPEN"));
    }

    @Test(expected = NumberFormatException.class)
    public void TU_IR_12_02_002() throws Exception {
        IntRange intrange1 = IntRange.downTo(Integer.parseInt("2200000000"), BoundType.valueOf("OPEN"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void TU_IR_12_03_001() throws Exception {
        IntRange intrange1 = IntRange.downTo(Integer.parseInt("0"), BoundType.valueOf("SEMI_OPEN"));
    }

    @Test
    public void TU_IR_12_04_001() throws Exception {
        IntRange intrange1 = IntRange.downTo(Integer.parseInt("0"), BoundType.valueOf("OPEN"));
        assertEquals("(0..+∞)", intrange1.toString());
    }

    @Test
    public void TU_IR_12_04_002() throws Exception {
        IntRange intrange1 = IntRange.downTo(Integer.parseInt("0"), BoundType.valueOf("CLOSED"));
        assertEquals("[0..+∞)", intrange1.toString());
    }
}
