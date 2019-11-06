package com.michalkaluzinski;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SolutionStringsMakingAnagrams {

  // Complete the makeAnagram function below.
  static int makeAnagram(String a, String b) {

    int deleted = 0;
    Map<Character, Integer> lettersFromA = new HashMap<>();
    Map<Character, Integer> lettersFromB = new HashMap<>();

    for (int i = 0; i < a.length(); i++) {
      Character character = Character.valueOf(a.charAt(i));
      if (lettersFromA.containsKey(character)) {
        lettersFromA.put(character, lettersFromA.get(character) + 1);
      } else {
        lettersFromA.put(character, 1);
      }
    }

    for (int i = 0; i < b.length(); i++) {
      Character character = Character.valueOf(b.charAt(i));
      if (lettersFromB.containsKey(character)) {
        lettersFromB.put(character, lettersFromB.get(character) + 1);
      } else {
        lettersFromB.put(character, 1);
      }
    }

    for (Map.Entry<Character, Integer> entry : lettersFromA.entrySet()) {
      Integer letterInA = entry.getValue();
      Integer letterInB = 0;
      if (lettersFromB.containsKey(entry.getKey())) {
        letterInB = lettersFromB.get(entry.getKey());
      }

      if (letterInA > letterInB) {
        deleted += letterInA - letterInB;
      }
    }
    for (Map.Entry<Character, Integer> entry : lettersFromB.entrySet()) {
      Integer letterInB = entry.getValue();
      Integer letterInA = 0;
      if (lettersFromA.containsKey(entry.getKey())) {
        letterInA = lettersFromA.get(entry.getKey());
      }

      if (letterInB > letterInA) {
        deleted += letterInB - letterInA;
      }
    }
    return deleted;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String a = scanner.nextLine();

    String b = scanner.nextLine();

    int res = makeAnagram(a, b);

    bufferedWriter.write(String.valueOf(res));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
