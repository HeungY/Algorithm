package resolved;//// 3주차 그리디 순회강연
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class BOJ2109 {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//
//
//        List<Integer>[] lecture = new ArrayList[n];
//        for (int i = 0; i < n; i++) {
//            String[] str = br.readLine().split(" ");
//            lecture[i] = new ArrayList<>();
//
//            lecture[i].add(Integer.parseInt(str[1]));
//            lecture[i].add(Integer.parseInt(str[0]));
//        }
//
//        Arrays.sort(lecture, Comparator.comparing(o -> o.get(1)));
//
//        HashMap hs = new HashMap();
//        for (int i = 0; i < lecture.length; i++) {
//            hs.put(lecture[i].get(0), lecture[i].get(1));
//        }
//
//        Collection<Integer> values = hs.values();
//
//        int count = 0;
//        for (int i : values) {
//            count += i;
//        }
//
//        System.out.println(count);
//
//
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2109 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<int[]> lectures = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            lectures.add(new int[]{Integer.parseInt(str[0]), Integer.parseInt(str[1])});
        }

        lectures.sort((a, b) -> b[1] - a[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int total = 0, index = 0;

        for (int day = lectures.get(0)[1]; day > 0; day--) {
            while (index < n && lectures.get(index)[1] == day) {
                pq.add(lectures.get(index++)[0]);
            }
            if (!pq.isEmpty()) total += pq.poll();
        }

        System.out.println(total);
    }
}
