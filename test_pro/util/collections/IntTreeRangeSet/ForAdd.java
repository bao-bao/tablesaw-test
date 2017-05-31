package util.collections.IntTreeRangeSet;

import com.github.lwhite1.tablesaw.util.collections.IntRange;
import com.github.lwhite1.tablesaw.util.collections.IntTreeRangeSet;
import com.google.common.collect.BoundType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.Iterator;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by yikui on 2017/5/30.
 */
public class ForAdd {

    @Test(expected = IllegalArgumentException.class)
    public void TU_ITS_09_01_001() throws Exception {
        IntTreeRangeSet itrs = itrs_init();
        itrs.add(IntRange.open(0,0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void TU_ITS_09_01_002() throws Exception {
        IntTreeRangeSet itrs = itrs_init();
        itrs.add(IntRange.open(1,-1));
    }

    @Test
    public void TU_ITS_09_02_001() throws Exception {
        IntTreeRangeSet itrs = itrs_init();
        itrs.add(IntRange.open(-12,-11));
        assertEquals("[(-12..-11), (-10..-5), (5..10)]", itrs.toString());
    }

    @Test
    public void TU_ITS_09_02_002() throws Exception {
        IntTreeRangeSet itrs = itrs_init();
        itrs.add(IntRange.open(-1,1));
        assertEquals("[(-10..-5), (-1..1), (5..10)]", itrs.toString());
    }

    @Test
    public void TU_ITS_09_02_003() throws Exception {
        IntTreeRangeSet itrs = itrs_init();
        itrs.add(IntRange.closed(-5,5));
        assertEquals("[(-10..10)]", itrs.toString());
    }

    @Test
    public void TU_ITS_09_02_004() throws Exception {
        IntTreeRangeSet itrs = itrs_init();
        itrs.add(IntRange.open(11,12));
        assertEquals("[(-10..-5), (5..10), (11..12)]", itrs.toString());
    }

    @Test
    public void TU_ITS_09_03_001() throws Exception {
        IntTreeRangeSet itrs = itrs_init();
        itrs.add(IntRange.open(-11,-9));
        assertEquals("[(-11..-5), (5..10)]", itrs.toString());
    }

    @Test
    public void TU_ITS_09_03_002() throws Exception {
        IntTreeRangeSet itrs = itrs_init();
        itrs.add(IntRange.closed(-7,7));
        assertEquals("[(-10..10)]", itrs.toString());
    }

    @Test
    public void TU_ITS_09_03_003() throws Exception {
        IntTreeRangeSet itrs = itrs_init();
        itrs.add(IntRange.open(9,11));
        assertEquals("[(-10..-5), (5..11)]", itrs.toString());
    }

    @Test
    public void TU_ITS_09_04_001() throws Exception {
        IntTreeRangeSet itrs = itrs_init();
        itrs.add(IntRange.open(-8,-7));
        assertEquals("[(-10..-5), (5..10)]", itrs.toString());
    }

    @Test
    public void TU_ITS_09_05_001() throws Exception {
        IntTreeRangeSet itrs = itrs_init();
        itrs.add(IntRange.open(-11,11));
        assertEquals("[(-11..11)]", itrs.toString());
    }

    public static IntTreeRangeSet itrs_init()
    {
        IntTreeRangeSet itrsi = IntTreeRangeSet.create();
        itrsi.add(IntRange.open(-10, -5));
        itrsi.add(IntRange.open(5, 10));
        return itrsi;
    }

}
