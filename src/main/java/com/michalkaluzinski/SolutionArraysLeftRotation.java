package com.michalkaluzinski;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Michal
 * @url https://www.hackerrank.com/challenges/ctci-array-left-rotation/
 */
public class SolutionArraysLeftRotation {

  // Complete the rotLeft function below.
  static int[] rotLeft(int[] a, int d) {
    int[] rotated = new int[a.length];

    if (a.length == d) {
      System.arraycopy(a, 0, rotated, 0, a.length);
    } else {
      if (a.length < d) {
        d = d % a.length;
      }
      System.arraycopy(Arrays.copyOfRange(a, 0, d), 0, rotated, a.length - d, d);
      System.arraycopy(Arrays.copyOfRange(a, d, a.length), 0, rotated, 0, a.length - d);
    }

    return rotated;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] nd = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nd[0]);

    int d = Integer.parseInt(nd[1]);

    int[] a = new int[n];

    String[] aItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int aItem = Integer.parseInt(aItems[i]);
      a[i] = aItem;
    }

    int[] result = rotLeft(a, d);

    for (int i = 0; i < result.length; i++) {
      bufferedWriter.write(String.valueOf(result[i]));

      if (i != result.length - 1) {
        bufferedWriter.write(" ");
      }
    }

    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
