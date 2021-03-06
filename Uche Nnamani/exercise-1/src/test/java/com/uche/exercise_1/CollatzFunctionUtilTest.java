package com.uche.exercise_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CollatzFunctionUtilTest {
    CollatzFunctionUtil collatzFunctionUtil;

    @BeforeEach
    void setUp() {

        collatzFunctionUtil = new CollatzFunctionUtil();
    }

    @Test
    @DisplayName("TEST_1: Testing the Collatz function, for number 5, using head recursion.")
    @Order(1)
    void collatzSeriesUsingHeadRecursionTest_1() {
        Integer[] a = {5, 16, 8, 4, 2};
        List<Integer> expected = Arrays.asList(a);
        List<Integer> actual = collatzFunctionUtil.calculateCollatzSeriesUsingHeadRecursion(5);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    @DisplayName("TEST_2: Testing the Collatz function, for number 15, using head recursion.")
    @Order(2)
    void collatzSeriesUsingHeadRecursionTest_2() {
        Integer[] b = {15, 46, 23, 70, 35, 106, 53, 160, 80, 40, 20, 10, 5, 16, 8, 4, 2};
        List<Integer> expected = Arrays.asList(b);
        List<Integer> actual = collatzFunctionUtil.calculateCollatzSeriesUsingHeadRecursion(15);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    @DisplayName("TEST_3: Testing the Collatz function, for number 1, using head recursion.")
    @Order(3)
    void collatzSeriesUsingHeadRecursionTest_3() {
        assertThrows(IllegalArgumentException.class,
                () -> collatzFunctionUtil.calculateCollatzSeriesUsingHeadRecursion(1));
    }

    @Test
    @DisplayName("TEST_4: Testing the Collatz function, for number 5, using tail recursion.")
    @Order(4)
    void collatzSeriesUsingTailRecursionTest_1() {
        Integer[] a = {5, 16, 8, 4, 2};
        List<Integer> expected = Arrays.asList(a);
        List<Integer> actual = collatzFunctionUtil.calculateCollatzSeriesUsingTailRecursion(5);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    @DisplayName("TEST_5: Testing the Collatz function, for number 15, using tail recursion.")
    @Order(5)
    void collatzSeriesUsingTailRecursionTest_2() {
        Integer[] b = {15, 46, 23, 70, 35, 106, 53, 160, 80, 40, 20, 10, 5, 16, 8, 4, 2};
        List<Integer> expected = Arrays.asList(b);
        List<Integer> actual = collatzFunctionUtil.calculateCollatzSeriesUsingTailRecursion(15);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    @DisplayName("TEST_6: Testing the Collatz function, for number 1, using tail recursion.")
    @Order(6)
    void collatzSeriesUsingTailRecursionTest_3() {

        assertThrows(IllegalArgumentException.class,
                () -> collatzFunctionUtil.calculateCollatzSeriesUsingTailRecursion(-1));
    }
}