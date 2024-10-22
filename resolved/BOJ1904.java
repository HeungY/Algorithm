package resolved;
// 01타일
/*
2자리 00 11 2개
3자리 001 100 111 3개
    000 001 010 100 011 101 110 111
4자리 0000 0011 1100 1001 1111 5개
5자리 00001 00100 10000 11100 11001 10011 00111 11111 8개
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(tile(N));

    }

    static int tile(int N) {
        if (N == 1) return 1;
        if (N == 2) return 2;


        int[] dp = new int[N];
        dp[0] = 1;
        dp[1] = 2;
        int sum = 0;

        for (int i = 2; i < N; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 15746;
            sum = dp[i];
        }


        return sum;
    }
}
