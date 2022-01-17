package com.marinagaisina;
/*
Calculate the number of slices in which (maximum - minimum <= K)

An integer K and a non-empty array A consisting of N integers are given.
A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A.
A bounded slice is a slice in which the difference between the maximum and minimum values in the slice is less than or equal to K.
More precisely it is a slice, such that max(A[P], A[P + 1], ..., A[Q]) − min(A[P], A[P + 1], ..., A[Q]) ≤ K.
The goal is to calculate the number of bounded slices.
For example, consider K = 2 and array A such that:

    A[0] = 3
    A[1] = 5
    A[2] = 7
    A[3] = 6
    A[4] = 3
There are exactly nine bounded slices: (0, 0), (0, 1), (1, 1), (1, 2), (1, 3), (2, 2), (2, 3), (3, 3), (4, 4).

Write a function:
class Solution { public int solution(int K, int[] A); }
that, given an integer K and a non-empty array A of N integers, returns the number of bounded slices of array A.
If the number of bounded slices is greater than 1,000,000,000, the function should return 1,000,000,000.
For example, given:

    A[0] = 3
    A[1] = 5
    A[2] = 7
    A[3] = 6
    A[4] = 3
the function should return 9, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
K is an integer within the range [0..1,000,000,000];
each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
 */

import java.math.BigInteger;
import java.util.*;

public class CountBoundedSlices {
        public static int solution(int K, int[] A) {
            if ((A.length<1)||(A.length>100000)) {
                return 0;
            }
            if ((K<0)||(K>1000000000)) {
                return 0;
            }
            //if ((K == 0)&&(A.length==1)) return 1;
            if (A.length == 1) return 1;
            if (A.length ==2&&((A[0]-A[1])<=K)) return 2;
            else if (A.length ==2&&((A[0]-A[1])>K)) return 1;
            int countPair = A.length;
            for (int i=0; i<A.length;i++) {
                int max = A[i];
                int min = A[i];
                for (int j=i+1; j<A.length; j++) {
                    if (A[j]>max) {
                        max = A[j];
                    } else if (A[j] < min) {
                        min = A[j];
                    }
                    int diff = max-min;
                    if (diff>K) {
                        break;
                    } else {
                        countPair++;
                    }
                }
            }
            if (countPair>1000000000) return 1000000000;
            return countPair;
        }
//    public static int solution(int K, int[] A) {
//        List<int[]> arrList = new ArrayList<>();
//        int countPair = 0; //A.length;
//        if (K == 0) return countPair;
//        for (int i=0; i<A.length;i++) {
//            int max = A[i];
//            int min = A[i];
//            boolean stop =false;
//            for (int j = i; ; j++) {
//                if (A[j]>max) {
//                    max = A[j];
//                } else if (A[j] < min) {
//                    min = A[j];
//                }
//                int diff = max-min;
//                if (diff>K) {
//                    stop = true;
//                    break;
//                } else {
//                    countPair++;
//                    arrList.add(new int[]{i,j});
//                }
//            }
//
//        }
//        arrList.forEach(arr -> System.out.println(Arrays.toString(arr)));
//        return countPair;
//    }

    public static void main(String[] args) {
        int[] A = {10, 5,3};
        System.out.println(solution(2, A));
    }
    /*
    class Solution {
    public int solution(int K, int[] A) {
        if ((A.length<1)||(A.length>100000)) {
            return 0;
        }
        if ((K<0)||(K>1000000000)) {
            return 0;
        }
       if ((K == 0)&&(A.length==1)) return 1;
       if ((A.length == 1)&&(K>0)) return 0;
       int countPair = A.length;
       boolean stop = false;
       for (int i=0; i<A.length;i++) {
           int max = A[i];
           int min = A[i];
           int j=i+1;
            while(j<A.length||!stop) {
               if (A[j]>max) {
                   max = A[j];
               } else if (A[j] < min) {
                   min = A[j];
               }
               int diff = max-min;
               if (diff>K) {
                   stop = true;
               } else {
                   countPair++;
               }
               j++;
            }
       }
       if (countPair>1000000000) return 1000000000;
       return countPair;
   }

}
     */

//    public static int solution(int K, int[] A) {
//        if ((A.length <1)||(A.length>100000)) {
//            return 0;
//        }
//        if ((K<0)||(K>1000000000)) {
//            return 0;
//        }
//        BigInteger countPair = BigInteger.ZERO;
//        if ((K == 0)&&(A.length ==1)) return BigInteger.ONE.intValue();
//            //new BigInteger("1").intValue();
//        for (int i=0; i<A.length;i++) {
//            if ((A[i] < -1000000000)||(A[i])>1000000000) {
//                return 0;
//            }
//            BigInteger max = BigInteger.valueOf(A[i]);
//            BigInteger min = BigInteger.valueOf(A[i]);
//            //int min = A[i];
//            BigInteger bigK = BigInteger.valueOf(K);
//            for (int j=i; j<A.length;j++) {
//                BigInteger value = BigInteger.valueOf(A[j]);
//                if (value.compareTo(max)==1) {
//                    max = value;
//                } else if (value.compareTo(min) ==-1) {
//                    min = value;
//                }
//                BigInteger diff = max.subtract(min);
//                if (diff.compareTo(bigK) ==1) {
//                    break;
//                } else {
//                    countPair = countPair.add(BigInteger.ONE);
//                }
//            }
//
//        }
//        return countPair.intValue();
//    }
}

