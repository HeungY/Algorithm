
//  거짓말
/*
    그래프지? ㅋㅋ 간선ㄴ으로 연결하고 연결되지 않은 노드를 픽하면 되잖아
    중요한건 결국 노드끼리 연결하는 간선의 존재 유무.
    HashMap을 통해 간선을 저장

    파티배열 2차원
    사람수 배열 1차원

    파티 정보 입력받으며 현재 파티 안에 진실 아는 사람 contain 되어있는지 확인하고 있다면 현재 입력받은 파티원 진실 아는자에 전부 넣기
    쭉 반복

    다시 파티배열 순회하며 현재 파티에서 진실아는자 리스트에 contain 되는지 확인. 없다면 결과값 증가

 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1043 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int people = Integer.parseInt(st.nextToken());
        int party = Integer.parseInt(st.nextToken());
        List<Integer> truth = new ArrayList<>();
        List<int[]> curParty = new ArrayList<>();


        st = new StringTokenizer(br.readLine());
        int knowTruthCount = Integer.parseInt(st.nextToken());
        if (knowTruthCount == 0) {
            System.out.println(party);
            return;
        }
        while (st.hasMoreTokens()) {
            truth.add(Integer.parseInt(st.nextToken()));
        }


        for (int i = 0; i < party; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int[] arr = new int[size];
            boolean checkTrue = false;
            for (int j = 0; j < size; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                if (truth.contains(arr[j])) checkTrue = true;
            }
            curParty.add(arr);
            if (checkTrue) {
                for (int j = 0; j < size; j++) {
                    truth.add(arr[j]);
                }
            }
        }

        Set<Integer> temp = new HashSet<>(truth);
        List<Integer> sortedTruth = new ArrayList<>(temp);

        int result = 0;

        for (int i = 0; i < party; i++) {
            int[] arr = curParty.get(i);
            for (int j = 0; j < arr.length; j++) {
                if (sortedTruth.contains(arr[j])) {
                    result++;
                    break;
                }
            }
        }

        result = party - result;

        System.out.println(result);

    }
}
