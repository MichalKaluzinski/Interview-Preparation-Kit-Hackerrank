package com.michalkaluzinski;

import java.util.Scanner;

public class SortingBubbleSort {

  // Complete the countSwaps function below.
  static void countSwaps(int[] a) {
    boolean canSwap = true;
    int swaps = 0;
    int maxIndex = a.length - 1;
    int currentIndex = 0;
    while (canSwap) {
      if (maxIndex == currentIndex) {
        canSwap = false;
        break;
      }
      if (a[currentIndex] > a[currentIndex + 1]) {
        int tmp = a[currentIndex];
        a[currentIndex] = a[currentIndex + 1];
        a[currentIndex + 1] = tmp;
        currentIndex = 0;
        swaps++;
      } else {
        currentIndex++;
      }
    }
    System.out.println(String.format("Array is sorted in %d swaps.", swaps));
    System.out.println(String.format("First Element: %d", a[0]));
    System.out.println(String.format("Last Element: %d", a[maxIndex]));
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] a = new int[n];

    String[] aItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int aItem = Integer.parseInt(aItems[i]);
      a[i] = aItem;
    }

    countSwaps(a);

    scanner.close();
  }
}
