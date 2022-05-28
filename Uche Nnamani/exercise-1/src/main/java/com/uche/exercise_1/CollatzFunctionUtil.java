package com.uche.exercise_1;

import java.util.ArrayList;
import java.util.List;

public class CollatzFunctionUtil {


    public List<Integer> calculateCollatzSeriesUsingForLoop(int n) {

        List<Integer> collatzSeries = new ArrayList<>();

        while (n > 1) {
            collatzSeries.add(n);
            n = (n % 2 > 0) ? 3 * n + 1 : n / 2;
        }

        return collatzSeries;
    }

}
