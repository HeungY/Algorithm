package unresolved;// 번데기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        int checkFunDegi = Integer.parseInt(br.readLine());

        int[] funDegi = new int[2];
        int count = 2;

        while (funDegi[checkFunDegi] != T) {
            funDegi[0] += 1;
            funDegi[1] += 1;
            funDegi[0] += 1;
            funDegi[1] += 1;
            for (int i = 0; i < count; i++) {
                funDegi[0] += 1;
            }
            for (int i = 0; i < count; i++) {
                funDegi[1] += 1;
            }
            count++;
        }

        System.out.println(funDegi[checkFunDegi] % N);
    }
}
