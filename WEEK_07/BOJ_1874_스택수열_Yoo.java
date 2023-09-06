package asdf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringBuilder sb = new StringBuilder();
        
        //배열의 인덱스
        int index = 0;
        
        //현재 값 추적할 변수
        int num = 1;

        //arr 안에 n 까지의 숫자 연속해서 넣기
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<Integer>();

        
        //인덱스 값이 n 보다 클 수 없음!
        while(index < n) {
            //비어있지 않고, 찾아내고 싶은 것보다 작아야함
            if(!stack.empty() && arr[index] < stack.get(stack.size() - 1)) {
                break;
                
            }else if(!stack.empty() && arr[index] == stack.get(stack.size() - 1)) {
                stack.pop();
                sb.append("-").append("\n");
                index++;
                
            
            }else {
                while(num <= n) {
                    if(arr[index] != num) {
                        stack.push(num);
                        sb.append("+").append("\n");
                        num++;
                    }else {
                        stack.push(num);
                        sb.append("+").append("\n");
                        num++;
                        break;
                    }
                }
            }
        }

        if(index == n) {
            System.out.println(sb);
        }else {
            System.out.println("NO");
        }
    }
}
