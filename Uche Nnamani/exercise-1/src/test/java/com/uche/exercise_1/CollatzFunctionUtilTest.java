package com.uche.exercise_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollatzFunctionUtilTest {
    CollatzFunctionUtil collatzFunctionUtil;

    @BeforeEach
    void setUp() {

        collatzFunctionUtil = new CollatzFunctionUtil();
    }

    @Test
    @DisplayName("TEST_1: Testing the Collatz function using recursion.")
    @Order(1)
    void collatzSeriesUsingRecursionTest_1() {
        Integer[] a = {5, 16, 8, 4, 2};
        List<Integer> expected = Arrays.asList(a);
        List<Integer> actual = collatzFunctionUtil.calculateCollatzSeriesUsingRecursion(5);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    @DisplayName("TEST_2: Testing the Collatz function using recursion.")
    @Order(2)
    void collatzSeriesUsingRecursionTest_2() {
        Integer[] b = {15, 46, 23, 70, 35, 106, 53, 160, 80, 40, 20, 10, 5, 16, 8, 4, 2};
        List<Integer> expected = Arrays.asList(b);
        List<Integer> actual = collatzFunctionUtil.calculateCollatzSeriesUsingRecursion(15);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    @DisplayName("TEST_3: Testing the Collatz function using recursion.")
    @Order(3)
    void collatzSeriesUsingRecursionTest_3() {
        Integer[] b = {};
        List<Integer> expected = Arrays.asList(b);
        List<Integer> actual = collatzFunctionUtil.calculateCollatzSeriesUsingRecursion(1);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }
}