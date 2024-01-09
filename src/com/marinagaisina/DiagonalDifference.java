package com.marinagaisina;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class DiagonalDifference {
//-----------------Diagonal Difference------------------------------------------------------------------------
// compare two diagonals of a matrix (two dimensional array list)

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        System.out.println(arr.toString());
        bufferedWriter.write(String.valueOf(DiagonalDifference.diagonalDifference(arr)));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

//-------------------------------------------------------------------------------------------------------------
    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */
    public static int diagonalDifference(List<List<Integer>> arr) {
        int primaryDiagonal = 0;
        int secondaryDiagonal = 0;
        for (int i=0; i<arr.size(); i++) {
            for (int j=0; j<arr.get(i).size(); j++) {
                if (i==j) {
                    primaryDiagonal += arr.get(i).get(j);

                }
                if (j==arr.get(i).size()-1-i) {
                    //System.out.println(arr.get(i).get(j));
                    secondaryDiagonal += arr.get(i).get(j);

                }
            }
        }
        System.out.println("Primary:\n"+primaryDiagonal);
        System.out.println("Secondary:\n"+secondaryDiagonal);
        return Math.abs(primaryDiagonal-secondaryDiagonal);
    }
}
