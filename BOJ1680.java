
//  쓰레기 수거

/*
    문제 요약
   쓰레기를 회수해야됨. 각 지점마다 거리와 쓰레기가 주어짐
   쓰레기 차가 지점을 도는데 용량이 다 차거나, 지점에 도착했을시 쓰레기차의 용량을 넘거나, 더이상 지점이 없을시 복귀해서 놓음.

    접근
    테스트케이스 T의 범위가 주어지지 않았음.. 뭐지 일단 ㄱ
    용량과 지점 갯수 주어짐

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1680 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int[][] data = new int[N][2];

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                data[j][0] = Integer.parseInt(st.nextToken());
                data[j][1] = Integer.parseInt(st.nextToken());
            }

            System.out.println(recycle(W, N, data));

        }

    }

    static int recycle(int weight, int dist, int[][] data) {
        int count = 0;
        int curW = 0;
        int maxW = weight;

        for (int i = 0; i < dist; i++) {


            curW += data[i][1];

            if (curW == maxW) {
                curW = 0;
                count += data[i][0];
            }

            if (curW > maxW) {
                curW = 0;
                count += data[i][0];
                i--;
                continue;
            }

            if (i == 0) {
                count += data[i][0];
                continue;
            }
            count += data[i][0] - data[i - 1][0];

        }
        count += data[dist - 1][0];

        return count;
    }
}
