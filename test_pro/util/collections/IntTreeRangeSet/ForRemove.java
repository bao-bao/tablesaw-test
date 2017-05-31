package util.collections.IntTreeRangeSet;

import com.github.lwhite1.tablesaw.util.collections.IntRange;
import com.github.lwhite1.tablesaw.util.collections.IntTreeRangeSet;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by yikui on 2017/5/30.
 */
public class ForRemove {

    @Test(expected = IllegalArgumentException.class)
    public void TU_ITS_10_01_001() throws Exception {
        IntTreeRangeSet itrs = itrs_init();
        itrs.remove(IntRange.open(0,0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void TU_ITS_10_01_002() throws Exception {
        IntTreeRangeSet itrs = itrs_init();
        itrs.remove(IntRange.open(1,-1));
    }

    @Test
    public void TU_ITS_10_02_001() throws Exception {
        IntTreeRangeSet itrs = itrs_init();
        itrs.remove(IntRange.open(-12,-11));
        assertEquals("[(-10..-5), (5..10)]", itrs.toString());
    }

    @Test
    public void TU_ITS_10_02_002() throws Exception {
        IntTreeRangeSet itrs = itrs_init();
        itrs.remove(IntRange.open(-1,1));
        assertEquals("[(-10..-5), (5..10)]", itrs.toString());
    }

    @Test
    public void TU_ITS_10_02_003() throws Exception {
        IntTreeRangeSet itrs = itrs_init();
        itrs.remove(IntRange.open(11,12));
        assertEquals("[(-10..-5), (5..10)]", itrs.toString());
    }

    @Test
    public void TU_ITS_10_03_001() throws Exception {
        IntTreeRangeSet itrs = itrs_init();
        itrs.remove(IntRange.open(-11,-9));
        assertEquals("[[-9..-5), (5..10)]", itrs.toString());
    }

    @Test
    public void TU_ITS_10_03_002() throws Exception {
        IntTreeRangeSet itrs = itrs_init();
        itrs.remove(IntRange.closed(-7,7));
        assertEquals("[(-10..-7), (7..10)]", itrs.toString());
    }

    @Test
    public void TU_ITS_10_03_003() throws Exception {
        IntTreeRangeSet itrs = itrs_init();
        itrs.remove(IntRange.open(9,11));
        assertEquals("[(-10..-5), (5..9]]", itrs.toString());
    }

    @Test
    public void TU_ITS_10_04_001() throws Exception {
        IntTreeRangeSet itrs = itrs_init();
        itrs.remove(IntRange.open(-8,-7));
        assertEquals("[(-10..-8], [-7..-5), (5..10)]", itrs.toString());
    }

    @Test
    public void TU_ITS_10_05_001() throws Exception {
        IntTreeRangeSet itrs = itrs_init();
        itrs.remove(IntRange.open(-11,11));
        assertEquals("[]", itrs.toString());
    }

    public static IntTreeRangeSet itrs_init()
    {
        IntTreeRangeSet itrsi = IntTreeRangeSet.create();
        itrsi.add(IntRange.open(-10, -5));
        itrsi.add(IntRange.open(5, 10));
        return itrsi;
    }

}
