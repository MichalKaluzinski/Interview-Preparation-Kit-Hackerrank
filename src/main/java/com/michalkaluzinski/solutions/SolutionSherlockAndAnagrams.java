package com.michalkaluzinski.solutions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SolutionSherlockAndAnagrams {

  // Complete the sherlockAndAnagrams function below.
  static int sherlockAndAnagrams(String s) {

    int pairs = 0;
    Map<String, Integer> subStringCount = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j < s.length(); j++) {
        String sortedString = sortString(s.substring(i, j + 1));
        if (subStringCount.containsKey(sortedString)) {
          pairs += subStringCount.get(sortedString);
          subStringCount.put(sortedString, subStringCount.get(sortedString) + 1);
        } else {
          subStringCount.put(sortedString, 1);
        }
      }
    }
    return pairs;
  }

  public static String sortString(String s) {
    char tempArray[] = s.toCharArray();
    Arrays.sort(tempArray);
    return new String(tempArray);
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int qItr = 0; qItr < q; qItr++) {
      String s = scanner.nextLine();

      int result = sherlockAndAnagrams(s);

      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();
    }

    bufferedWriter.close();

    scanner.close();
  }
}
