package com.michalkaluzinski;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Michal
 * @url https://www.hackerrank.com/challenges/2d-array/
 */
public class Solution2DArrayDS {

  // Complete the hourglassSum function below.
  static int hourglassSum(int[][] arr) {

    int maxHourGlass = Integer.MIN_VALUE;
    
    for (int i = 1; i < 5; i++) {

      for (int j = 1; j < 5; j++) {
        int currentHourGlass = 0;

        currentHourGlass += arr[i - 1][j - 1];
        currentHourGlass += arr[i - 1][j];
        currentHourGlass += arr[i - 1][j + 1];
        currentHourGlass += arr[i][j];
        currentHourGlass += arr[i + 1][j - 1];
        currentHourGlass += arr[i + 1][j];
        currentHourGlass += arr[i + 1][j + 1];

        if (currentHourGlass > maxHourGlass) {
          maxHourGlass = currentHourGlass;
        }
      }
    }
    return maxHourGlass;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int[][] arr = new int[6][6];

    for (int i = 0; i < 6; i++) {
      String[] arrRowItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int j = 0; j < 6; j++) {
        int arrItem = Integer.parseInt(arrRowItems[j]);
        arr[i][j] = arrItem;
      }
    }

    int result = hourglassSum(arr);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
