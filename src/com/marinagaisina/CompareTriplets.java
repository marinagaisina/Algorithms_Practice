package com.marinagaisina;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CompareTriplets {
//        The task is to find their comparison points by comparing a[0] with b[0], a[1] with b[1], and a[2] with b[2].
//
//        If a[i] > b[i], then Alice is awarded 1 point.
//                If a[i] < b[i], then Bob is awarded 1 point.
//                If a[i] = b[i], then neither person receives a point.
//                Comparison points is the total points a person earned.
//
//        Given a and b, determine their respective comparison points.
//------------------------Return--------------------------------------------------------------
//
//        int[2]: Alice's score is in the first position, and Bob's score is in the second.
//----------------------Input Format-----------------------------------------------------------
//
//        The first line contains 3 space-separated integers, a[0], a[1], and a[2], the respective values in triplet a.
//                The second line contains 3 space-separated integers, b[0], b[1], and b[2], the respective values in triplet b.
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = CompareTriplets.compareTriplets(a, b);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
//----------------------Compare Triplets-----------------------------------------------------------------------
    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<>();
        int aScore = 0;
        int bScore = 0;
        for (int i=0; i<3; i++) {
            if (a.get(i) > b.get(i)) {
                aScore++;
            } else if (a.get(i) < b.get(i)) {
                bScore++;
            }
        }
        result.add(aScore);
        result.add(bScore);
        return result;
    }
//-------------------------------------------------------------------------------------------------------------
}