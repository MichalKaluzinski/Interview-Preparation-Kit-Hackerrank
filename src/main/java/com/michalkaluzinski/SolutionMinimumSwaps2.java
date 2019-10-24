package com.michalkaluzinski;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SolutionMinimumSwaps2 {

  // Complete the minimumSwaps function below.
  static int minimumSwaps(int[] arr) {

    int swaps = 0;

    for (int i = arr.length - 1; i >= 0;) {
      if (arr[i] - 1 == i) {
        i--;
      }
      else {
        int newIndex = arr[i]-1;
        int tmp = arr[newIndex];
        arr[newIndex] = arr[i];
        arr[i] = tmp;
        swaps++;
      }
    }

    return swaps;
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

    int res = minimumSwaps(arr);

    bufferedWriter.write(String.valueOf(res));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
