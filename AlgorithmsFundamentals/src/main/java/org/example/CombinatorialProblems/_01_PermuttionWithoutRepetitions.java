package org.example.CombinatorialProblems;

import java.util.Scanner;

public class _01_PermuttionWithoutRepetitions {

    public static String[] elements;
    public static String[] permute;
    public static boolean[] used;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split("\\s+");
        permute = new String[elements.length];
        used = new boolean[elements.length];

        permute(0);

    }

    private static void permute(int index) {
        if (index == elements.length) {
            print();
            return;
        }
        for (int i = 0; i < elements.length; i++) {
            if (!used[i]) {
                used[i] = true;
                permute[index] = elements[i];
                permute(index + 1);
                used[i] = false;
            }
        }
    }

    private static void print() {
        System.out.println(String.join(" ", permute));
    }
}
