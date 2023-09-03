package WEEK_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 20m
public class BOJ_2557_화학식량_Kim {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String bunjas = br.readLine();
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < bunjas.length(); i++) {
            char bunja = bunjas.charAt(i);

            switch (bunja) {
                case '(':
                    stack.push(-1); // 임의의 값
                    break;
                case ')':
                    int temp = 0;
                    while (stack.peek() != -1) { // -1 (즉, '('이 나올 때까지 찾는 것
                        temp += stack.pop();
                    }
                    stack.pop(); // -1 빼기
                    stack.push(temp); // () 사이에 있던 값 temp, stack에 넣어주기
                    break;
                case 'H':
                    stack.push(1);
                    break;
                case 'O':
                    stack.push(16);
                    break;
                case 'C':
                    stack.push(12);
                    break;
                default: // 숫자 1 ~ 9 일때 (case로 나누기 어려워서 if~else로 바꿀까 하다가 귀찮아서 그냥 default로 넣어버림)
                    int justNum = stack.pop(); // 마지막 숫자 빼서
                    justNum *= bunja - '0'; // 거기에 bunja로 나온 숫자 곱해서
                    stack.push(justNum); // 다시 stack 에 넣기
                    break;
            }
        }

        // 스택 안에 있는 값 모두 더해주기
        for (int i = 0; i < stack.size(); i++) {
            answer += stack.get(i);
        }

        System.out.println(answer);
    }
}
