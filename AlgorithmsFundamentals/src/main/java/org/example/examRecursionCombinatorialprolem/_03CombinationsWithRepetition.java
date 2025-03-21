package org.example.examRecursionCombinatorialprolem;

import java.util.Scanner;

public class _03CombinationsWithRepetition {

    public static int[] arr;
    public static int n;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        n = Integer.parseInt(scanner.nextLine());

        int k = Integer.parseInt(scanner.nextLine());

        arr = new int[k];

        combinations(0, 1);
    }

    private static void combinations(int index, int start) {
        if (index == arr.length) {
            printArr();
        } else {
            for (int i = start; i < n; i++) {
                arr[index] = i;
                combinations(index + 1, i);
            }
        }
    }

    private static void printArr() {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
