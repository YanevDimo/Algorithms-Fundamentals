package org.example.examRecursionCombinatorialprolem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class _01ReverseArray {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] elements = reader.readLine().split("\\s+");

        printReversedArray(elements,elements.length -1);

    }

    private static void printReversedArray(String[] elements, int index) {
        if (index < 0) {
            return;
        }
        System.out.print(elements[index]+' ');
        printReversedArray(elements,index -1);
    }
}
