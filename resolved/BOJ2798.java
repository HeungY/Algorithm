package resolved;
//  블랙잭

/*
    첫째 줄에 N 과 M, 둘째 줄에 N개의 숫자만큼 카드의 점수 주어짐.
    N은 카드 갯수, M은 목표 점수

    M을 넘지 않는 3장의 카드 조합의 최댓값 구하기.


 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] cards = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(blackJack(M, cards));

    }

    static int blackJack(int target, int[] cards) {
        int max = 0;

        for (int i = 0; i < cards.length - 2; i++) {
            int firstScore = cards[i];
            for (int j = i + 1; j < cards.length - 1; j++) {
                int secondScore = cards[j];
                for (int k = j + 1; k < cards.length; k++) {
                    int totalScore = firstScore + secondScore + cards[k];
                    if (totalScore <= target) {
                        max = Math.max(max, totalScore);
                    }
                }
            }
        }

        return max;
    }
}
