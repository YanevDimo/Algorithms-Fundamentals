package org.example.RecursionLab;

import java.util.Scanner;

public class RecursiveDrawing_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        drawFigure(n);

    }

    private static void drawFigure(int n) {
        if (n == 0) {
            return;
        }
//      pre-action
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();
//        call recursion
        drawFigure(n - 1);
//      post-action
        for (int i = 0; i < n; i++) {
            System.out.print("#");
        }
        System.out.println();
    }
}
