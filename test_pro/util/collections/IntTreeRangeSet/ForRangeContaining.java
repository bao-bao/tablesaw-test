package util.collections.IntTreeRangeSet;

import com.github.lwhite1.tablesaw.util.collections.IntRange;
import com.github.lwhite1.tablesaw.util.collections.IntTreeRangeSet;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

/**
 * Created by yikui on 2017/5/30.
 */
public class ForRangeContaining {

    private IntTreeRangeSet itrs = IntTreeRangeSet.create();

    @Before
    public void setUp() throws Exception {
        itrs.add(IntRange.openClosed(-8, -6));
        itrs.add(IntRange.open(-4, -2));
        itrs.add(IntRange.closedOpen(0, 2));
        itrs.add(IntRange.open(4, 6));
    }

    @Test(expected = NumberFormatException.class)
    public void TU_ITS_05_01_001() throws Exception {
        int value = Integer.parseInt("1.0");
        IntRange ir = itrs.rangeContaining(value);
    }

    @Test(expected = NumberFormatException.class)
    public void TU_ITS_05_01_002() throws Exception {
        int value = Integer.parseInt("-2200000000");
        IntRange ir = itrs.rangeContaining(value);
    }

    @Test(expected = NumberFormatException.class)
    public void TU_ITS_05_01_003() throws Exception {
        int value = Integer.parseInt("2200000000");
        IntRange ir = itrs.rangeContaining(value);
    }

    @Test
    public void TU_ITS_05_02_001() throws Exception {
        int value = Integer.parseInt("-9");
        IntRange ir = itrs.rangeContaining(value);
        assertNull(ir);
    }

    @Test
    public void TU_ITS_05_02_002() throws Exception {
        int value = Integer.parseInt("-1");
        IntRange ir = itrs.rangeContaining(value);
        assertNull(ir);
    }

    @Test
    public void TU_ITS_05_02_003() throws Exception {
        int value = Integer.parseInt("9");
        IntRange ir = itrs.rangeContaining(value);
        assertNull(ir);
    }

    @Test
    public void TU_ITS_05_03_001() throws Exception {
        int value = Integer.parseInt("-6");
        IntRange ir = itrs.rangeContaining(value);
        assertEquals("(-8..-6]", ir.toString());
    }

    @Test
    public void TU_ITS_05_03_002() throws Exception {
        int value = Integer.parseInt("-3");
        IntRange ir = itrs.rangeContaining(value);
        assertEquals("(-4..-2)", ir.toString());
    }

    @Test
    public void TU_ITS_05_03_003() throws Exception {
        int value = Integer.parseInt("0");
        IntRange ir = itrs.rangeContaining(value);
        assertEquals("[0..2)", ir.toString());
    }

    @Test
    public void TU_ITS_05_03_004() throws Exception {
        int value = Integer.parseInt("5");
        IntRange ir = itrs.rangeContaining(value);
        assertEquals("(4..6)", ir.toString());
    }
}
