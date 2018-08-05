package pl.pwlctk.tasks.zoo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeddyBearTest {
    @Test
    void shouldReturnWeightEquals1() {
        // given
        Animal animal = new TeddyBear();
        // when
        int weight = animal.getWeight();
        // then
        assertEquals(1, weight);
    }

    @Test
    void shouldThrowIdontEatExceptionAfterEat() {
        // given
        Animal animal = new TeddyBear();
        // when

        // then
        assertThrows(IdontEatException.class, animal::eat);
    }

}