package com.michalkaluzinski.solutions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Michal
 * @url https://www.hackerrank.com/challenges/counting-valleys/
 */
public class SolutionCountingValleys {

  // Complete the countingValleys function below.
  static int countingValleys(int n, String s) {

    int currentPossition = 0;
    int vallyes = 0;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'U') {
        if (currentPossition == -1) {
          vallyes++;
        }
        currentPossition++;
      } else {
        currentPossition--;
      }
    }
    return vallyes;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    String s = scanner.nextLine();

    int result = countingValleys(n, s);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
