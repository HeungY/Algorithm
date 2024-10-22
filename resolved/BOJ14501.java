package resolved;// 4주차 DP 퇴사

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14501 {
    static int maxCost = 0;
    static int N;
    static int[] term;
    static int[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        term = new int[N];
        cost = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            term[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.println(maxCost);

    }

    static void dfs(int day, int sumCost) {
        if (day >= N) {      // 퇴사일을 넘어선 경우
            maxCost = Math.max(maxCost, sumCost);
            return;
        }

        dfs(day + 1, sumCost);     // 현재 상담을 선택하지 않는 경우

        if (day + term[day] <= N) {     // 현재 상담을 선택하는 경우
            dfs(day + term[day], sumCost + cost[day]);
        }
    }
}
