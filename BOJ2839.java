//  설탕 배달
/*
    3, 5 로 N을 딱 떨어지게 나누는 최솟값

    5로 먼저 나누면 나머지가 0,1,2,3,4 까지 나오겠지?
    0이면 ~
    1이면 5 하나 대신 3두개
    2면 5 두개 대신 3 네개
    3이면 3하나 추가
    4면 5대신 3 세개 추가

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2839 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        System.out.println(sugar());
    }

    static int sugar() {
        if (N % 5 == 1) {
            if (N - 5 < 0) {
                return -1;
            }
            return (N / 5) - 1 + 2;
        }
        if (N % 5 == 2) {
            if (N - 10 < 0) {
                return -1;
            }
            return (N / 5) - 2 + 4;
        }
        if (N % 5 == 3) {
            return (N / 5) + 1;
        }
        if (N % 5 == 4) {
            if (N - 5 < 0) {
                return -1;
            }
            return (N / 5) - 1 + 3;
        }
        return N / 5;
    }
}
