package com.michalkaluzinski;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SolutionCountTriplets {

  // Complete the countTriplets function below.
  static long countTriplets(List<Long> arr, long r) {

    long triplets = 0;

    HashMap<Long, LinkedList<Integer>> powIndexesMap = new HashMap<>();
    for (int i = 0; i < arr.size(); i++) {
      Long number = arr.get(i);
      Long pow = Long.valueOf((long) logb(number, r));
      LinkedList<Integer> indexes;
      if (!powIndexesMap.containsKey(pow)) {
        indexes = new LinkedList<>();
      } else {
        indexes = powIndexesMap.get(pow);
      }
      indexes.add(i);
      powIndexesMap.put(pow, indexes);
    }

    for (int i = 0; i < arr.size(); i++) {
      Long number = arr.get(i);
      Long pow = Long.valueOf((long) logb(number, r));
      Long pow2 = pow + 1;
      Long pow3 = pow2 + 1;

      if (!powIndexesMap.containsKey(pow2) || !powIndexesMap.containsKey(pow3)) {
        continue;
      }
      Integer countPow2 = powIndexesMap.get(pow2).size();
      Integer countPow3 = powIndexesMap.get(pow3).size();

      if (countPow2 > 0 && countPow3 > 0) {
        triplets += (countPow2 * countPow3);
      }
    }
    return triplets;
  }

  public static double logb(double a, double b) {
    return Math.log(a) / Math.log(b);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(nr[0]);

    long r = Long.parseLong(nr[1]);

    List<Long> arr =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(Collectors.toCollection(ArrayList::new));

    long ans = countTriplets(arr, r);

    bufferedWriter.write(String.valueOf(ans));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
