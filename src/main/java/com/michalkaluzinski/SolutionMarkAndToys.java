package com.michalkaluzinski;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SolutionMarkAndToys {

  // Complete the maximumToys function below.
  static int maximumToys(int[] prices, int k) {

    List<Integer> pricesList = Arrays.stream(prices).boxed().collect(Collectors.toList());

    Collections.sort(pricesList);

    int toys = 0;
    for (int i = 0; i < pricesList.size(); i++) {
      if (pricesList.get(i) >= k || pricesList.size() - 1 == i) {
        break;
      }
      int price = pricesList.get(i);
      int currentToys = 1;
      for (int j = i + 1; j < pricesList.size(); j++) {
        if (price + pricesList.get(j) <= k) {
          price += pricesList.get(j);
          currentToys++;
        } else {
          break;
        }
      }
      if (currentToys > toys) {
        toys = currentToys;
      }
    }
    return toys;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] nk = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nk[0]);

    int k = Integer.parseInt(nk[1]);

    int[] prices = new int[n];

    String[] pricesItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int pricesItem = Integer.parseInt(pricesItems[i]);
      prices[i] = pricesItem;
    }

    int result = maximumToys(prices, k);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
