package com.michalkaluzinski;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SolutionHashTablesRansomNote {

  // Complete the checkMagazine function below.
  static void checkMagazine(String[] magazine, String[] note) {
    Map<String, Integer> wordsInMagazineCount = new HashMap<>();
    Map<String, Integer> wordsInNoteCount = new HashMap<>();
    boolean isSuccess = true;
    for (int i = 0; i < magazine.length; i++) {
      if (!wordsInMagazineCount.containsKey(magazine[i])) {
        wordsInMagazineCount.put(magazine[i], 1);
      } else {
        wordsInMagazineCount.put(
            magazine[i], wordsInMagazineCount.get(magazine[i]) + 1);
      }
    }

    for (int i = 0; i < note.length; i++) {
      if (!wordsInNoteCount.containsKey(note[i])) {
        wordsInNoteCount.put(note[i], 1);
      } else {
        wordsInNoteCount.put(
            note[i], wordsInNoteCount.get(note[i]) + 1);
      }
    }

    for (Map.Entry<String, Integer> entry : wordsInNoteCount.entrySet()) {
      if (!wordsInMagazineCount.containsKey(entry.getKey())
          || wordsInMagazineCount.get(entry.getKey()) < entry.getValue()) {
        isSuccess = false;
        break;
      }
    }
    if (isSuccess) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    String[] mn = scanner.nextLine().split(" ");

    int m = Integer.parseInt(mn[0]);

    int n = Integer.parseInt(mn[1]);

    String[] magazine = new String[m];

    String[] magazineItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < m; i++) {
      String magazineItem = magazineItems[i];
      magazine[i] = magazineItem;
    }

    String[] note = new String[n];

    String[] noteItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      String noteItem = noteItems[i];
      note[i] = noteItem;
    }

    checkMagazine(magazine, note);

    scanner.close();
  }
}
