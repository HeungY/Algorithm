
//  웜 바이러스

/*

    Map에 저장된 숫자 꺼내서 Queue에 등록.
    등록한 숫자 Set에 등록
    Map에서 뽑은거 지움.

    큐가 없어질때까지 반복
    Set의 Size 반환.

 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ2606 {
    private static Set<Integer> virusComputers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int computers = Integer.parseInt(br.readLine());
        int connected = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < connected; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            List<Integer> list;
            if (map.containsKey(key)) {
                list = map.get(key);
            } else {
                list = new ArrayList<>();
            }
            list.add(value);
            map.put(key,list);
        }

        virusComputers = new HashSet<>();
        virusComputers.add(1);
        findWarms(map);

        System.out.println(virusComputers.size()-1);

    }

    private static void findWarms(Map<Integer, List<Integer>> map) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            if(map.containsKey(temp)) {
                virusComputers.addAll(map.get(temp));

                List<Integer> list = map.get(temp);

                for (Integer integer : list) {
                    queue.offer(integer);
                }

                map.remove(temp);
            }

            Set<Integer> integers = map.keySet();
            for (Integer integer : integers) {
                if(map.get(integer).contains(temp)) {
                    queue.offer(integer);
                    virusComputers.add(integer);
                }
            }
        }
    }
}
