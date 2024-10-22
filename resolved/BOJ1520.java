package resolved;// 4주차 DP 내리막길

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1520 {
    static int N, M;
    static int[][]route;
    static long[][] memo;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

       route = new int[N][M];
        memo = new long[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
               route[i][j] = Integer.parseInt(st.nextToken());
                memo[i][j] = -1;  // 초기화
            }
        }

        System.out.println(dfs(0, 0));
    }

    static long dfs(int x, int y) {
        if (x == N - 1 && y == M - 1) {
            return 1;
        }

        if (memo[x][y] != -1) {
            return memo[x][y];
        }

        memo[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M &&route[x][y] >route[nx][ny]) {
                memo[x][y] += dfs(nx, ny);
            }
        }

        return memo[x][y];
    }
}


//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class BOJ1520 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        st = new StringTokenizer(br.readLine());
//
//        int N = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());
//
//        int[][]route = new int[N][M];
//        long[][] memo = new long[N][M];
//
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < M; j++) {
//               route[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        memo[0][0] = 1;
//
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                if (memo[i][j] > 0) {
//                    if (j != M - 1 && i != N - 1 && j != 0) {   // 왼, 아래, 오른 모두 끝이 아닐시
//                        if route[i][j] >route[i + 1][j]) {  // 아래 확인
//                            memo[i + 1][j] += memo[i][j];
//                        }
//                        if route[i][j] >route[i][j + 1]) {  // 오른쪽 확인
//                            memo[i][j + 1] += memo[i][j];
//                        }
//                        if route[i][j] >route[i][j - 1]) {  // 왼쪽 확인
//                            memo[i][j - 1] += memo[i][j];
//                        }
//                    }
//
//                    if (j == 0 && i != N - 1 && j != M - 1) {    // 왼쪽 끝일시
//                        if route[i][j] >route[i + 1][j]) {  // 아래 확인
//                            memo[i + 1][j] += memo[i][j];
//                        }
//                        if route[i][j] >route[i][j + 1]) {  // 오른쪽 확인
//                            memo[i][j + 1] += memo[i][j];
//                        }
//                    }
//
//                    if (i == N - 1 && j != 0 && j != M - 1) {    // 아래 끝일시
//                        if route[i][j] >route[i][j + 1]) {  // 오른쪽 확인
//                            memo[i][j + 1] += memo[i][j];
//                        }
//                        if route[i][j] >route[i][j - 1]) {  // 왼쪽 확인
//                            memo[i][j - 1] += memo[i][j];
//                        }
//                    }
//
//                    if (j == M - 1 && j != 0 && i != N - 1) {    // 오른쪽 끝일시
//                        if route[i][j] >route[i + 1][j]) {  // 아래 확인
//                            memo[i + 1][j] += memo[i][j];
//                        }
//                        if route[i][j] > route[i][j - 1]) {  // 왼쪽 확인
//                            memo[i][j - 1] += memo[i][j];
//                        }
//                    }
//                }
//            }
//        }
//
//        System.out.println(memo[N - 1][M - 1]);
//
//    }
//}
