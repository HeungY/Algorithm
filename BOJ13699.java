
//  점화식

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ13699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Long[] dp = new Long[N + 1];

        dp[0] = 1L;

        for (int i = 1; i <= N; i++) {
            long count = 0;

            for (int j = 0; j < i; j++) {
                count += dp[j] * dp[i - j - 1];
            }
            dp[i] = count;
        }

        System.out.println(dp[N]);
    }
}