package com.uche.exercise_1;

import java.util.ArrayList;
import java.util.List;

public class CollatzFunctionUtil {

    private final List<Integer> collatzSeries = new ArrayList<>();

    public List<Integer> calculateCollatzSeriesUsingRecursion(int n) {

        if (n > 1) {
            collatzSeries.add(n);
            calculateCollatzSeriesUsingRecursion((n % 2 > 0) ? 3 * n + 1 : n / 2);
        }

        return collatzSeries;
    }
}
