package pl.pwlctk.tasks.zoo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlackBearTest {

    @Test
    void shouldReturnWeightEquals50() {
        // given
        Animal animal = new BlackBear();
        // when
        int weight = animal.getWeight();
        // then
        assertEquals(50, weight);
    }

}