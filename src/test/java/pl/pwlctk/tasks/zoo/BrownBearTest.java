package pl.pwlctk.tasks.zoo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BrownBearTest {

    @Test
    void shouldReturnWeightEquals100() {
        // given
        Animal animal = new BrownBear();
        // when
        int weight = animal.getWeight();
        // then
        assertEquals(100, weight);
    }

}