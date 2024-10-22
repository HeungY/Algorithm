package resolved;
// 2*n 타일링
/*
 1 1
 2 2
 3 3
 4 5
 5 8


 ||||| |||= ||=| |=|| =|||
 ==| =|= |==


 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(1);
            return;
        }

        Long[] dp = new Long[N];
        dp[0] = 1L;
        dp[1] = 2L;

        for (int i = 2; i < N; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;

        }

        System.out.println(dp[N - 1]);
    }
}
