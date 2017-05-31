package util.Stats;

import com.github.lwhite1.tablesaw.api.Table;
import com.github.lwhite1.tablesaw.util.Stats;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by yikui on 2017/5/30.
 */
public class ForAsTableComplete {

    @Test(expected = NullPointerException.class)
    public void TU_S_20_01_001() throws Exception {
        Stats stats1 = null;
        Table table1 = stats1.asTableComplete();
        table1.toString();
    }

    @Test
    public void TU_S_20_02_001() throws Exception {
        Stats stats1 = new Stats("1");
        Table table1 = stats1.asTableComplete();
        assertEquals("Table 1: Size = 14 x 2", table1.toString());
    }

}
