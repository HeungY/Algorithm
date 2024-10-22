package resolved;// 5주차 이분탐색 좋다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1253 {

    static List<Integer> numbers = new ArrayList<>();
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        result = 0;
        Collections.sort(numbers);

        for (int i = 0; i < numbers.size(); i++) {
            if (isGood(i)) {
                result++;
            }
        }

        System.out.println(result);
    }

    static boolean isGood(int numberIndex) {
        int target = numbers.get(numberIndex);
        int left = 0;
        int right = numbers.size() - 1;

        while (left < right) {
            if (left == numberIndex) {
                left++;
                continue;
            }
            if (right == numberIndex) {
                right--;
                continue;
            }

            int sum = numbers.get(left) + numbers.get(right);

            if (sum == target) {
                return true;
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }
}
























//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.StringTokenizer;
//
//public class BOJ1253 {
//
//    static List<Integer> numbers = new ArrayList<>();
//    static int result;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        int N = Integer.parseInt(br.readLine());
//        st = new StringTokenizer(br.readLine(), " ");
//
//        for (int i = 0; i < N; i++) {
//            numbers.add(Integer.parseInt(st.nextToken()));
//        }
//        result = 0;
//        Collections.sort(numbers);
//
//
//        for (int i = 0; i < numbers.size(); i++) {
//            isGood(i);
//        }
//
//        System.out.println(result);
//
//    }
//
//    static void isGood(int number) {
//
//        for (int i = 0; i <= number; i++) {
//            if (binarySearch(numbers.get(number) - numbers.get(i), i + 1, number - 1) == 1) {
//                result++;
//                return;
//            }
//        }
//    }
//
//    static int binarySearch(int value, int low, int high) {
//        int mid;
//
//        while (low <= high) {
//            mid = (low + high) / 2;
//
//            if (value == numbers.get(mid)) {    // 찾음
//                return 1;
//            }
//            if (value <= numbers.get(mid)) {
//                high = mid - 1;
//            } else {
//                low = mid + 1;
//            }
//        }
//
//        return 0;
//    }
//}
