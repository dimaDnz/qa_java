import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class TestLionParametrized {
    private final String sex;
    private final boolean haveMane;

    public TestLionParametrized(String sex, boolean haveMane){
        this.sex = sex;
        this.haveMane = haveMane;
    }

    @Parameterized.Parameters
    public static Object[][] doesHaveMane() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(sex, feline);
        Assert.assertEquals("Не соответствует ожидаемому результату!", haveMane, lion.doesHaveMane());
    }
}