package resolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 괄호
/*
    문제 요약
   ( 와 )가 잘 닫혀있으면 VPS라고 함.



   일단 두개의 갯수가 다르면 무조건 NO

 */
public class BOJ9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] PS = new String[N];

        for (int i = 0; i < N; i++) {
            PS[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            String[] st = PS[i].split("");
            int count = 0;
            for (int j = 0; j < st.length; j++) {
                if (count < 0) break;
                if (st[j].equals("(")) {
                    count++;
                } else {
                    count--;
                }
            }
            if(count == 0){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }


    }
}
