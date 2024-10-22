package unresolved;
// 임진왜란
/*

    해시맵으로 들어오는 순서 <String,Integer> 이름, i로 순서 증가

    그 다음 들어오는 라인 배열에 저장.

    i를 1씩 증가시키며 i부터 N까지 브루트포스
    target.value(i)>key.value(i)
    -> count++

 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ3077 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> word = new HashMap<>();
        String[] input = new String[N];
        int count = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            word.put(st.nextToken(), i);
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            input[i] = st.nextToken();
        }

        for (int i = 0; i < N; i++) {
            int current = word.get(input[i]);
            for (int j = i; j < N; j++) {
                if (current < word.get(input[j])) {
                    count++;
                }
            }
        }

        System.out.println(count + "/" + (N * (N - 1)) / 2);

    }
}
