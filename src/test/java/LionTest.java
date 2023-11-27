import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LionTest {

    private Feline felineMock;
    private Lion lion;

    @Before
    public void setUp() throws Exception {
        felineMock = mock(Feline.class);
        lion = new Lion("Самец", felineMock);
    }

    @Test
    public void testGetKittens() {
        when(felineMock.getKittens()).thenReturn(3);
        assertEquals(3, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Мясо", "Рыба");
        when(felineMock.getFood("Хищник")).thenReturn(expectedFood);

        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testInvalidSexException() {
        try {
            new Lion("Неверное значение", felineMock);
            fail("Expected Exception not thrown");
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Используйте допустимые значения пола животного - самец или самка"));
        }
    }

    @Test
    public void testConstructor() throws Exception {
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testConstructorFemale() throws Exception {
        Lion lionFemale = new Lion("Самка", felineMock);
        assertFalse(lionFemale.doesHaveMane());
    }
}
