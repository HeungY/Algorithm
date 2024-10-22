package resolved;// 최댓값


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] matrix = new int[9][9];
        StringTokenizer st;

        int max = 0;
        int locX = 0;
        int locY = 0;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if (max < matrix[i][j]) {
                    max = Math.max(max,matrix[i][j]);
                    locX = i + 1;
                    locY = j + 1;
                }
            }
        }

        if(locX == 0) locX++;
        if(locY == 0) locY++;

        System.out.println(max);
        System.out.println(locX + " " + locY);

    }
}
