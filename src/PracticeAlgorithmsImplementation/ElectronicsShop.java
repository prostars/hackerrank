package PracticeAlgorithmsImplementation;

// Practice > Algorithms > Implementation
// Electronics Shop
// https://www.hackerrank.com/challenges/electronics-shop/problem

import java.util.Arrays;

public class ElectronicsShop {
  static int getMoneySpent(int[] keyboards, int[] drives, int b) {
    int maxTotal = -1;

    int[] sortedKeyboards = Arrays.stream(keyboards).filter(v -> v < b).sorted().toArray();
    int[] sortedDrives = Arrays.stream(drives).filter(v -> v < b).sorted().toArray();

    for (int i = sortedKeyboards.length - 1; i >= 0; i--) {
      int remainder = b - sortedKeyboards[i];
      int[] remainDrivers = Arrays.stream(sortedDrives).filter(v -> v <= remainder).sorted().toArray();

      for (int j = remainDrivers.length - 1; j >= 0; j--) {
        int total = sortedKeyboards[i] + remainDrivers[j];
        if (total <= b && total > maxTotal)
          maxTotal = total;
      }
    }

    return maxTotal;
  }

  public static void main(String[] args) {
    int result;

    result = getMoneySpent(new int[]{3, 1}, new int[]{5, 2, 8}, 10);
    System.out.printf("result = %d, pass = %b\n", result, result == 9);

    result = getMoneySpent(new int[]{3, 1}, new int[]{5}, 10);
    System.out.printf("result = %d, pass = %b\n", result, result == 8);

    result = getMoneySpent(new int[]{1}, new int[]{5, 2, 8}, 10);
    System.out.printf("result = %d, pass = %b\n", result, result == 9);

    result = getMoneySpent(new int[]{4}, new int[]{5}, 5);
    System.out.printf("result = %d, pass = %b\n", result, result == -1);

    result = getMoneySpent(new int[]{5, 9, 20}, new int[]{1, 4, 25}, 10);
    System.out.printf("result = %d, pass = %b\n", result, result == 9);
  }
}
