package com.uche.exercise_1;

import java.util.ArrayList;
import java.util.List;

public class CollatzFunctionUtil {
    private final List<Integer> collatzSeries = new ArrayList<>();

    public List<Integer> calculateCollatzSeriesUsingHeadRecursion(int n) {
        if (n <= 1) {
            throw new IllegalArgumentException("Provide a number greater than 1");
        } else {
            return utilForHeadRecursion(n);
        }
    }

    public List<Integer> calculateCollatzSeriesUsingTailRecursion(int n) {
        if (n <= 1) {
            throw new IllegalArgumentException("Provide a number greater than 1");
        } else {
            return utilForTailRecursion(n);
        }
    }


    private List<Integer> utilForHeadRecursion(int n) {
        if (n > 1) {
            collatzSeries.add(n);
            utilForHeadRecursion((n % 2 > 0) ? 3 * n + 1 : n / 2);
        }
        return collatzSeries;
    }

    private List<Integer> utilForTailRecursion(int n) {
        if (n <= 1) {
            return collatzSeries;
        }
        collatzSeries.add(n);
        return utilForTailRecursion((n % 2 > 0) ? 3 * n + 1 : n / 2);
    }
}
