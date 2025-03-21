package org.example.RecursionLab;

import java.util.Scanner;

public class _06_8QueensPuzzle {

    static final int N = 8; // The size of the chessboard (8x8)
    static int[][] board = new int[N][N]; // 2D matrix representing the chessboard

    public static void main(String[] args) {
        solve(0); // Start solving from row 0
    }

    // Function to solve the problem using recursion
    public static boolean solve(int row) {
        if (row == N) {
            printBoard(); // If all queens are placed, print the board
            return true;
        }

        boolean result = false;
        // Try placing a queen in all columns of the current row
        for (int col = 0; col < N; col++) {
            // Check if placing queen at (row, col) is safe
            if (isSafe(row, col)) {
                board[row][col] = 1; // Place the queen
                result = solve(row + 1) || result; // Recur to place queens in the next row
                board[row][col] = 0; // Backtrack: Remove the queen
            }
        }
        return result;
    }

    // Function to check if it's safe to place a queen at (row, col)
    public static boolean isSafe(int row, int col) {
        // Check the previous rows for conflicts
        for (int i = 0; i < row; i++) {
            // Check if there's a queen in the same column or diagonals
            if (board[i][col] == 1 || Math.abs(i - row) == Math.abs(board[i][0] - col)) {
                return false;
            }
        }
        return true;
    }

    // Function to print the chessboard
    public static void printBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    System.out.print("Q "); // Queen is placed here
                } else {
                    System.out.print(". "); // Empty space
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}

