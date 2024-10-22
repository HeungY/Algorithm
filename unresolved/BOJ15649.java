package unresolved;// N과 M (1)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15649 {
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Integer> start = new ArrayList<>();
        start.add(1);
        deep(start, 1,3);
    }

    static void deep(List<Integer> start, int depth, int limit) {
        if (depth == limit) {
            
            System.out.println("다 출력하고");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!start.contains(i)) {
                start.add(i);
                deep(start, depth + 1, limit);
            }
        }
    }
}
