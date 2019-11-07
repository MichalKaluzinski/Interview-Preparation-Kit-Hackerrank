package com.michalkaluzinski.solutions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Michal
 * @url https://www.hackerrank.com/challenges/repeated-string/
 */
public class SolutionRepeatedString {

  // Complete the repeatedString function below.
  static long repeatedString(String s, long n) {

    if (n < s.length()) {
      return s.substring(0, (int) n).chars().filter(ch -> ch == 'a').count();
    } else if (n == s.length()) {
      return s.chars().filter(ch -> ch == 'a').count();
    } else {
      long aCountInString = s.chars().filter(ch -> ch == 'a').count();
      long extraChars =
          s.substring(0, (int) (n % s.length())).chars().filter(ch -> ch == 'a').count();

      return aCountInString * (long) Math.floor(n / (double) s.length()) + extraChars;
    }
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String s = scanner.nextLine();

    long n = scanner.nextLong();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    long result = repeatedString(s, n);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
