package com.uch.exercise_2;

import java.util.stream.IntStream;

public class DotProductUtil {

    public int calculateDotProductUsingMapReduce(int[] a, int[] b) {

        if (a.length != b.length) {

            throw new IllegalArgumentException("The lengths of both arrays must be equal");
        } else {

            return IntStream.range(0, a.length)
                    .parallel()
                    .map(i -> a[i] * b[i])
                    .reduce(0, Integer::sum);
        }
    }
}
