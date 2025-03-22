package org.example.examRecursionCombinatorialprolem;

import java.util.*;

public class _07Cinema {

    public static String[] seats;
    public static String[] combinations;
    public static boolean[] used;
    public static List<String> people;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Четем всички хора
        List<String> allPeople = Arrays.stream(scanner.nextLine().split(", ")).toList();

        // Създаваме масив за местата според общия брой хора
        seats = new String[allPeople.size()];

        // Работен списък с хората, които ще разместваме
        people = new ArrayList<>(allPeople);

        // Четем фиксирани места
        String line = scanner.nextLine();
        while (!line.equals("generate")) {
            String[] tokens = line.split(" - ");
            String name = tokens[0];
            int position = Integer.parseInt(tokens[1]) - 1;

            // Проверка за границите на позицията
            if (position < 0 || position >= seats.length) {
                System.out.println("Invalid position for " + name);
                return;
            }

            // Проверка дали мястото вече е заето
            if (seats[position] != null) {
                System.out.println("Seat " + (position + 1) + " is already taken!");
                return;
            }

            seats[position] = name;
            people.remove(name);

            line = scanner.nextLine();
        }

        combinations = new String[people.size()];
        used = new boolean[people.size()];

        permute(0);
    }

    private static void permute(int index) {
        if (index == combinations.length) {
            print();
        } else {
            for (int i = 0; i < people.size(); i++) {
                if (!used[i]) {
                    used[i] = true;
                    combinations[index] = people.get(i);
                    permute(index + 1);
                    used[i] = false;
                }
            }
        }
    }

    private static void print() {
        int index = 0;
        StringBuilder result = new StringBuilder();

        for (String seat : seats) {
            if (seat != null) {
                result.append(seat).append(" ");
            } else {
                result.append(combinations[index++]).append(" ");
            }
        }

        System.out.println(result.toString().trim());
    }
}
