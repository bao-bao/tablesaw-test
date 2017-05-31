package plotting;

/* Created by AMXPC on 2017/5/28. */

import com.github.lwhite1.tablesaw.plotting.Hue;
import com.github.lwhite1.tablesaw.plotting.StandardColor;
import com.github.lwhite1.tablesaw.plotting.StandardColors;
import com.google.common.collect.Range;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.awt.*;
import java.util.List;

public class TestStandardColors {

    @Test
    public void testRandomColors() {
        int n = 5;
        List<Color> colors = StandardColors.randomColors(5);
        assertThat(colors.size(), is(n));
    }

    @Test
    public void testGetFilteredColors() {
        Hue hue = Hue.Blue_7_5;
        int maxChroma = 12;
        int minChroma = 8;
        int maxValue = 8;
        int minValue = 4;
        Range<Integer> chromaRange = Range.closed(minChroma, maxChroma);
        Range<Integer> valueRange = Range.closed(minValue, maxValue);

        List<StandardColor> standardColors = StandardColors.getFilteredColors(hue, chromaRange, valueRange);

        assertThat(standardColors.size(), is(3));
        for(StandardColor c : standardColors) {
            assertThat(c.chroma(), allOf(greaterThanOrEqualTo(minChroma), lessThanOrEqualTo(maxChroma)));
            assertThat(c.value(), allOf(greaterThanOrEqualTo(minValue), lessThanOrEqualTo(maxValue)));
        }
    }

    @Test
    public void testGetStandardColors() {
        List<Color> colors = StandardColors.standardColors();
        assertFalse(colors.isEmpty());
    }
}
