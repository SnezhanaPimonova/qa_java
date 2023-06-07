import com.example.Feline;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Test
    public void eatMeatReturnFood() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        Assert.assertEquals(expectedFood, actualFood);
    }

    @Test
    public void getFamilyReturnFeline() {
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        Assert.assertEquals(expectedFamily, actualFamily);
    }

    @Test
    public void getKittensFelineReturnOne() {
        Feline feline = new Feline();
        int expectedKittens = 1;
        int actualKittens = feline.getKittens();
        Assert.assertEquals(expectedKittens, actualKittens);
    }

    @Test
    public void getKittensFelineReturnKittensCount() {
        Feline feline = new Feline();
        int expectedKittens = 3;
        int actualKittens = feline.getKittens(3);
        Assert.assertEquals(expectedKittens, actualKittens);
    }

}
