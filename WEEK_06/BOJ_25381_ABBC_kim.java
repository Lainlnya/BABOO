package WEEK_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 50m
public class BOJ_25381_ABBC_kim {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] sentence = br.readLine().toCharArray();
        // 각 알파벳의 index 번호가 들어갈 queue
        Queue<Integer> putA = new LinkedList<>();
        Queue<Integer> putB = new LinkedList<>();
        int answer = 0;

        for (int i = 0; i < sentence.length; i++) {
            switch (sentence[i]) {
                case 'A' :
                    putA.offer(i);
                    break;
                case 'B' :
                    putB.offer(i);
                    break;
                case 'C' :
                    if (putB.size() > 0 && putB.peek() < i) { // B에 B가 있고, B의 index보다 c의 index가 클 때
                        answer++;
                        putB.poll(); // B 사용했으므로 빼내기
                    }
                    break;
            }
        }

        while (!putA.isEmpty() && !putB.isEmpty()) { // A랑 비교
            if (putA.peek() < putB.peek()) { // A는 항상 B보다 앞에 있어야 하므로 확인
                answer++;
                putB.poll(); putA.poll(); // 다 사용하면 빼내기
            } else {
                putB.poll();
            }
        }

        System.out.println(answer);
    }
}
