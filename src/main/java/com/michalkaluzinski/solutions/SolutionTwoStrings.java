package com.michalkaluzinski.solutions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class SolutionTwoStrings {

  // Complete the twoStrings function below.
  static String twoStrings(String s1, String s2) {
    boolean result = false;
    HashSet<String> checkedCharacters = new HashSet<>();
    for (int i = 0; i < s1.length(); i++) {
      String characterToCheck = Character.toString(s1.charAt(i));
      if (checkedCharacters.contains(characterToCheck)) {
        continue;
      }
      checkedCharacters.add(characterToCheck);
      if (s2.contains(characterToCheck)) {
        result = true;
        break;
      }
    }
    return (result) ? "YES" : "NO";
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int qItr = 0; qItr < q; qItr++) {
      String s1 = scanner.nextLine();

      String s2 = scanner.nextLine();

      String result = twoStrings(s1, s2);

      bufferedWriter.write(result);
      bufferedWriter.newLine();
    }

    bufferedWriter.close();

    scanner.close();
  }
}
