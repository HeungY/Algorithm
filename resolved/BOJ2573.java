package resolved;// 1주차 DFS BFS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2573 {
    static int n, m;
    static int[][] iceberg;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        iceberg = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                iceberg[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;

        while (true) {
            int numberOfIceberg = 0;
            visited = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (iceberg[i][j] != 0 && !visited[i][j]) {
                        dfs(i, j);
                        numberOfIceberg++;
                    }
                }
            }

            if (numberOfIceberg >= 2) break;
            if (numberOfIceberg == 0) {
                result = 0;
                break;
            }

            copyIceberg();
            result++;
        }
        System.out.println(result);
    }

    static void copyIceberg() {
        int[][] newIceberg = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                newIceberg[i][j] = iceberg[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (iceberg[i][j] != 0) {
                    newIceberg[i][j] = Math.max(newIceberg[i][j] - checkAround(i, j), 0);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                iceberg[i][j] = newIceberg[i][j];
            }
        }

    }

    static int checkAround(int x, int y) {

        int res = 0;

        if (x > 0 && iceberg[x - 1][y] == 0) res++;
        if (x < n - 1 && iceberg[x + 1][y] == 0) res++;
        if (y > 0 && iceberg[x][y - 1] == 0) res++;
        if (y < m - 1 && iceberg[x][y + 1] == 0) res++;

        return res;
    }

    static void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= m || iceberg[x][y] == 0 || visited[x][y]) return;
        visited[x][y] = true;

        dfs(x - 1, y);
        dfs(x + 1, y);
        dfs(x, y - 1);
        dfs(x, y + 1);
    }
}