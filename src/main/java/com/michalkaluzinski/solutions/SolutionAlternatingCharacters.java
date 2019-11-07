package com.michalkaluzinski.solutions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SolutionAlternatingCharacters {

  // Complete the alternatingCharacters function below.
  static int alternatingCharacters(String s) {

    if (s.length() == 1) {
      return 0;
    }

    char currentChar = s.charAt(0);
    char nextChar = findNext(currentChar);
    int deleted = 0;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) != nextChar) {
        deleted++;
      } else {
        nextChar = findNext(s.charAt(i));
      }
    }
    return deleted;
  }

  private static char findNext(char currentChar) {
    if (currentChar == 'A') {
      return 'B';
    } else {
      return 'A';
    }
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int qItr = 0; qItr < q; qItr++) {
      String s = scanner.nextLine();

      int result = alternatingCharacters(s);

      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();
    }

    bufferedWriter.close();

    scanner.close();
  }
}
