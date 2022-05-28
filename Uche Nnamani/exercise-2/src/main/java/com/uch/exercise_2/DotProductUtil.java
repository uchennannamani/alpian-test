package com.uch.exercise_2;

public class DotProductUtil {

    public int calculateDotProductUsingForLoop(int[] a, int[] b) {
        int sum = 0;


            for (int i = 0; i < a.length; i++) {
                int tempProduct = a[i] * b[i];
                sum = sum + tempProduct;
            }

        System.out.println("The dotProduct = " + sum);      // remove at the end
        return sum;
    }

}
