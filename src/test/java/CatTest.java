import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline felineMock;

    @InjectMocks
    private Cat cat;

    @Before
    public void setUp() throws Exception {
        when(felineMock.eatMeat()).thenReturn(Arrays.asList("Рыба", "Курица"));
    }

    @Test
    public void testGetSound() {
        String sound = cat.getSound();
        assertEquals("Мяу", sound);
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> food = cat.getFood();
        assertEquals(Arrays.asList("Рыба", "Курица"), food);
    }
}
