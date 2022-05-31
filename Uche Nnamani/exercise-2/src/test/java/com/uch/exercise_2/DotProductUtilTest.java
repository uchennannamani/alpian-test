package com.uch.exercise_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DotProductUtilTest {
    DotProductUtil dotProductUtil;

    @BeforeEach
    void setUp() {

        dotProductUtil = new DotProductUtil();
    }

    int[] a = {1, 2, 3, 4};
    int[] b = {5, 6, 7, 8};
    int[] c = {1, 2, 3, 4, 5, 6};
    int[] d = {7, 8, 9, 10, 11, 12};

    @Test
    @DisplayName("TEST_1: Test for 'happy path' using Map Reduce")
    @Order(1)
    void calculateDotProductUsingMapReduce_1() {

        assertEquals(70, dotProductUtil.calculateDotProductUsingMapReduce(a, b));
    }

    @Test
    @DisplayName("TEST_2: Test for 'happy path' using Map Reduce")
    @Order(2)
    void calculateDotProductUsingMapReduce_2() {

        assertEquals(217, dotProductUtil.calculateDotProductUsingMapReduce(c, d));
    }

    @Test
    @DisplayName("TEST_3: Test for exception using Map Reduce")
    @Order(3)
    void calculateDotProductUsingMapReduce_3() {

        assertThrows(IllegalArgumentException.class, () -> dotProductUtil.calculateDotProductUsingMapReduce(a, c));
    }

    @Test
    @DisplayName("TEST_4: Test for exception using Map Reduce")
    @Order(4)
    void calculateDotProductUsingMapReduce_4() {

        assertThrows(IllegalArgumentException.class, () -> dotProductUtil.calculateDotProductUsingMapReduce(a, d));
    }
}