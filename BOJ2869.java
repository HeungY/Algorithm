
//  달팽이는 올라가고 싶다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int up = Integer.parseInt(st.nextToken());
        int slip = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        System.out.println(climb(up, slip, target));

    }

    static int climb(int up, int slip, int target) {
        int count = 0;

        int goal = target - up;

        int climbPerDay = up - slip;

        count = goal / climbPerDay;
        if (goal % climbPerDay != 0) {
            count++;
        }
        count++;

        return count;
    }
}
