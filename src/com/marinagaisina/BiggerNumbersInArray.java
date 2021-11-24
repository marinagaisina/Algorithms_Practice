package com.marinagaisina;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BiggerNumbersInArray {
/*  Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each
    nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
    Return the answer in an array.
    Input Format
    Example 1 Input: nums = [8,1,2,2,3] Output: [4,0,1,1,3] Explanation: For nums[0]=8 there exist four smaller numbers
    than it (1, 2, 2 and 3). For nums[1]=1 does not exist any smaller number than it. For nums[2]=2 there exist one smaller
    number than it (1). For nums[3]=2 there exist one smaller number than it (1). For nums[4]=3 there exist three smaller
    numbers than it (1, 2 and 2).
    Example 2 Input: nums = [6,5,4,8] Output: [2,1,0,3]
    Example 3 Input: nums = [7,7,7,7] Output: [0,0,0,0]
    Constraints
        2 <= nums.length <= 500
        0 <= nums[i] <= 100
    Output Format
        A list, see examples
    Sample Input 0
            5
            8 1 2 2 3
    Sample Output 0
            4 0 1 1 3
-------------------------------------------------------------------------------------
     * Complete the 'count' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY numbers_arr as parameter.
     */

    public static List<Integer> count(List<Integer> numbers_arr) {
        /*
         * Write your code here
         * Function should return an array - answer
         */
        List<Integer> outputArr = new ArrayList<>();
        for (int i = 0; i < numbers_arr.size(); i++) {
            int counting = 0;
            for (int j = 0; j < numbers_arr.size(); j++) {
                if (i != j) {
                    if (numbers_arr.get(i) > numbers_arr.get(j)) {
                        counting++;
                    }
                }
            }
            outputArr.add(counting);
        }
        return outputArr;
    }
    public static void main(String[] args) throws IOException {
/*      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int amount_of_numbers = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> numbers = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = BiggerNumbersInArray.count(numbers);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }   */
        List<Integer> arr = new ArrayList<>();
        Collections.addAll(arr, 8, 1, 2, 2, 3);
        List<Integer> outputList = count(arr);
        System.out.println(outputList);
    }
}
