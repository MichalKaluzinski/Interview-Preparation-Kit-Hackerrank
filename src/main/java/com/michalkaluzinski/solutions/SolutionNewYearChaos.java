package com.michalkaluzinski.solutions;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author Michal
 * @url https://www.hackerrank.com/challenges/new-year-chaos/
 */
public class SolutionNewYearChaos {

  // Complete the minimumBribes function below.
  static void minimumBribes(int[] q) {

    boolean tooChaotic = false;
    int changes = 0;

    for (int i = 0; i < q.length; i++) {
      int personNumber = q[i];

      int possibleChanges =
          (int)
              IntStream.range(i + 1, q.length)
                  .mapToObj(k -> q[k])
                  .filter(a -> a < personNumber)
                  .count();
      if (possibleChanges > 2) {
        tooChaotic = true;
        break;
      } else {
        changes += possibleChanges;
      }
    }
    if (tooChaotic) {
      System.out.println("Too chaotic");
    } else {
      System.out.println(changes);
    }
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int t = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int tItr = 0; tItr < t; tItr++) {
      int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int[] q = new int[n];

      String[] qItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < n; i++) {
        int qItem = Integer.parseInt(qItems[i]);
        q[i] = qItem;
      }

      minimumBribes(q);
    }

    scanner.close();
  }
}
