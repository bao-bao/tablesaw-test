package util.collections.IntRange;

import com.github.lwhite1.tablesaw.util.collections.IntRange;
import it.unimi.dsi.fastutil.floats.FloatArrayList;
import it.unimi.dsi.fastutil.floats.FloatCollection;
import it.unimi.dsi.fastutil.ints.IntAVLTreeSet;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntCollection;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by yikui on 2017/5/30.
 */
public class ForEncloseAll {

    @Test(expected = NullPointerException.class)
    public void TU_IR_15_01_001() throws Exception {
        IntCollection ic = null;
        IntRange.encloseAll(ic);
    }

    @Test(expected = NumberFormatException.class)
    public void TU_IR_15_02_001() throws Exception {
        IntCollection ic = new IntArrayList();
        ic.add(Integer.parseInt("1.0"));
        IntRange.encloseAll(ic);
    }

    @Test(expected = NumberFormatException.class)
    public void TU_IR_15_02_002() throws Exception {
        IntCollection ic = new IntArrayList();
        ic.add(Integer.parseInt("-2200000000"));
        ic.add(Integer.parseInt("2200000000"));
        IntRange.encloseAll(ic);
    }

    @Test
    public void TU_IR_15_03_001() throws Exception {
        IntCollection ic = new IntAVLTreeSet();
        ic.add(-1);
        ic.add(0);
        ic.add(1);
        IntRange ir = IntRange.encloseAll(ic);
        assertEquals("[-1..1]", ir.toString());
    }

    @Test
    public void TU_IR_15_04_001() throws Exception {
        IntCollection ic = new IntArrayList();
        ic.add(-1);
        ic.add(0);
        ic.add(1);
        IntRange ir = IntRange.encloseAll(ic);
        assertEquals("[-1..1]", ir.toString());
    }

    @Test
    public void TU_IR_15_04_002() throws Exception {
        IntCollection ic = new IntArrayList();
        ic.add(1);
        ic.add(0);
        ic.add(-1);
        IntRange ir = IntRange.encloseAll(ic);
        assertEquals("[-1..1]", ir.toString());
    }

    @Test
    public void TU_IR_15_04_003() throws Exception {
        IntCollection ic = new IntArrayList();
        ic.add(0);
        ic.add(-1);
        ic.add(1);
        IntRange ir = IntRange.encloseAll(ic);
        assertEquals("[-1..1]", ir.toString());
    }

    @Test
    public void TU_IR_15_05_001() throws Exception {
        IntCollection ic = new IntArrayList();
        ic.add(-1);
        ic.add(0);
        ic.add(0);
        ic.add(1);
        IntRange ir = IntRange.encloseAll(ic);
        assertEquals("[-1..1]", ir.toString());
    }

    @Test
    public void TU_IR_15_05_002() throws Exception {
        IntCollection ic = new IntArrayList();
        ic.add(1);
        ic.add(0);
        ic.add(0);
        ic.add(-1);
        IntRange ir = IntRange.encloseAll(ic);
        assertEquals("[-1..1]", ir.toString());
    }

    @Test
    public void TU_IR_15_05_003() throws Exception {
        IntCollection ic = new IntArrayList();
        ic.add(0);
        ic.add(-1);
        ic.add(0);
        ic.add(1);
        IntRange ir = IntRange.encloseAll(ic);
        assertEquals("[-1..1]", ir.toString());
    }
}
