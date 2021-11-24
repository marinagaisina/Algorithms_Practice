package com.marinagaisina;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.util.ListIterator;

public class BinaryString {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        String b = bufferedReader.readLine();
//
//        int result = BinaryString.beautifulBinaryString(b);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
//        List<Integer> binaryList = new LinkedList<>();
//        Collections.addAll(binaryList, 0,1,0,0,1,0,1,0,1,0);
        String b = "0100101010";
        String c = "001010110";
        String d = "01100";
        System.out.println(beautifulBinaryString(c));
    }

    public static int beautifulBinaryString(String b) {

        List<Integer> binaryList = new LinkedList<>();
        char[] charArr = b.toCharArray();
        int count = 0;
        for (char s: charArr) {
            binaryList.add(Integer.parseInt(String.valueOf(s)));
            System.out.println(s);
        }

        ListIterator<Integer> listIterator = binaryList.listIterator();
        int size = binaryList.size();
        while (listIterator.nextIndex() < size-1) {
            if (listIterator.next() == 0) {
                listIterator.nextIndex();
                if (listIterator.hasNext()&&(listIterator.next() == 1)) {
                    listIterator.nextIndex();
                    if (listIterator.hasNext()&&(listIterator.next() == 0)) {
                        listIterator.previous();
                        listIterator.set(1);
                        count++;
                        listIterator.next();
                    }
                }
                else {
                    listIterator.previous();
                }
            }
        }
        System.out.println(binaryList.toString());
        return count;
    }
}
