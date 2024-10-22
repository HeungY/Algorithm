package resolved;// 2주차 백트래킹 신기한 소수

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ2023 {
    static int n;
    static List<Integer> magicNumbers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < 10; i++) {      // 초기 세팅
            if (isPrime(i)) {
                int[] num = new int[n];
                num[0] = i;
                dfs(1, num);
            }
        }

        Collections.sort(magicNumbers);     // 출력부
        for (int i = 0; i < magicNumbers.size(); i++) {
            System.out.println(magicNumbers.get(i));
        }
    }


    static void dfs(int x, int[] num) {
        if (x == n) {                       // 자릿수 같을시 magicNumbers에 add 하고 return
            String magic = "";
            for (int i = 0; i < n; i++) {
                magic += Integer.toString(num[i]);
            }
            magicNumbers.add(Integer.parseInt(magic));
            return;
        }

        String primeNum = "";               // 이전 소수들 세팅
        for (int i = 0; i < x; i++) {
            primeNum += Integer.toString(num[i]);
        }

        for (int i = 0; i < 10; i++) {      // 이전 소수에 숫자를 붙여 새롭게 수 생성
            String currNum = primeNum + i;

            if (isPrime(Integer.parseInt(currNum))) {
                num[x] = i;
                dfs(x + 1, num);
            }
        }
    }


    public static boolean isPrime(int n) {      // 소수 판별
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {       // 제곱근까지 나눔
            if (n % i == 0) return false;
        }
        return true;
    }
}
