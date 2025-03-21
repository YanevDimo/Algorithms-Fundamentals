package org.example.RecursionLab;

import java.util.Scanner;

public class RecursiveFactorial_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        long result = calculateFactorial(num);
        System.out.println(result);
    }

    private static long calculateFactorial(int num) {
        if (num == 1) {
            return 1;
        }
        return num * calculateFactorial(num - 1);
    }
}
