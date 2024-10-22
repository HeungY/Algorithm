package unresolved;
// 계단 오르기

/*
    문제 요약
   계단에 점수가 부여되어 있고,  한개씩 또는 두개씩 계단을 오를 수 있음
   계단을 연속해서 3개 모두 밟으면 안됨. 시작점은 계단에 포함X, 마지막 계단은 반드시 밟아야됨.
   계단을 밟아서 얻는 점수의 최댓값을 구하시오.

    접근
   앞에꺼보다 뒤에꺼가 더 크면 뛰어서 밟아버리기.
   근데 여기서 문제 !
   10 20 1 30 이렇게 나온다면
   20 30 = 50 이 될텐데
   10 20 30 = 60 이 맞는 답.

   10 20 30 50 20 3000 30 20
   위에 말대로 하면 20 50 30 밟아서 100이겠네?
   근데 답은
   10 30 50 30 = 120 이여야지

   스택에
   10 20 넣고 30 확인했는데 20보다 크니까 20 빼고 카운트에 10 추가하고 다시 스택에 30 넣기
   30 50 넣고 20 확인했는데 50보다 작으니까 30 50 카운트에 추가하고 20 건너뛰고 30부터 스택 넣기

   마지막을 무조건 밟게 하는 방법 ! 마지막의 요소에 +10000을 해주고 마지막 카운트에서 10000을 빼버리기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] stair = new int[N];

        for (int i = 0; i < N; i++) {
            stair[i] = Integer.parseInt(br.readLine());
            if (i == N - 1) {
                stair[i] += 10001;
            }
        }

        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (stack.size() < 2) {
                stack.push(stair[i]);
            }

            if (stack.size() == 2) {
                if (stair[i] < stair[i + 1]) {
                    stack.pop();
                    count += stack.pop();
                }
                if (stair[i] > stair[i + 1]) {
                    count += stack.pop();
                    count += stack.pop();
                    i++;
                }

            }
        }

        System.out.println(count - 10001);

    }
}

// 아래가 직피티 쓴거. ;;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class unresolved.BOJ2579 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//
//        int[] stair = new int[N + 1];
//        int[] dp = new int[N + 1];
//
//        for (int i = 1; i <= N; i++) {
//            stair[i] = Integer.parseInt(br.readLine());
//        }
//
//        dp[1] = stair[1];
//        if (N > 1) {
//            dp[2] = stair[1] + stair[2];
//        }
//
//        for (int i = 3; i <= N; i++) {
//            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stair[i - 1]) + stair[i];
//        }
//
//        System.out.println(dp[N]);
//    }
//}