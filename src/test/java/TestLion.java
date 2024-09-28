import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class TestLion {

    @Test
    public void testLionConstructor_Samets() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testLionConstructor_Samka() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void testLionConstructor_InvalidSex() {
        Feline feline = Mockito.mock(Feline.class);
        assertThrows(Exception.class, () -> new Lion("Invalid", feline));
    }

    @Test
    public void testGetFood() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        List<String> food = List.of("Мясо");
        when(feline.getFood("Хищник")).thenReturn(food);
        Lion lion = new Lion("Самец", feline);
        assertEquals(food, lion.getFood());
    }

    @Test
    public void testGetKittens() throws Exception {
        Feline feline = Mockito.spy(Feline.class);
        Lion lion = new Lion("Самец", feline);
        assertEquals(1, lion.getKittens());
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);

    }
}
