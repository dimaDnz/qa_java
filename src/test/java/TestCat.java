import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestCat {
    @Mock
    Feline feline;

    @Test
    public void whoSayMeow() {
        Cat cat = new Cat(feline);
        Assert.assertEquals("Приличные кошки так не говорят, а ну сказала \"Мяу\"", "Мяу", cat.getSound());
    }

    @Test
    public void feastDeBeast() throws Exception {
        Cat cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }
}
