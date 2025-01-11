package resolved;
//  분해합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(checkNumber(N));
    }

    static private int checkNumber(int N) {
        int count = 0;

        while (true) {

            int checkNum = count + sliceNumber(count);
            if (checkNum == N) {
                break;
            }
            if(count > N){
                count = 0;
                break;
            }
            count++;
        }

        return count;
    }

    static private int sliceNumber(int N) {
        int result = 0;

        while (N > 0) {
            result += N % 10;
            N /= 10;
        }

        return result;
    }
}
