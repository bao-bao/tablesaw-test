package plotting;

/* Created by AMXPC on 2017/5/28. */

import com.github.lwhite1.tablesaw.plotting.Hue;
import com.github.lwhite1.tablesaw.plotting.StandardColor;
import com.github.lwhite1.tablesaw.plotting.StandardColors;
import com.google.common.collect.Range;
import org.junit.Test;

import java.awt.*;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class TestStandardColors {

    @Test
    public void testRandomColors() {
        int n = 5;
        try {
            List<Color> colors = StandardColors.randomColors(n);
            assertThat(colors.size(), is(n));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testGetFilteredColors() {
        Hue hue = Hue.Neutral;
        int maxChroma = 11;
        int minChroma = 5;
        int maxValue = 6;
        int minValue = 2;
        int expectedSize = 3;
        try {
            Range<Integer> chromaRange = Range.closed(minChroma, maxChroma);
            Range<Integer> valueRange = Range.closed(minValue, maxValue);

            List<StandardColor> standardColors = StandardColors.getFilteredColors(hue, chromaRange, valueRange);

            assertThat(standardColors.size(), is(expectedSize));
            for (StandardColor c : standardColors) {
                assertThat(c.chroma(), allOf(greaterThanOrEqualTo(minChroma), lessThanOrEqualTo(maxChroma)));
                assertThat(c.value(), allOf(greaterThanOrEqualTo(minValue), lessThanOrEqualTo(maxValue)));
            }
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testGetStandardColors() {
        List<Color> colors = StandardColors.standardColors();
        assertFalse(colors.isEmpty());
    }
}
