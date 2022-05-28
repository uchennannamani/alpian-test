package com.uche.exercise_1;

import java.util.ArrayList;
import java.util.List;

public class CollatzFunctionUtil {
    private final List<Integer> collatzSeries = new ArrayList<>();

    public List<Integer> calculateCollatzSeriesUsingHeadRecursion(int n) {

        if (n > 1) {
            collatzSeries.add(n);
            calculateCollatzSeriesUsingHeadRecursion((n % 2 > 0) ? 3 * n + 1 : n / 2);
        }
        return collatzSeries;
    }

    public List<Integer> calculateCollatzSeriesUsingTailRecursion(int n) {

        if (n <= 1) {
            return collatzSeries;
        }
        collatzSeries.add(n);
        return calculateCollatzSeriesUsingTailRecursion((n % 2 > 0) ? 3 * n + 1 : n / 2);
    }
}
