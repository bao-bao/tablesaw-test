package util.collections.IntRange;

import com.github.lwhite1.tablesaw.util.collections.IntRange;
import it.unimi.dsi.fastutil.ints.IntAVLTreeSet;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntCollection;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by yikui on 2017/5/30.
 */
public class ForContainsAll {

    @Test(expected = NullPointerException.class)
    public void TU_IR_27_01_001() throws Exception {
        IntCollection ic = null;
        IntRange ir = IntRange.open(-1,1);
        ir.containsAll(ic);
    }

    @Test(expected = NumberFormatException.class)
    public void TU_IR_27_02_001() throws Exception {
        IntCollection ic = new IntArrayList();
        ic.add(Integer.parseInt("1.0"));
        IntRange ir = IntRange.open(-1,1);
        ir.containsAll(ic);
    }

    @Test(expected = NumberFormatException.class)
    public void TU_IR_27_02_002() throws Exception {
        IntCollection ic = new IntArrayList();
        ic.add(Integer.parseInt("-2200000000"));
        ic.add(Integer.parseInt("2200000000"));
        IntRange ir = IntRange.open(-1,1);
        ir.containsAll(ic);
    }

    @Test
    public void TU_IR_27_03_001() throws Exception {
        IntCollection ic = new IntAVLTreeSet();
        ic.add(0);
        ic.add(1);
        IntRange ir = IntRange.open(0,1);
        boolean irbool = ir.containsAll(ic);
        assertFalse(irbool);
    }

    @Test
    public void TU_IR_27_04_001() throws Exception {
        IntCollection ic = new IntAVLTreeSet();
        ic.add(-1);
        ic.add(0);
        ic.add(1);
        IntRange ir = IntRange.open(-1,1);
        boolean irbool = ir.containsAll(ic);
        assertFalse(irbool);
    }

    @Test
    public void TU_IR_27_05_001() throws Exception {
        IntCollection ic = new IntAVLTreeSet();
        ic.add(-1);
        ic.add(0);
        ic.add(1);
        IntRange ir = IntRange.closed(-1,1);
        boolean irbool = ir.containsAll(ic);
        assertTrue(irbool);
    }

    @Test
    public void TU_IR_27_06_001() throws Exception {
        IntCollection ic = new IntArrayList();
        ic.add(-1);
        ic.add(0);
        ic.add(1);
        IntRange ir = IntRange.open(-2,-1);
        boolean irbool = ir.containsAll(ic);
        assertFalse(irbool);
    }

    @Test
    public void TU_IR_27_06_002() throws Exception {
        IntCollection ic = new IntArrayList();
        ic.add(1);
        ic.add(0);
        ic.add(-1);
        IntRange ir = IntRange.open(-2,-1);
        boolean irbool = ir.containsAll(ic);
        assertFalse(irbool);
    }

    @Test
    public void TU_IR_27_06_003() throws Exception {
        IntCollection ic = new IntArrayList();
        ic.add(0);
        ic.add(-1);
        ic.add(1);
        IntRange ir = IntRange.open(-2,-1);
        boolean irbool = ir.containsAll(ic);
        assertFalse(irbool);
    }

    @Test
    public void TU_IR_27_06_004() throws Exception {
        IntCollection ic = new IntArrayList();
        ic.add(-1);
        ic.add(0);
        ic.add(1);
        ic.add(0);
        IntRange ir = IntRange.open(-2,-1);
        boolean irbool = ir.containsAll(ic);
        assertFalse(irbool);
    }

    @Test
    public void TU_IR_27_07_001() throws Exception {
        IntCollection ic = new IntArrayList();
        ic.add(-1);
        ic.add(0);
        ic.add(1);
        IntRange ir = IntRange.open(-1,1);
        boolean irbool = ir.containsAll(ic);
        assertFalse(irbool);
    }

    @Test
    public void TU_IR_27_07_002() throws Exception {
        IntCollection ic = new IntArrayList();
        ic.add(1);
        ic.add(0);
        ic.add(-1);
        IntRange ir = IntRange.open(-1,1);
        boolean irbool = ir.containsAll(ic);
        assertFalse(irbool);
    }

    @Test
    public void TU_IR_27_07_003() throws Exception {
        IntCollection ic = new IntArrayList();
        ic.add(0);
        ic.add(-1);
        ic.add(1);
        IntRange ir = IntRange.open(-1,1);
        boolean irbool = ir.containsAll(ic);
        assertFalse(irbool);
    }

    @Test
    public void TU_IR_27_07_004() throws Exception {
        IntCollection ic = new IntArrayList();
        ic.add(-1);
        ic.add(0);
        ic.add(1);
        ic.add(0);
        IntRange ir = IntRange.open(-1,1);
        boolean irbool = ir.containsAll(ic);
        assertFalse(irbool);
    }

    @Test
    public void TU_IR_27_08_001() throws Exception {
        IntCollection ic = new IntArrayList();
        ic.add(-1);
        ic.add(0);
        ic.add(1);
        IntRange ir = IntRange.closed(-1,1);
        boolean irbool = ir.containsAll(ic);
        assertTrue(irbool);
    }

    @Test
    public void TU_IR_27_08_002() throws Exception {
        IntCollection ic = new IntArrayList();
        ic.add(1);
        ic.add(0);
        ic.add(-1);
        IntRange ir = IntRange.closed(-1,1);
        boolean irbool = ir.containsAll(ic);
        assertTrue(irbool);
    }

    @Test
    public void TU_IR_27_08_003() throws Exception {
        IntCollection ic = new IntArrayList();
        ic.add(0);
        ic.add(-1);
        ic.add(1);
        IntRange ir = IntRange.closed(-1,1);
        boolean irbool = ir.containsAll(ic);
        assertTrue(irbool);
    }

    @Test
    public void TU_IR_27_08_004() throws Exception {
        IntCollection ic = new IntArrayList();
        ic.add(-1);
        ic.add(0);
        ic.add(1);
        ic.add(0);
        IntRange ir = IntRange.closed(-1,1);
        boolean irbool = ir.containsAll(ic);
        assertTrue(irbool);
    }
}
