package resolved;// 5주차 이분탐색 나무 자르기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2805 {

    static List<Integer> tree = new ArrayList<>();
    static int require;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        require = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            tree.add(Integer.parseInt(st.nextToken()));     // 입력부 끝
        }

        Collections.sort(tree);

        cut();

    }

    static void cut() {
        int low = 0;
        int high = tree.get(tree.size() - 1);

        while (low <= high) {
            int mid = (low + high) / 2;
            long sum = 0;

            for (int i = 0; i < tree.size(); i++) {

                if (tree.get(i) > mid) {    // 잘린 값이 음수가 되면 안됨
                    sum += tree.get(i) - mid;
                }

            }

            if (sum >= require) {   // 너무 많이 자름
                low = mid + 1;
            } else {    // 적게 자르면
                high = mid - 1;
            }
        }

        System.out.println(high);
    }
}
