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
        assertEquals(217, dotProductUtil.calculateDotProductUsingMapReduce(c, d));
    }

    @Test
    @DisplayName("TEST_2: Test for exception using Map Reduce")
    @Order(2)
    void calculateDotProductUsingMapReduce_2() {

        assertThrows(IllegalArgumentException.class, () -> dotProductUtil.calculateDotProductUsingMapReduce(a, c));
        assertThrows(IllegalArgumentException.class, () -> dotProductUtil.calculateDotProductUsingMapReduce(a, d));
    }
}