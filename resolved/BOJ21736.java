package resolved;
// 헌내기는 친구가 필요해
/*

    dfs로 풀면 될듯?

 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21736 {
    static int N;
    static int M;
    static String[][] campus;
    static boolean[][] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        campus = new String[N][M];
        visited = new boolean[N][M];
        count = 0;

        int posX = 0;
        int posY = 0;

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                campus[i][j] = str[j];
                if (str[j].equals("I")) {
                    posX = i;
                    posY = j;
                }
            }
        }

        dfs(posX, posY);

        if (count == 0) {
            System.out.println("TT");
            return;
        }

        System.out.println(count);

    }


    static void dfs(int x, int y) {
        if (x < 0 || y < 0 || x > N - 1 || y > M - 1 || visited[x][y] || campus[x][y].equals("X")) {
            return;
        }
        visited[x][y] = true;

        if (campus[x][y].equals("P")) count++;


        dfs(x - 1, y);
        dfs(x + 1, y);
        dfs(x, y - 1);
        dfs(x, y + 1);

    }
}
