package pl.pwlctk.tasks.zoo;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

class PolarBearTest {

    @Test
    void shouldReturnWeightEquals200() {
        // given
        Animal animal = new PolarBear();
        // when
        int weight = animal.getWeight();
        // then
        assertEquals(200, weight);
    }

    @Test
    void shouldBeAliveAfterBorn() {
        // given
        Animal animal = new PolarBear();
        // then
        assertTrue(animal.isAlive());
    }

    @Test
    void shouldBeAliveAfterEating() {
        // given
        Animal animal = new PolarBear();
        // when
        animal.eat();
        // then
        assertTrue(animal.isAlive());
    }


    @Test
    void shouldBeDeathIfEat11DaysBefore() {
        // given
        Animal animal = spy(new PolarBear()); //Spy tylko podmienia metody, ktore potrzebujemy, reszta pozostaje taka sama
        // when
        LocalDateTime mockLastEatTimeMinus11Days = LocalDateTime.now().minusDays(11);
        when(animal.getLastEatTime()).thenReturn(mockLastEatTimeMinus11Days); //tutaj dzieki spy zamieniamu wartosc zwracana now() na now() - 11 dni
        // then
        assertFalse(animal.isAlive());
    }

}