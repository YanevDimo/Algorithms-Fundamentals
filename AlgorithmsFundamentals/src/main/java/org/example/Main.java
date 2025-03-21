package org.example;

public class Main {
    public static void main(String[] args) {


        //Brute force
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    for (int l = 0; l < 9; l++) {
                        for (int m = 0; m < 9; m++) {
                            System.out.printf("%d%d%d%d%d%n",i,j,k,l,m);
                        }
                    }
                }
            }
        }
    }
}