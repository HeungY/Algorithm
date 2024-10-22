package resolved;
// 랜선 자르기
/*
    문제 요약
   랜선 K개를 잘라서 N개로 만들어야됨.
   한번 자른 랜선은 다른곳에 이어붙일수 없음 ( 잘리면 나머진 버린다는 뜻 )
   랜선의 길이가 최대가 되는 값 구하기. 항상 K <= N, K는 1~10,000 N은 1~1,000,000. 랜선의 길이는 매우 김. 2^31-1

   접근
   이분탐색으로 풀어나갈거임.
   입력되는 랜선 길이의 최댓값 구해서 1~랜선길이 이분탐색 진행
   몫이 N이 되는 지점을 구해서 길이를 1씩 증가시킴
   N+1이 되기 직전의 시점의 길이 출력

 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1654 {
    static int K;
    static int N;
    static int[] lan;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        lan = new int[K];

        int max = 0;

        for (int i = 0; i < K; i++) {
            lan[i] = Integer.parseInt(br.readLine());
            if (lan[i] > max) {
                max = lan[i];
            }
        }

        long left = 1;
        long right = max;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (judge(mid) >= N) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }

    static long judge(long mid) {
        long count = 0;

        for (int i = 0; i < K; i++) {
            count += lan[i] / mid;
        }

        return count;
    }
}