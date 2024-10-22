
//  어두운 굴다리
/*
이분탐색이지? ㅋㅋ 하다가 구현이라 생각했는데 맞았쥬? 구현 이분탐색 맞쥬? ㅋㅋ
굴다리 길이 N
가로등 개수 M
가로등 위치 x x x

x를 받고 0과 N을 추가해서 사이의 거리 최대값을 출력하면 되잖아

 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17266 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] bulb = new int[M + 2];
        int result = 0;

        bulb[0] = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            bulb[i] = Integer.parseInt(st.nextToken());
        }
        bulb[M + 1] = N;

        for (int i = 1; i < bulb.length; i++) {
            int min = bulb[i] - bulb[i - 1];
            if (i != 1 && i != bulb.length - 1) {
                if (min % 2 == 1) {
                    min = min / 2 + 1;
                } else min = min / 2;
            }
            result = Math.max(result, min);
        }

        System.out.println(result);
    }
}
