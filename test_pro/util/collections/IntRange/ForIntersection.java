package util.collections.IntRange;

import com.github.lwhite1.tablesaw.util.collections.IntRange;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by yikui on 2017/5/30.
 */
public class ForIntersection {

    @Test(expected = NullPointerException.class)
    public void TU_IR_30_01_001() throws Exception {
        IntRange oir = null;
        IntRange pir = IntRange.open(-1,1);
        IntRange fir = oir.intersection(pir);
    }

    @Test(expected = NullPointerException.class)
    public void TU_IR_30_01_002() throws Exception {
        IntRange oir = IntRange.open(-1,1);
        IntRange pir = null;
        IntRange fir = oir.intersection(pir);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TU_IR_30_02_001() throws Exception {
        IntRange oir = IntRange.open(-2,0);
        IntRange pir = IntRange.open(0,2);
        IntRange fir = oir.intersection(pir);
    }

    @Test
    public void TU_IR_30_03_001() throws Exception {
        IntRange oir = IntRange.open(-2,1);
        IntRange pir = IntRange.open(-1,2);
        IntRange fir = oir.intersection(pir);
        assertEquals("(-1..1)", fir.toString());
    }

    @Test
    public void TU_IR_30_03_002() throws Exception {
        IntRange oir = IntRange.open(-1,2);
        IntRange pir = IntRange.open(-2,1);
        IntRange fir = oir.intersection(pir);
        assertEquals("(-1..1)", fir.toString());
    }

    @Test
    public void TU_IR_30_03_003() throws Exception {
        IntRange oir = IntRange.open(-2,2);
        IntRange pir = IntRange.open(-1,1);
        IntRange fir = oir.intersection(pir);
        assertEquals("(-1..1)", fir.toString());
    }

    @Test
    public void TU_IR_30_03_004() throws Exception {
        IntRange oir = IntRange.open(-1,1);
        IntRange pir = IntRange.open(-2,2);
        IntRange fir = oir.intersection(pir);
        assertEquals("(-1..1)", fir.toString());
    }

}