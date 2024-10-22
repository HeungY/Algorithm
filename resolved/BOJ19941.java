package resolved;
//  햄버거 분배

/*
    슬라이딩 윈도우? why 그리디?





 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String[] hamburger = new String[N];
        boolean[] eat = new boolean[N];
        int count = 0;

        String[] str = br.readLine().split("");
        for (int i = 0; i < N; i++) {
            hamburger[i] = str[i];

            if (str[i].equals("P")) {
                eat[i] = true;
            }
        }

        for (int i = 0; i < N; i++) {
            if (hamburger[i].equals("P")) {
                for (int j = i - K; j <= i + K; j++) {
                    if (j < 0 || j > N - 1) continue;

                    if (hamburger[j].equals("H") && !eat[j]) {
                        eat[j] = true;
                        count++;
                        break;
                    }

                }
            }
        }

        System.out.println(count);


    }
}
