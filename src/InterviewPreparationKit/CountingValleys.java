package InterviewPreparationKit;

// Practice > Interview Preparation Kit > Warm-up Challenges
// Counting Valleys
// https://www.hackerrank.com/challenges/counting-valleys/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup

public class CountingValleys {

    static int countingValleys(int n, String s) {
        int currentSeaLevel = 0;
        int previousSeaLevel = 0;
        int count = 0;

        for (char step : s.toCharArray()) {
            previousSeaLevel = currentSeaLevel;
            if ('U' == step)
                currentSeaLevel++;
            else
                currentSeaLevel--;
            if (previousSeaLevel < 0 && currentSeaLevel >= 0)
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int result;
        result = countingValleys(8, "UDDDUDUU");
        System.out.printf("result = %d, pass = %b\n", result, result == 1);

        result = countingValleys(8, "DDUUUUDD");
        System.out.printf("result = %d, pass = %b\n", result, result == 1);
    }
}
