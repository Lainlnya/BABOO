import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 크리스마스선물_Cho {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        //최대힙 생성
        for (int time = 0; time < T; time++) {
            st = new StringTokenizer(bf.readLine());

            while (st.hasMoreTokens()) {
                //받을게 더 없을때까지
                int now = Integer.parseInt(st.nextToken());
                //현 숫자 입력 받기
                if (now == 0) {
                    if (pq.isEmpty())
                        sb.append(-1 + "\n");
                    else
                        sb.append(pq.poll() + "\n");

                } // 0이면 하나 꺼내서 출력 만약 queue가 비어있으면 -1 출력
                else {
                    for (int a = 0 ; a < now ; a++) {

                        pq.add(Integer.parseInt(st.nextToken()));
                    }

                } //아니면 pq에 채워넣기 선물
            }

        } //time for
        System.out.println(sb);
    }
}
