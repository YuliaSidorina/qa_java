import com.example.Lion;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    @InjectMocks
    private Lion lion;

    @Mock
    private Feline mockFeline;

    private final String sex;
    private final boolean expectedHasMane;

    public LionParameterizedTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"Неверный пол", false} // Любое значение, которое приведет к исключению в конструкторе Lion
        });
    }

    @Before
    public void setup() {
        try {
            Mockito.when(mockFeline.getFood(Mockito.anyString())).thenReturn(Arrays.asList("Корм для хищников"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDoesHaveMane() {
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}
