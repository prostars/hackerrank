package PracticeAlgorithmsGreedy;

// Practice > Algorithms > Greedy
// Grid Challenge
// https://www.hackerrank.com/challenges/grid-challenge/problem

import java.util.ArrayList;

public class GridChallenge {

  static String gridChallenge(String[] grid) {
    ArrayList<String> sortedGrid = new ArrayList<>();

    for (String row : grid) {
      sortedGrid.add(row.chars()
        .sorted()
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString());
    }

    for (int col = 0; col < grid[0].length(); col++) {
      for (int row = 0; row < grid.length - 1; row++) {
        char prev = sortedGrid.get(row).charAt(col);
        char current = sortedGrid.get(row + 1).charAt(col);
        if (prev > current)
          return "NO";
      }
    }

    return "YES";
  }

  public static void main(String[] args) {
    String result;

    result = gridChallenge(new String[]{"ebacd", "fghij", "olmkn", "trpqs", "xywuv"});
    System.out.printf("result = %s, pass = %b\n", result, result.equals("YES"));

    result = gridChallenge(new String[]{"abc", "lmp", "qrt"});
    System.out.printf("result = %s, pass = %b\n", result, result.equals("YES"));

    result = gridChallenge(new String[]{"mpxz", "abcd", "wlmf"});
    System.out.printf("result = %s, pass = %b\n", result, result.equals("YES"));

    result = gridChallenge(new String[]{"abc", "hjk", "mpq", "rtv"});
    System.out.printf("result = %s, pass = %b\n", result, result.equals("YES"));
  }
}
