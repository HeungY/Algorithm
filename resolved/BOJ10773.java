package resolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Stack;

public class BOJ10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }

        System.out.println(zero(stack));

    }

    static BigInteger zero(Stack<Integer> stack) {
        BigInteger count = BigInteger.ZERO;

        while (!stack.isEmpty()) {
            BigInteger stackInt = BigInteger.valueOf(stack.pop());
            count = count.add(stackInt);
        }

        return count;
    }
}
