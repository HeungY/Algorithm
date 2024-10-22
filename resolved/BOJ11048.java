//  이동하기

package resolved;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DFS로 풀었다가 DP로 전환..

//public class resolved.BOJ11048 {
//    static int N;
//    static int M;
//    static int[][] maze;
//    static int result;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        maze = new int[N][M];
//        boolean[][] visited = new boolean[N][M];
//        int count = 0;
//
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < M; j++) {
//                maze[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//        dfs(0, 0, visited, count);
//        System.out.println(result);
//
//    }
//
//    static void dfs(int x, int y, boolean[][] visited, int count) {
//        if (x < 0 || y < 0 || x >= N || y >= M || visited[x][y]) {
//            result = Math.max(result, count);
//            return;
//        }
//
//        count += maze[x][y];
//
//        dfs(x + 1, y, visited, count);
//        dfs(x, y + 1, visited, count);
//        dfs(x + 1, y + 1, visited, count);
//    }
//}
public class BOJ11048 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] maze = new int[N][M];
        int[][] dp = new int[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // DP 테이블 초기화 및 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // (i, j)로 가는 모든 경로에서의 최대 사탕 개수를 계산
                if (i > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + maze[i][j]);
                }
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + maze[i][j]);
                }
                if (i > 0 && j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + maze[i][j]);
                }
                // 시작 위치 (0, 0)인 경우 따로 초기화 필요
                if (i == 0 && j == 0) {
                    dp[i][j] = maze[i][j];
                }
            }
        }

        // (N-1, M-1)에서의 최대 사탕 개수 출력
        System.out.println(dp[N - 1][M - 1]);
    }
}
