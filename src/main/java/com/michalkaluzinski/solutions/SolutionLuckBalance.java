package com.michalkaluzinski.solutions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SolutionLuckBalance {

  // Complete the luckBalance function below.
  static int luckBalance(int k, int[][] contests) {
    
    List<Integer> highContenst = new ArrayList<Integer>();
    int lowContenstSum = 0;
    int highContenstSum = 0;
    for(int i=0; i < contests.length; i++) {
      if(contests[i][1] == 1) {
        highContenst.add(contests[i][0]);
        highContenstSum += contests[i][0];
      }
      else {
        lowContenstSum += contests[i][0];
      }
    }
    Collections.sort(highContenst);
    
    int mustWin = 0;
    if(k < highContenst.size()) {
      int difference = highContenst.size() - k;
      for(int i=0; i<difference; i++) {
        mustWin += highContenst.get(i);
      }
    }
    mustWin *=2;
    return highContenstSum - mustWin + lowContenstSum;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] nk = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nk[0]);

    int k = Integer.parseInt(nk[1]);

    int[][] contests = new int[n][2];

    for (int i = 0; i < n; i++) {
      String[] contestsRowItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int j = 0; j < 2; j++) {
        int contestsItem = Integer.parseInt(contestsRowItems[j]);
        contests[i][j] = contestsItem;
      }
    }

    int result = luckBalance(k, contests);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
