package PracticeAlgorithmsStrings;

// Practice > Algorithms > Strings
// Two Characters
// https://www.hackerrank.com/challenges/two-characters/problem

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class TwoCharacters {

  static int alternate(String s) {
    HashSet<Character> set = new HashSet<>();
    for (char c : s.toCharArray())
      set.add(c);

    if (set.size() < 2)
      return 0;

    StringBuilder characters = new StringBuilder();
    ArrayList<Character> chars = new ArrayList<>(set);
    ArrayList<String> results = new ArrayList<>();
    final int length = set.size();

    for (int x = 0; x < length - 1; x++) {
      final char first = chars.get(x);

      for (int y = x + 1; y < length; y++) {
        characters.setLength(0);
        final char second = chars.get(y);

        for (char c : s.toCharArray()) {
          if (first == c || second == c)
            characters.append(c);
        }

        boolean consecutive = false;
        for (int i = 0; i < characters.length() - 1; i++) {
          if (characters.charAt(i) == characters.charAt(i + 1)) {
            consecutive = true;
            break;
          }
        }

        if (!consecutive)
          results.add(characters.toString());
      }
    }

    if (results.isEmpty())
      return 0;

    results.sort(Comparator.comparing(String::length));
    return results.get(results.size() - 1).length();
  }

  public static void main(String[] args) {
    int result;

    result = alternate("abaacdabd");
    System.out.printf("result = %d, pass = %b\n", result, result == 4);

    result = alternate("beabeefeab");
    System.out.printf("result = %d, pass = %b\n", result, result == 5);

    result = alternate("asvkugfiugsalddlasguifgukvsa");
    System.out.printf("result = %d, pass = %b\n", result, result == 0);
  }
}