package unresolved;
// 게임

/*
    문제 요약
   현재 게임횟수 X, 이긴 게임 Y, 승률 Z.
   앞으로 계속해서 게임에 승리한다고 가정.
   승률 Z가 변하는 순간까지 이겨야되는 게임의 횟수 ( 이긴게임이 오를수록 게임횟수도 오름 )

   왼쪽 끝이 Y고, 오른쪽 끝이 X/100 + Y ( Y가 1퍼 상승하는 구간 )
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());


    }
}
