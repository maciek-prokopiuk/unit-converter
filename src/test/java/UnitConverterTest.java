import com.worldremit.Config;
import com.worldremit.UnitConverter;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class UnitConverterTest {

    private UnitConverter unitConverter = new UnitConverter(Config.getAvailableConverters());

    @Test
    public void shouldConvertInToCm() {
        double result = unitConverter.convert(666, "in", "cm");

        assertThat(result).isEqualTo(1691.64);
    }

    @Test
    public void shouldConvertCmToM() {
        double result = unitConverter.convert(123, "cm", "m");

        assertThat(result).isEqualTo(1.23);
    }

    @Test
    public void shouldConvertKgToLb() {
        double result = unitConverter.convert(1500100900, "kg", "lb");

        assertThat(result).isEqualTo(3.307159076879663E9);
    }

    @Test
    public void shouldConvertMToIn() {
        double result = unitConverter.convert(100, "m", "in");

        assertThat(result).isEqualTo(3937.007874015748);
    }

    @Test
    public void shouldThrowExceptionInCaseOfDifferentTypeOfUnits() {
        Throwable throwable = catchThrowable(() -> unitConverter.convert(100, "m", "kg"));

        assertThat(throwable)
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("Cannot convert between different types of converters. (eg. mass and length)");
    }

    @Test
    public void shouldThrowExceptionIfUnknownUnit() {
        Throwable throwable = catchThrowable(() -> unitConverter.convert(100, "m", "xxx"));

        assertThat(throwable)
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("Unit xxx not supported.");
    }
}
