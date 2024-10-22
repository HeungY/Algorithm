package resolved;// 2주차 백트래킹 N-Queen

//import java.util.Scanner;
//
//public class BOJ9663 {
//    static int n;
//    static int[][] chess;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//
//        chess = new int[n][n];
//        int result = 0;
//
//        for (int i = 0; i < n; i++) {
//            boolean[][] visited = new boolean[n][n];
//            int co = dfs(0, i, 0, visited);
//            result += co;
//        }
//        System.out.println(result);
//
//    }
//
//    static int dfs(int x, int y, int depth, boolean[][] visited) {
//        if (visited[x][y]) return 0;
//        visited[x][y] = true;
//
//        int count = 0;
//        if (n - 1 == depth) {
//            count++;
//            return count;
//        }
//
//        for (int i = 0; i < n; i++) {
//            visited[i][y] = true; // 세로
//            for (int j = 0; j < n; j++) {
//                if (x - y + n == i - j + n || x + y == i + j) { // 대각선
//                    visited[i][j] = true;
//                }
//            }
//        }
//
//
//        for (int i = 0; i < n; i++) {
//            count += dfs(depth + 1, i, depth + 1, visited);
//        }
//        return count;
//    }
//}


import java.util.Scanner;

public class BOJ9663 {
    static int n;
    static boolean[] cols, d1, d2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        cols = new boolean[n];
        d1 = new boolean[2 * n];
        d2 = new boolean[2 * n];

        int result = dfs(0);
        System.out.println(result);
    }

    static int dfs(int row) {
        if (row == n) {
            return 1;
        }

        int count = 0;
        for (int col = 0; col < n; col++) {
            if (cols[col] || d1[row - col + n] || d2[row + col]) {
                continue;
            }

            cols[col] = d1[row - col + n] = d2[row + col] = true;

            count += dfs(row + 1);

            cols[col] = d1[row - col + n] = d2[row + col] = false;
        }

        return count;
    }
}
