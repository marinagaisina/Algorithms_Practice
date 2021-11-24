package com.marinagaisina;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Staircase {
//    Write a program that prints a staircase of size.Its base and height are both equal to n.
//    It is drawn using # symbols and spaces. The last line is not preceded by any spaces.
//
//    staircase has the following parameter(s):
//
//    int n: an integer
//
//    Input Format
//
//    A single integer, , denoting the size of the staircase.

    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        Staircase.staircase(n);
//
//        bufferedReader.close();

        Staircase.staircase(5);
    }
    public static void staircase(int n) {
        for(int i=n-1; i>=0; i--) {
            for (int j=n-1; j>=0; j--) {
                if (j<=n-i-1) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }


}
