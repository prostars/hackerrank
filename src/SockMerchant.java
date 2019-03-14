import java.util.HashMap;

// Practice > Interview Preparation Kit > Warm-up Challenges
// Sock Merchant
// https://www.hackerrank.com/challenges/sock-merchant/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup

public class SockMerchant {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        HashMap<Integer, Integer> socks = new HashMap<>();

        for (int color : ar) {
            if (null == socks.get(color))
                socks.put(color, 1);
            else
                socks.put(color, socks.get(color) + 1);
        }

        int pairs = 0;
        for (Integer count : socks.values()) {
            if (count > 1) {
                if (0 == count % 2)
                    pairs += count / 2;
                else
                    pairs += (count - 1) / 2;
            }
        }

        return pairs;
    }

    public static void main(String[] args) {
        int result;
        result = sockMerchant(7, new int[]{1, 2, 1, 2, 1, 3, 2});
        System.out.printf("result = %d, pass = %b\n", result, result == 2);

        result = sockMerchant(9, new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20});
        System.out.printf("result = %d, pass = %b\n", result, result == 3);
    }
}
