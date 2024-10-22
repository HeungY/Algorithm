package unresolved;// 학생 번호
/*
    다시 풀어봐라. 밑에 접근 틀렸다

    접근
    2<=1000 이라는 범위에서 뒤에 세자리 이상 갈수없음.
    쭉 입력 받고
    하나 잡아서 길이 재기
    길이 마지막 요소 뽑아서 contains
    1 이상이면 안됨
    길이 마지막 요소 + 다음요소 뽑아서 contains
    모두 0일때까지 반복
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ1235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] numbers = new String[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = br.readLine();
        }

        int length = numbers[0].length();

        for (int k = 1; k <= length; k++) {
            Set<String> seen = new HashSet<>();
            boolean unique = true;

            for (int i = 0; i < N; i++) {
                String suffix = numbers[i].substring(length - k);
                if (seen.contains(suffix)) {
                    unique = false;
                    break;
                }
                seen.add(suffix);
            }

            if (unique) {
                System.out.println(k);
                break;
            }
        }
    }
}