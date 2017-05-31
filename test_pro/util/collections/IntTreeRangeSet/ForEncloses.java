package util.collections.IntTreeRangeSet;

import com.github.lwhite1.tablesaw.util.collections.IntRange;
import com.github.lwhite1.tablesaw.util.collections.IntTreeRangeSet;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by yikui on 2017/5/30.
 */
public class ForEncloses {
    
    private IntTreeRangeSet itrs = IntTreeRangeSet.create();

    @Before
    public void setUp() throws Exception {
        itrs.add(IntRange.openClosed(-8, -6));
        itrs.add(IntRange.open(-4, -2));
        itrs.add(IntRange.closedOpen(0, 2));
        itrs.add(IntRange.open(4, 6));
    }

    @Test(expected = NullPointerException.class)
    public void TU_ITS_06_01_001() throws Exception {
        IntRange ir = null;
        itrs.encloses(ir);
    }

    @Test
    public void TU_ITS_06_02_001() throws Exception {
        IntRange ir = IntRange.open(-12, -10);
        boolean inbool = itrs.encloses(ir);
        assertFalse(inbool);
    }

    @Test
    public void TU_ITS_06_02_002() throws Exception {
        IntRange ir = IntRange.open(-2, -1);
        boolean inbool = itrs.encloses(ir);
        assertFalse(inbool);
    }

    @Test
    public void TU_ITS_06_02_003() throws Exception {
        IntRange ir = IntRange.open(8, 10);
        boolean inbool = itrs.encloses(ir);
        assertFalse(inbool);
    }

    @Test
    public void TU_ITS_06_03_001() throws Exception {
        IntRange ir = IntRange.open(-9, 7);
        boolean inbool = itrs.encloses(ir);
        assertFalse(inbool);
    }

    @Test
    public void TU_ITS_06_03_002() throws Exception {
        IntRange ir = IntRange.open(-5, -3);
        boolean inbool = itrs.encloses(ir);
        assertFalse(inbool);
    }

    @Test
    public void TU_ITS_06_03_003() throws Exception {
        IntRange ir = IntRange.open(-3, 1);
        boolean inbool = itrs.encloses(ir);
        assertFalse(inbool);
    }

    @Test
    public void TU_ITS_06_03_004() throws Exception {
        IntRange ir = IntRange.open(1, 5);
        boolean inbool = itrs.encloses(ir);
        assertFalse(inbool);
    }

    @Test
    public void TU_ITS_06_03_005() throws Exception {
        IntRange ir = IntRange.open(5, 7);
        boolean inbool = itrs.encloses(ir);
        assertFalse(inbool);
    }

    @Test
    public void TU_ITS_06_04_001() throws Exception {
        IntRange ir = IntRange.closed(-8, -6);
        boolean inbool = itrs.encloses(ir);
        assertFalse(inbool);
    }

    @Test
    public void TU_ITS_06_04_002() throws Exception {
        IntRange ir = IntRange.openClosed(-4, -2);
        boolean inbool = itrs.encloses(ir);
        assertFalse(inbool);
    }

    @Test
    public void TU_ITS_06_04_003() throws Exception {
        IntRange ir = IntRange.open(-4, 2);
        boolean inbool = itrs.encloses(ir);
        assertFalse(inbool);
    }

    @Test
    public void TU_ITS_06_04_004() throws Exception {
        IntRange ir = IntRange.closed(0, 6);
        boolean inbool = itrs.encloses(ir);
        assertFalse(inbool);
    }

    @Test
    public void TU_ITS_06_05_001() throws Exception {
        IntRange ir = IntRange.openClosed(-8, -6);
        boolean inbool = itrs.encloses(ir);
        assertTrue(inbool);
    }

    @Test
    public void TU_ITS_06_05_002() throws Exception {
        IntRange ir = IntRange.open(-4, -3);
        boolean inbool = itrs.encloses(ir);
        assertTrue(inbool);
    }

    @Test
    public void TU_ITS_06_05_003() throws Exception {
        IntRange ir = IntRange.closed(0, 1);
        boolean inbool = itrs.encloses(ir);
        assertTrue(inbool);
    }

    @Test
    public void TU_ITS_06_05_004() throws Exception {
        IntRange ir = IntRange.open(5, 6);
        boolean inbool = itrs.encloses(ir);
        assertTrue(inbool);
    }
}
