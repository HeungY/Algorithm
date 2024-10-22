package resolved;// 백준 1926 그림

// 첫째 줄에 도화지의 세로 크기 n(1 ≤ n ≤ 500)과 가로 크기 m(1 ≤ m ≤ 500)이 차례로 주어진다.
// 두 번째 줄부터 n+1 줄 까지 그림의 정보가 주어진다. ( 단 그림의 정보는 0과 1이 공백을 두고 주어지며,
// 0은 색칠이 안된 부분, 1은 색칠이 된 부분을 의미한다)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1926 {
    static int n, m;
    static int[][] picture;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        picture = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                picture[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxPictureSize = 0;
        int numberOfPictures = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (picture[i][j] == 1 && !visited[i][j]) {
                    int size = dfs(i, j);
                    numberOfPictures++;
                    maxPictureSize = Math.max(maxPictureSize, size);
                }
            }
        }
        System.out.println(numberOfPictures);
        System.out.println(maxPictureSize);
    }

    static int dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= m || picture[x][y] == 0 || visited[x][y]) return 0;

        visited[x][y] = true;
        int size = 1;

        size += dfs(x + 1, y);
        size += dfs(x - 1, y);
        size += dfs(x, y + 1);
        size += dfs(x, y - 1);
        return size;
    }
}
