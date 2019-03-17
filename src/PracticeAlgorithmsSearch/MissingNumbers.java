package PracticeAlgorithmsSearch;

// Practice > Algorithms > Search
// Missing Numbers
// https://www.hackerrank.com/challenges/missing-numbers/problem

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MissingNumbers {
  static int[] missingNumbers(int[] arr, int[] brr) {
    HashMap<Integer, Integer> first = new HashMap<>();
    HashMap<Integer, Integer> second = new HashMap<>();

    for (int idx = 0; idx < brr.length; idx++) {
      if (idx < arr.length) {
        first.computeIfPresent(arr[idx], (k, v) -> v + 1);
        first.putIfAbsent(arr[idx], 1);
      }
      second.computeIfPresent(brr[idx], (k, v) -> v + 1);
      second.putIfAbsent(brr[idx], 1);
    }

    ArrayList<Integer> missingNumbers = new ArrayList<>();
    Iterator<Integer> iter = second.keySet().iterator();
    while (iter.hasNext()) {
      int number = iter.next();
      if (first.get(number) == null || !first.get(number).equals(second.get(number)))
        missingNumbers.add(number);
    }

    return missingNumbers.stream().mapToInt(Integer::valueOf).toArray();
  }

  public static void main(String[] args) {
    int[] result;

    result = missingNumbers(new int[]{203},
      new int[]{203, 204});
    System.out.printf("result length = %d, pass = %b\n", result.length, result.length == 1);

    result = missingNumbers(new int[]{203},
      new int[]{203});
    System.out.printf("result length = %d, pass = %b\n", result.length, result.length == 0);

    result = missingNumbers(new int[]{203, 204, 205, 206, 207, 208, 203, 204, 205, 206},
                            new int[]{203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204});
    System.out.printf("result length = %d, pass = %b\n", result.length, result.length == 3);
  }
}
