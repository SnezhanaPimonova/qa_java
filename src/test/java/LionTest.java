import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Spy
    Feline feline = new Feline();


    @Test
    public void getKittensLionReturnOne() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        int expectedKittens = 1;
        int actualKittens = lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(expectedKittens);
        assertEquals(expectedKittens, actualKittens);
    }

    @Test
    public void doesHaveManeReturnFalse() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        boolean actualResult = lion.doesHaveMane();
        assertFalse(actualResult);
    }


    @Test
    public void doesHaveManeReturnTrue() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        boolean actualResult = lion.doesHaveMane();
        assertTrue(actualResult);
    }

    @Test
    public void checkUnknownSex() {
        try {
            Lion lion = new Lion(feline, "Unknown");
        } catch (Exception thrown) {
            String expectedResult = "Используйте допустимые значения пола животного - самец или самка";
            assertEquals(expectedResult, thrown.getMessage());
        }
    }

    @Test
    public void getFoodListLion() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);
    }

}






