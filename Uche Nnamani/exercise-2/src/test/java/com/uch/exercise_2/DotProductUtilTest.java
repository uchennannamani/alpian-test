package com.uch.exercise_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DotProductUtilTest {

    @Test
    void calculateDotProductUsingForLoopTest_1() {
       DotProductUtil dotProductUtil = new DotProductUtil();
        int[] a = {1, 2, 3, 4};
        int[] b = {5, 6, 7, 8};

        assertEquals(70, dotProductUtil.calculateDotProductUsingForLoop(a, b));

    }

}