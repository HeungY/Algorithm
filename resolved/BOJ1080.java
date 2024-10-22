package resolved;// 3주차 그리디 행렬

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1080 {
    static int[][] N;
    static int[][] M;
    static int n;
    static int m;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        N = new int[n][m];
        M = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] st = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                N[i][j] = Integer.parseInt(st[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            String[] st = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                M[i][j] = Integer.parseInt(st[j]);
            }
        }

        // 입력부 끝

        int result = 0;
        boolean check = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (N[i][j] != M[i][j] && i <= n - 3 && j <= m - 3) {   // 변환 가능한지 확인
                    change(i, j);
                    result++;
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (N[i][j] != M[i][j]) {       // 숫자 같은지 판별
                    check = false;
                    break;
                }
            }
        }

        if (check) System.out.println(result);
        else System.out.println(-1);


    }

    static void change(int x, int y) {      // 숫자 변환

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                N[x + i][y + j] = 1 - N[x + i][y + j];
            }
        }

    }
}
