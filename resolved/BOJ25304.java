package resolved;// 영수증

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ25304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int cost = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int[][] buy = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            buy[i][0] = Integer.parseInt(st.nextToken());
            buy[i][1] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        for (int i = 0; i < N; i++) {
            count = count + (buy[i][0] * buy[i][1]);
        }

        if (count == cost) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
