package unresolved;// 네모네모 시력검사

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ18242 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");

        int N = Integer.parseInt(st[0]);
        int M = Integer.parseInt(st[1]);

        boolean[][] matrix = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                if (str[j].equals("#")) {
                    matrix[i][j] = true;
                }
            }
        }

        int initN = 0;
        int initM = 0;
        int rightTopN = 0;
        int rightTopM = 0;

        System.out.println(matrix[2][0]);

        for (int i = 0; i < N; i++) {
            boolean signal = false;
            for (int j = 0; j < M; j++) {
                if (matrix[i][j]) {
                    initN = i;
                    initM = j;
                    signal = true;
                    break;
                }
            }
            if (signal) break;
        }

        for (int i = 0; i < N; i++) {

        }

        System.out.println(initN);
        System.out.println(initM);

    }
}
