package com.michalkaluzinski.solutions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SolutionMinimumAbsoluteDifferenceInAnArray {

  // Complete the minimumAbsoluteDifference function below.
  static int minimumAbsoluteDifference(int[] arr) {

    int minAbs = Integer.MAX_VALUE;

    List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
    Collections.sort(list);
    
    for(int i=0; i< list.size()-1; i++) {
      int currentAbs = Math.abs(list.get(i) - list.get(i+1));
      if(currentAbs < minAbs) {
        minAbs = currentAbs;
      }
    }
    return minAbs;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] arr = new int[n];

    String[] arrItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int arrItem = Integer.parseInt(arrItems[i]);
      arr[i] = arrItem;
    }

    int result = minimumAbsoluteDifference(arr);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
