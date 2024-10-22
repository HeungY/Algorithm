package resolved;// 색종이

/*
3줄 요약
크기가 100*100 (10,000) 인 흰색 도화지 위에 10*10 (100)인 검은 도화지 올림
검은 도화지의 갯수와 위치가 주어지는데 검은 도화지의 총 넓이 구하기.
X, Y가 주어지는데 X는 검은색 종이와 흰색 종이의 왼쪽 거리, Y는 검은색 종이와 흰색 종이의 아래쪽 거리

겹치는 부분을 선택해서, 색종이 갯수 * 100 에서 겹치는 부분을 빼면 될거같음.

이라고 생각했는데 100*100 matrix 선언해서 체크하고 그거 뽑는거로..

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2563 {
    static boolean[][] matrix = new boolean[100][100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            fill(x, y);
        }

        int result = 0;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (matrix[i][j]) result++;
            }
        }

        System.out.println(result);

    }

    static void fill(int x, int y) {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matrix[x + i][y + j] = true;
            }
        }

    }
}
