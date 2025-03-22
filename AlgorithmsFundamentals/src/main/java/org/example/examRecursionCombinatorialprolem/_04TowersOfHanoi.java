package org.example.examRecursionCombinatorialprolem;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Collections;

public class _04TowersOfHanoi {

    public static Deque<Integer> source = new ArrayDeque<>();
    public static Deque<Integer> spare = new ArrayDeque<>();
    public static Deque<Integer> destination = new ArrayDeque<>();
    public static int steps = 0;
    public static StringBuilder out = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int disc = Integer.parseInt(scanner.nextLine());

        for (int i = disc; i >= 1; i--) {
            source.push(i);
        }

        printRods(); // Initial state
        solve(disc, source, destination, spare);

        // Print final output
        System.out.println(out);
    }

    private static void solve(int disc, Deque<Integer> source, Deque<Integer> destination, Deque<Integer> spare) {
        if (disc == 1) {
            destination.push(source.pop());
            steps++;
            out.append(String.format("Step #%d: Moved disk%n", steps));
            printRods();
        } else {
            solve(disc - 1, source, spare, destination);
            solve(1, source, destination, spare);
            solve(disc - 1, spare, destination, source);
        }
    }

    public static void printRods() {
        out.append("Source: ").append(formatRod(source)).append(System.lineSeparator());
        out.append("Destination: ").append(formatRod(destination)).append(System.lineSeparator());
        out.append("Spare: ").append(formatRod(spare)).append(System.lineSeparator());
        out.append(System.lineSeparator());
    }

    private static String formatRod(Deque<Integer> deque) {
        // To preserve bottom-to-top order
        List<Integer> list = new ArrayList<>(deque);
        Collections.reverse(list);
        return list.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }
}
