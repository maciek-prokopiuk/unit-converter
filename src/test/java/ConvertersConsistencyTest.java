import com.worldremit.converters.Converter;
import org.junit.Test;
import org.reflections.Reflections;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.fail;

public class ConvertersConsistencyTest {

    @Test
    public void checkIfConvertersHaveUniqueUnitNames() throws IllegalAccessException, InstantiationException {
        Set<String> allUnits = new HashSet<>();

        Reflections reflections = new Reflections("com/worldremit/converters");
        Set<Class<? extends Converter>> classes = reflections.getSubTypesOf(Converter.class);

        for (Class<? extends Converter> converter : classes) {
            Converter instance = converter.newInstance();
            for (String unit : instance.availableUnits()) {
                if (allUnits.contains(unit)) {
                    fail("Found duplicated unit in " + converter.getName());
                }
                allUnits.add(unit);
            }
        }
    }
}
