package resolved;// 구현 방 번호

/*
 세줄 요약
1,000,000 이하인 자연수 N 주어짐
0번부터 9번까지 숫자가 하나씩 들어있는 숫자세트들로 방번호를 구성하는 최솟값.
9와 6은 뒤집어서 사용 가능하다.
 */

import java.util.Scanner;

public class BOJ1475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();

        int[] numbers = new int[10];
        String[] num = N.split("");

        for (int j = 0; j< num.length; j++) {
            for (int i = 0; i < 10; i++) {
                String temp = i + "";
                if (num[j].equals(temp)) numbers[i] += 1;
            }
        }

        int fix = numbers[6] + numbers[9];

        if (fix % 2 != 0) {
            fix = fix / 2 + 1;
        } else fix = fix / 2;

        numbers[6] = fix;
        numbers[9] = fix;
        int max = 0;
        for (int i = 0; i < 10; i++) {
            max = Math.max(max, numbers[i]);
        }

        System.out.println(max);
    }
}
