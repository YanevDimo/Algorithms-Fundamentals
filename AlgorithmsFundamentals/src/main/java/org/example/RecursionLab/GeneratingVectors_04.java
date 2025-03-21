package org.example.RecursionLab;

import java.util.Scanner;

public class GeneratingVectors_04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] memory = new int[n];

        fillVector(memory, 0);
    }

    private static void fillVector(int[] memory, int index) {
        if (index >= memory.length) {
            print(memory);
            return;
        }
        for (int i = 0; i <= 1; i++) {
            memory[index] = i;
            fillVector(memory, index + 1);
        }
    }

    private static void print(int[] memory) {

        for (int j : memory) {
            System.out.print(j);
        }
        System.out.println();
    }

}
