//  벌집

/*
    1
    7   6
    19  12
    37  18
    61  24
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2292 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int count = 1;
        int start = 1;
        int end = 7;
        int bee = 6;

        if (N == 1) {
            System.out.println(1);
            return;
        }

        while (true) {
            count++;
            if (judge(start, end)) {
                break;
            }
            bee += 6;
            start = end +1;
            end += bee;
        }


        System.out.println(count);

    }

    static boolean judge(int start, int end) {

        return start <= N && N <= end;
    }
}
