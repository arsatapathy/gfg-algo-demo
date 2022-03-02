package com.arsatapathy.dimanic;

public class MinimumOperation {

    public static void main(String... args) {
        System.out.println(minOperation(5));
        // Input = 5
        // Expected Output = 4
        // Explanation = 5 - 1 = 4, 4 / 2 = 2, 2 / 2 = 1, 1 - 1 = 0
    }

    public static int minOperation(int n)
    {
        if (n == 1) return 1;

        int count = 1;

        if (n % 2 == 0) {
            count += minOperation(n/2);
        } else {
            count += minOperation(n-1);
        }

        return count;
    }
}
