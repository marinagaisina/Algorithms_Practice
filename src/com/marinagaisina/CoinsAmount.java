//package com.marinagaisina;
//
//import javax.crypto.spec.PSource;
//import java.io.IOException;
//import java.lang.reflect.Array;
//import java.util.*;
//
//public class CoinsAmount {
//    /*
//        You are given coins of different denominations and a total amount of money amount. Write a function to compute the
//        fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any
//        combination of the coins, return -1.
//        You may assume that you have an infinite number of each kind of coin.
//        Input Format
//        Example 1 Input: coins = [1,2,5], amount = 11 Output: 3 Explanation: 11 = 5 + 5 + 1
//        Example 2 Input: coins = [2], amount = 3 Output: -1
//        Example 3 Input: coins = [1], amount = 0 Output: 0
//        Example 4 Input: coins = [1], amount = 1 Output: 1
//        Example 5 Input: coins = [1], amount = 2 Output: 2
//        Constraints:
//        1 <= coins.length <= 12
//        1 <= coins[i] <= 2^31 - 1
//        0 <= amount <= 10^4
//        Output Format
//        See above
//        Sample Input:
//        3
//        1 2 5
//        11
//        Sample Output:
//        3
//----------------------------------------------------------------------------------------
//     * Complete the 'count' function below.
//     *
//     * The function is expected to return an INTEGER.
//     * The function accepts following parameters:
//     *  1. INTEGER_ARRAY coins
//     *  2. INTEGER amount
//     */
//
//    public static int count(List<Integer> coins, int amount) {
//        /*
//         * Write your code here
//         * Function should return only one number - answer
//         */
////        Integer max = coins.get(0);
////        if (coins.size() != 1) {
////            for (Integer num : coins) {
////                if (num>max) {
////                    max = num;
////                }
////            }
////        }
//        Integer[] array = new Integer[coins.size()];
//        Arrays.sort(coins.toArray(array), Comparator.reverseOrder());
//        System.out.println(coins);
//
//        int count = 0;
//        int rest = amount % coins.get(0);
//        int intPart = amount / coins.get(0);
//        if (intPart != 0) {
//
//        }
//        while (intPart > 0) {
//
//            if (rest == 0) {
//                return count += intPart;
//            }
//        }
//        for (int i=0; i < coins.size(); i++) {
//            int rest = amount % coins.get(i);
//            int intPart = amount / coins.get(i);
//
//
////            count += amount/coins.get(i);
////            rest = amount%coins.get(i);
////            if (rest == 0) {
////                amount /= coins.get(i);
////                count += amount;
////            } else {
////                i++;
////            }
//
//
//
//        return count;
//    }
//
//    public static void main(String[] args) throws IOException {
//        /*
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int amount_of_coin_types = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> coins_arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//            .map(Integer::parseInt)
//            .collect(toList());
//
//        int coin_sum = Integer.parseInt(bufferedReader.readLine().trim());
//
//        int result = Result.count(coins_arr, coin_sum);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
//         */
//        List<Integer> numbers = new ArrayList<>();
//        Collections.addAll(numbers, 5,2,1);
//        Integer amount = 11;
//        System.out.println(count(numbers, amount));
//    }
//}
