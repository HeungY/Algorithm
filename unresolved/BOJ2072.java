package unresolved;
// 오목
/*
    문제 요약
   19 * 19 size 오목판 오목을 둠
   홀수는 흑, 짝수는 백.
   위치가 주어질 때, 몇번째 수에서 승부가 나는지

   접근
   int[][]로 matrix 선언 후 0으로 모두 초기화.
   0이면 수가 없음, 1이면 흑, 2면 백으로 구분
   하나 놓고 matrix 설정.
   가로, 세로, 대각, 대각 네번 검사.
   흑을 놨으면 흑에 대해 검사, 백을 놨으면 백에 대해 검사
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2072 {
    static int EMPTY = 0;
    static int BLACK = 1;
    static int WHITE = 2;
    static int[][] matrix = new int[19][19];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int result = 0;

        for (int i = 0; i < 19; i++) {  // 0으로 초기화
            for (int j = 0; j < 19; j++) {
                matrix[i][j] = 0;
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int X = Integer.parseInt(st.nextToken()) - 1;
            int Y = Integer.parseInt(st.nextToken()) - 1;

            if (i % 2 == 0) matrix[X][Y] = BLACK;
            if (i % 2 == 1) matrix[X][Y] = WHITE;

            if (horizon(X, Y, matrix[X][Y]) == 5) {
                result = i;
                break;
            }
            if (vertical(X, Y, matrix[X][Y]) == 5) {
                result = i;
                break;
            }
            if (leftTop(X, Y, matrix[X][Y]) == 5) {
                result = i;
                break;
            }
            if (rightTop(X, Y, matrix[X][Y]) == 5) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }

    static int horizon(int X, int Y, int color) {
        int count = 0;
        for (int i = 0; i < 19; i++) {
            if (matrix[i][Y] == color) {
                count++;
            }
        }
        return count;
    }

    static int vertical(int X, int Y, int color) {
        int count = 0;
        for (int i = 0; i < 19; i++) {
            if (matrix[X][i] == color) {
                count++;
            }
        }
        return count;
    }

    static int leftTop(int X, int Y, int color) {
        int count = 0;
        int temp = Math.abs(X - Y);
        int startX = 0;
        int startY = 0;

        if (X > Y) startX = temp;
        if (Y > X) startY = temp;

        while (startX != 18 || startY != 18) {
            if (matrix[startX][startY] == color) count++;

            startX++;
            startY++;
        }

        return count;
    }

    static int rightTop(int X, int Y, int color) {
        int count = 0;
        int temp = Math.abs(X - Y);
        int startX = X + temp;
        int startY = 0;

        while (startX != 0) {
            if (matrix[startX][startY] == color) count++;

            startX--;
            startY++;
        }

        return count;
    }
}












