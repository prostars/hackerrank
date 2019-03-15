package InterviewPreparationKit;

// Practice > Interview Preparation Kit > Warm-up Challenges
// Jumping on the Clouds
// https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup

public class JumpingOnTheClouds {

    static int jumpingOnClouds(int[] c) {
        int afterNext = 0;
        int steps = 0;
        int idx = 0;

        while (idx < c.length - 2) {
            afterNext = c[idx + 2];
            if (0 == afterNext)
                idx += 2;
            else
                idx++;
            steps++;
        }
        if (idx != c.length - 1)
            steps++;

        return steps;
    }

    public static void main(String[] args) {
        int result;

        result = jumpingOnClouds(new int[]{0, 1, 0, 0, 0, 1, 0});
        System.out.printf("result = %d, pass = %b\n", result, result == 3);

        result = jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 0});
        System.out.printf("result = %d, pass = %b\n", result, result == 4);

        result = jumpingOnClouds(new int[]{0, 0, 0, 0, 1, 0});
        System.out.printf("result = %d, pass = %b\n", result, result == 3);

        result = jumpingOnClouds(new int[]{0, 0, 0, 1, 0, 0});
        System.out.printf("result = %d, pass = %b\n", result, result == 3);
    }
}
