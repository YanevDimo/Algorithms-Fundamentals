package org.example.RecursionLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PathsInLabyrinth_07 {

    static List<Character> path = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] labyrint = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            labyrint[row] = scanner.nextLine().toCharArray();
        }

        findPath(labyrint, 0, 0, ' ');
    }

    private static void findPath(char[][] labyrint, int row, int col, char direction) {
        if (!isInBounds(labyrint, row, col)
                || labyrint[row][col] == 'V'
                || labyrint[row][col] == '*') {
            return;
        }
        path.add(direction);

        if (labyrint[row][col] == 'e') {
            printPath();path.remove(path.size()-1)
;            return;
        }

        labyrint[row][col] = 'V';

        findPath(labyrint, row - 1, col, 'U');
        findPath(labyrint, row + 1, col, 'D');
        findPath(labyrint, row, col - 1, 'L');
        findPath(labyrint, row, col + 1, 'R');

        labyrint[row][col] = '-';
        path.remove(path.size() - 1);
    }

    private static void printPath() {

        for (int i = 1; i < path.size(); i++) {
            System.out.print(path.get(i));
        }
        System.out.println();
    }

    private static boolean isInBounds(char[][] labyrinth, int row, int col) {
        return row < labyrinth.length && row >= 0 && col < labyrinth[row].length && col >= 0;
    }
}
