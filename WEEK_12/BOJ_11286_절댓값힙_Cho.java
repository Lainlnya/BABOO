import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 절댓값힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> plus = new PriorityQueue<>();
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        //플러스 최소힙과 마이너스 최소힙 만들기
        for (int i = 0 ; i<N; i++) {
            int num = Integer.parseInt(bf.readLine());
            if (num >0) {
                plus.add(num);
            } else if (num <0) {
                minus.add(-num);

            } //플러스면 그대로 그냥 플러스 pq에 넣어주고, 마이너스면 절댓값 취한 값을 마이너스 pq에 넣어줌
            else {
                if (minus.isEmpty() && plus.isEmpty()) {
                    sb.append(0 + "\n");
                    //둘다 비었으면 0
                } else if (minus.isEmpty()) {
                    sb.append(plus.poll() + "\n");
                    //마이너스 비었으면 플러스 그냥 출력
                } else if (plus.isEmpty()) {
                    sb.append(-minus.poll() + "\n");
                    //플러스 비었으면 마이너스 그냥 출력
                } else {
                    if (minus.peek() <= plus.peek())
                        sb.append(-minus.poll()+"\n");
                    else {
                        sb.append(plus.poll()+"\n");
                    }
                    //둘다 차있는 상황에서는 비교해서 작은거 출력
                }
            }



        } //i for
        System.out.println(sb);
    }
}
