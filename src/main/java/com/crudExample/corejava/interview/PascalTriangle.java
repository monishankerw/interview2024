package com.crudExample.corejava.interview;

public class PascalTriangle {
    public static void main(String[] args) {
        int rows = 5; // Number of rows to print
        int[][] triangle = new int[rows][rows];

        // Generate Pascal's Triangle
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    triangle[i][j] = 1; // The first and last elements are always 1
                } else {
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                }
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println(); // Move to the next row
        }
    }
}
