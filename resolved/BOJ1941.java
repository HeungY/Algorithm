package resolved;//// 2주차 백트래킹 소문난 7공주
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//
//public class BOJ1941 {
//
//    static String[][] princess;
//    static boolean[][] visited;
//    static int result = 0;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        princess = new String[5][5];
//
//        for (int i = 0; i < 5; i++) {
//            String str = br.readLine();
//            String[] prc = str.split("");
//
//            for (int j = 0; j < 5; j++) {
//                princess[i][j] = prc[j];
//            }
//        }
//
//        visited = new boolean[5][5];
//
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                dfs(i, j, 0, 0, 0);
//            }
//        }
//
//        System.out.println(result);
//    }
//
//    static void dfs(int x, int y, int depth, int countS, int countY) {
//        if (x < 0 || y < 0 || x >= 5 || y >= 5 || visited[x][y]) {
//            return;
//        }
//
//        if (princess[x][y].equals("S")) {
//            countS++;
//        } else {
//            countY++;
//        }
//
//        if (countY >= 4) return;
//
//        if (depth == 6) {
//            result++;
//            return;
//        }
//        visited[x][y] = true;
//
//
//        dfs(x - 1, y, depth + 1, countS, countY);
//        dfs(x + 1, y, depth + 1, countS, countY);
//        dfs(x, y - 1, depth + 1, countS, countY);
//        dfs(x, y + 1, depth + 1, countS, countY);
//
//        visited[x][y] = false;
//    }
//}

import java.util.*;

public class BOJ1941 {
    static char map[][] = new char[5][5];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int combX[] = new int[25];
    static int combY[] = new int[25];
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            map[i] = sc.next().toCharArray();
        }

        for (int i = 0; i < 25; i++) {
            combX[i] = i % 5;
            combY[i] = i / 5;
        }

        combination(new int[7], 0, 0, 7);
        System.out.println(ans);
    }

    public static void combination(int[] comb, int idx, int depth, int left) {
        if (left == 0) {
            bfs(comb);
            return;
        }

        if (depth == 25) return;

        comb[idx] = depth;
        combination(comb, idx + 1, depth + 1, left - 1);
        combination(comb, idx, depth + 1, left);
    }

    public static void bfs(int comb[]) {
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[7];

        visited[0] = true;
        q.add(comb[0]);
        int cnt = 1, sCnt = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (map[combY[cur]][combX[cur]] == 'S') sCnt++;

            for (int i = 0; i < 4; i++) {
                for (int next = 1; next < 7; next++) {
                    if (!visited[next] && combX[cur] + dx[i] == combX[comb[next]] && combY[cur] + dy[i] == combY[comb[next]]) {
                        visited[next] = true;
                        q.add(comb[next]);
                        cnt++;
                    }
                }
            }
        }

        if (cnt == 7) {
            if (sCnt >= 4) {
                ans++;
            }
        }
    }
}