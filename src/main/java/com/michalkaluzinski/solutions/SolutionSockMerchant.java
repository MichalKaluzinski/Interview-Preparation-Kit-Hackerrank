package com.michalkaluzinski.solutions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * @author Michal
 * https://www.hackerrank.com/challenges/sock-merchant/
 */
public class SolutionSockMerchant {

  // Complete the sockMerchant function below.
  static int sockMerchant(int n, int[] ar) {
    Set<Integer> colors = new HashSet<>();
    int pairs = 0;
    for (int i = 0; i < ar.length; i++) {
      if (!colors.contains(ar[i])) {
        colors.add(ar[i]);
      } else {
        pairs++;
        colors.remove(ar[i]);
      }
    }
    return pairs;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] ar = new int[n];

    String[] arItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int arItem = Integer.parseInt(arItems[i]);
      ar[i] = arItem;
    }

    int result = sockMerchant(n, ar);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
