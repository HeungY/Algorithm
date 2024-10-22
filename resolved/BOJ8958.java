package resolved;// OX 퀴즈

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        int N = Integer.parseInt(br.readLine());
        String[] quiz = new String[N];

        for (int i = 0; i < N; i++) {
            quiz[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            System.out.println(score(quiz[i]));
        }
    }

    public static int score(String str) {
        int totalScore = 0;
        int currentScore = 0;
        String[] temp = str.split("");

        for (int i = 0; i < temp.length; i++) {
            if (temp[i].equals("X")) {
                currentScore = 0;
                continue;
            }
            currentScore++;
            totalScore += currentScore;

        }

        return totalScore;
    }
}
