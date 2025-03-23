package org.example.examRecursionCombinatorialProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _08WordCruncher {

    public static List<String> words;
    public static String[] combined;
    public static String target;
    public static boolean[] used;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //  Convert to modifiable list
        words = new ArrayList<>(Arrays.asList(scanner.nextLine().split(", ")));

        target = scanner.nextLine();

        //  Remove words not present in the target
        words.removeIf(next -> !target.contains(next));

        combined = new String[words.size()];
        used = new boolean[words.size()];

        permutes(0);
    }

    private static void permutes(int index) {
        if (index == combined.length) {
            String actual = String.join("", combined);
            // Print only if the combination matches the target
            if (actual.equals(target)) {
                System.out.println(actual);
            }
        } else {
            for (int i = 0; i < words.size(); i++) {
                if (!used[i]) {
                    used[i] = true;
                    combined[index] = words.get(i);
                    permutes(index + 1);
                    used[i] = false;
                }
            }
        }
    }
}

//text, me, so, do, m, ran
//somerandomtext