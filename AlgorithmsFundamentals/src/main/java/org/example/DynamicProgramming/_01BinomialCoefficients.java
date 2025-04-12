package org.example.DynamicProgramming;

import java.util.Scanner;

public class _01BinomialCoefficients {

    public static long[][] memory;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());

        memory = new long[n + 1][k + 1];


//      Second way IterativeApproach(Bottom-up)

//        for (int row = 0; row < n; row++) {
//            for (int col = 0; col <= Math.min(row, k); col++) {
//                if (col == 0 || col == row) {
//                    memory[row][col] = 1;
//                } else {
//                    memory[row][col] = memory[row - 1][col] + memory[row - 1][col - 1];
//                }
//            }
//        }
//        System.out.println(memory[n][k]);

        long binomial = calcBinomial(n, k);
        System.out.println(binomial);

    }

    private static long calcBinomial(int n, int k) {

        if (k == 0 || k == n) {
            return 1;
        }
        if (memory[n][k] != 0) {
            return memory[n][k];
        }
        return memory[n][k] = calcBinomial(n - 1, k) + calcBinomial(n - 1, k - 1);
    }
}


//  Optimized Iterative Approach (Using a 1D Array)

//        Scanner scanner = new Scanner(System.in);
//
//        int n = Integer.parseInt(scanner.nextLine());
//        int k = Integer.parseInt(scanner.nextLine());
//
//        long binom = computeBinomialOptimized(n, k);
//        System.out.println(binom);
//    }
//
//    private static long computeBinomialOptimized(int n, int k) {
//        if (k > n) return 0; // Edge case: invalid input
//
//        long[] dp = new long[k + 1];
//        dp[0] = 1; // Base case: C(n,0) = 1 for all n
//
//        for (int i = 1; i <= n; i++) {
//            for (int j = Math.min(i, k); j > 0; j--) { // Update from right to left
//                dp[j] += dp[j - 1];
//            }
//        }
//
//        return dp[k];
//    }
//}

