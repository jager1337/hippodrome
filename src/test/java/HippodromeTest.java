import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


class HippodromeTest {

    Hippodrome hippodrome;


    @Test
    public void constructorNotNullTest(){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new Hippodrome(null));
    }

    @Test
    public void constructorNotNullExceptionStringTest() {
        try {
            hippodrome = new Hippodrome(null);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Horses cannot be null.", e.getMessage());
        }
    }

    @Test
    public void constructorEmptyListTest(){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new Hippodrome(List.of()));
    }

    @Test
    public void constructorEmptyListExceptionStringTest() {
        try {
            hippodrome = new Hippodrome(List.of());
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Horses cannot be empty.", e.getMessage());
        }
    }

    @Test
    public void getHorses() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            horses.add(new Horse("Horse "+ i,i));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        Assertions.assertEquals(horses, hippodrome.getHorses());
    }

    @Test
    public void moveTest() {
        List<Horse> horseMocks = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Horse horseMock = mock(Horse.class, RETURNS_DEEP_STUBS);
            horseMocks.add(horseMock);
        }
        Hippodrome hippodrome = new Hippodrome(horseMocks);

        hippodrome.move();

        for (Horse horseMock : horseMocks) {
            verify(horseMock).move();
        }
    }


    @Test
    public void getWinnerTest() {
        Horse horse1 = new Horse("Horse1", 1, 1);
        Horse horse2 = new Horse("Horse2", 2, 2);
        Horse horse3 = new Horse("Horse3", 3, 3);
        Horse horse4 = new Horse("Horse4", 4, 4);
        Hippodrome hippodrome = new Hippodrome(List.of(horse1, horse2, horse3, horse4));

        Assertions.assertSame(horse4, hippodrome.getWinner());
    }
}