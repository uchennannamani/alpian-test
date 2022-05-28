package com.uche.exercise_1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollatzFunctionUtilTest {

    @Test
    void collatzSeriesUsingForLoop() {
        CollatzFunctionUtil collatzFunctionUtil = new CollatzFunctionUtil();

        Integer[] a = {5, 16, 8, 4, 2};
        List<Integer> expected = Arrays.asList(a);
        List<Integer> actual = collatzFunctionUtil.calculateCollatzSeriesUsingForLoop(5);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }
}