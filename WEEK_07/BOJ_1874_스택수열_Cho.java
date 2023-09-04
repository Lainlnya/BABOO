import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;


import java.io.BufferedWriter;
        import java.io.IOException;
        import java.io.OutputStreamWriter;
        import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<Integer>();
        int[] targetArr = new int[N];
        for (int i = 0; i <N ; i++) {
            targetArr[i] = sc.nextInt();
        } //만들고자하는 배열 받아오기
        int idx = 0;
        int num = 1; //초기값 설정
        stack.push(num++); //1부터 차례대로 넣어준다는점 이용 처음에 stack이 비어있으므로 1개 넣음
        sb.append("+\n"); // 1개 넣었으므로 + 처음 출력은 고정
        //스택이 비어있는경우 방지용 스택에 숫자넣어두기
        while(num <=N ) {
            if(stack.isEmpty()) {
                stack.push(num++);
                sb.append("+\n"); // 숫자가 아직 넣을게 남아있다면 stack이 빌시 바로바로 넣음
            }
            if (stack.peek() == targetArr[idx]) {
                idx++;
                stack.pop();
                sb.append("-\n"); //맨위가 타겟과 같으면 바로 뽑아냄
            }
            else if (stack.peek() < targetArr[idx]) {
                stack.push(num++);
                sb.append("+\n");
            } //맨위가 타겟보다 작으면 타겟과 같아질때까지 push함
            else { //스택내부는 항상 오름차순이므로 스택의 맨위보다 타겟이 작을 경우 뽑을 방법이 없음.
                System.out.println("NO");
                System.exit(0);
            }
        }
        while(!stack.isEmpty()) {
            if (stack.peek() == targetArr[idx++]){
                stack.pop();
                sb.append("-\n"); // 맨 끝번호까지 stack에 넣으면 이제 빼는것밖에할수없다.
            } else {
                System.out.println("NO");
                System.exit(0); //다른게 나오면 실패
            }

        }

        System.out.println(sb); //이모든과정을 통과했으면 sb에 모아놓은거 print




    }
}
