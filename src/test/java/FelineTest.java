import com.example.Animal;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.lenient;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @InjectMocks
    private Feline feline;

    @Mock
    private Animal animalMock;

    @Test
    public void testEatMeat() throws Exception {
        lenient().when(animalMock.getFood("Хищник")).thenReturn(List.of("Мясо", "Рыба"));

        List<String> result = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), result);
    }

    @Test
    public void testGetFamily() {
        String family = feline.getFamily();
        assertEquals("Кошачьи", family);
    }

    @Test
    public void testGetKittens() {
        int kittens = feline.getKittens();
        assertEquals(1, kittens);
    }

    @Test
    public void testGetKittensCount() {
        int kittens = feline.getKittens(3);
        assertEquals(3, kittens);
    }
}
