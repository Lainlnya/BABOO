package WEEK_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 1h
public class BOJ_1874_스택수열_Kim {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int total = Integer.parseInt(br.readLine());
        int[] result = new int[total];
        Stack<Integer> stack = new Stack<>();

        int count = 1;

        // 만들어야 하는 배열
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i <= result.length; i++) {
            // stack에 넣을 것은 count, result[i] 보다 count가 같거나 작으면 우선 stack에 넣기, => +
            while (count <= result[i]) {
                stack.push(i);
                sb.append("+\n");
                count += 1;
            }

            // 마지막 값과 비교했을 때 같지 않으면 바로 다른건 출력하지 않고 "NO" 출력
            if (stack.peek() != result[i]) {
                System.out.println("NO");
                System.exit(0);
            }

            // 마지막 값 빼주기
            stack.pop();
            sb.append("-\n");
        }
        System.out.println(sb);
    }
}
