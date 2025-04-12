package org.example.DynamicProgramming;

import java.util.*;

public class _02LongestZigZagSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = numbers.length;
        if (n == 0) {
            System.out.println(); // Handle empty input
            return;
        }

        int[][] dp = new int[n][2];
        int[][] prev = new int[n][2];

        // Initialize base cases
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1; // Greater
            dp[i][1] = 1; // Lesser
            prev[i][0] = -1;
            prev[i][1] = -1;
        }

        int maxLength = 1;
        int[] best = {0, 0}; // Stores the best end index and type (0=Greater, 1=Lesser)

        for (int currentIndex = 1; currentIndex < n; currentIndex++) {
            for (int prevIndex = 0; prevIndex < currentIndex; prevIndex++) {
                if (numbers[currentIndex] > numbers[prevIndex] && dp[currentIndex][0] < dp[prevIndex][1] + 1) {
                    dp[currentIndex][0] = dp[prevIndex][1] + 1;
                    prev[currentIndex][0] = prevIndex;
                }
                if (numbers[currentIndex] < numbers[prevIndex] && dp[currentIndex][1] < dp[prevIndex][0] + 1) {
                    dp[currentIndex][1] = dp[prevIndex][0] + 1;
                    prev[currentIndex][1] = prevIndex;
                }
            }

            // Update maxLength and track best end index
            if (maxLength < dp[currentIndex][0]) {
                maxLength = dp[currentIndex][0];
                best[0] = currentIndex;
                best[1] = 0;
            }
            if (maxLength < dp[currentIndex][1]) {
                maxLength = dp[currentIndex][1];
                best[0] = currentIndex;
                best[1] = 1;
            }
        }


        // Reconstruct the Zig-Zag sequence
        Deque<Integer> zigzagSequence = new ArrayDeque<>();
        int beginRow = best[0];
        int type = best[1];

        while (beginRow >= 0) {
            zigzagSequence.push(numbers[beginRow]);
            beginRow = prev[beginRow][type];
            type = (type == 0) ? 1 : 0;
        }

        // Print result in a single line
        while (!zigzagSequence.isEmpty()) {
            System.out.print(zigzagSequence.pop() + " ");
        }
    }
}


