package resolved;// 5주차 이분탐색 수 찾기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1920 {
    static List<Integer> numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());            // N 입력부
        numbers = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());            //  M 입력부
        int[] findNumber = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            findNumber[i] = Integer.parseInt(st.nextToken());
        }

        Collections.sort(numbers);

        for (int i = 0; i < M; i++) {
            int result = binarySearch(findNumber[i], 0, numbers.size()-1);
            System.out.println(result);
        }

    }

    static int binarySearch(int value, int low, int high) {
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (value == numbers.get(mid)) {    // 찾음
                return 1;
            }
            if (value <= numbers.get(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return 0;
    }

}
