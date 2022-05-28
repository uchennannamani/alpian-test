package com.uch.exercise_2;

import org.junit.jupiter.api.BeforeEach;
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
    void calculateDotProductUsingForLoopTest_1() {

        assertEquals(70, dotProductUtil.calculateDotProductUsingForLoop(a, b));
        assertEquals(217, dotProductUtil.calculateDotProductUsingForLoop(c, d));
    }

    @Test
    void calculateDotProductUsingForLoopTest_2() {

        assertThrows(IllegalArgumentException.class, () -> dotProductUtil.calculateDotProductUsingForLoop(a, c));
        assertThrows(IllegalArgumentException.class, () -> dotProductUtil.calculateDotProductUsingForLoop(a, d));
    }
}