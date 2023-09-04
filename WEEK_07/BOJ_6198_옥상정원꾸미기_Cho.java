import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long count = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());
            while (!stack.isEmpty() && stack.peek() <= height) {
                stack.pop(); 

            } //N번의 입력동안 순차대로 새로 들어오는 건물의 높이보다 작은 것들은 전부 pop해서 빼냄
            count += stack.size(); //남아있는것들은 전부 새로들어온 건물보다 높으므로 스택 사이즈를 더해줌
            stack.push(height); //스택에 높이를 넣음
        }

        System.out.println(count); //n번 입력 후(마지막 빌딩) 그때까지의 합 출력
    }
}
