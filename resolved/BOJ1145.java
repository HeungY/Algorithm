package resolved;

// 적어도 대부분의 배수

/*
    5개의 숫자가 주어짐.
    5개의 숫자중의 배수인 어떠한 수는 나머지 5개 숫자중 3개 이상의 수로 나눠짐.
    어떠한 수의 최소값.

    접근
    정렬 또는 비교 ( 5개 밖에 없으니까 ) 하여 최소값 찾기.
    최소값의 1배수부터 비교하기
    나눴을때 나머지가 0인 수가 3개 이상일 시, 숫자 출력 후 종료
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1145 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] numbers = new int[5];

        numbers[0] = Integer.parseInt(st.nextToken());
        numbers[1] = Integer.parseInt(st.nextToken());
        numbers[2] = Integer.parseInt(st.nextToken());
        numbers[3] = Integer.parseInt(st.nextToken());
        numbers[4] = Integer.parseInt(st.nextToken());

        Arrays.sort(numbers);

        int[] result = new int[5];

        for (int j = 0; j < 5; j++) {
            int mul = 1;

            while (true) {
                int count = 0;
                int target = numbers[j] * mul;

                for (int i = 0; i < 5; i++) {
                    if (target % numbers[i] == 0) {
                        count++;
                    }
                }

                mul++;

                if (count >= 3) {
                    result[j] = target;
                    break;
                }

            }


        }

        Arrays.sort(result);

        System.out.println(result[0]);
    }
}
