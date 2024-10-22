package resolved;// 4주차 DP 점프

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] game = new int[N][N];
        long[][] memo = new long[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                game[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        memo[0][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (memo[i][j] > 0 && game[i][j] > 0) {
                    int jump = game[i][j];
                    if (i + jump < N) {
                        memo[i + jump][j] += memo[i][j]; // 아래로 점프
                    }
                    if (j + jump < N) {
                        memo[i][j + jump] += memo[i][j]; // 오른쪽으로 점프
                    }
                }
            }
        }
        System.out.println(memo[N - 1][N - 1]);
    }
}





