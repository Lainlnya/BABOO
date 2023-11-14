import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] remainN = new int[N+1];

        //남은 선행 빌드 개수
        int[] time = new int[N+1];
        int[] fTime = new int[N+1];
        //빌드 시간과 완전히 끝나는 시간 기록 배열
        Queue<Integer> queue = new LinkedList<>();
        // 끝나는 거 기록용 queue 생성
        StringTokenizer st = null;

        ArrayList<Integer>[] nB = new ArrayList[N+1];
        for (int i = 0 ; i <=N ; i++)
            nB[i] = new ArrayList<>();
        //자기가 지어져야 지을 수 있는 건문들 기록용 어레이리스트
        for (int idx =1 ; idx <=N ; idx++) {
            st = new StringTokenizer(bf.readLine());
            time[idx] = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {

                int nIdx = Integer.parseInt(st.nextToken());
                if (nIdx == -1) {
                    if (remainN[idx] ==0 ) {
                        fTime[idx] = time[idx];
                        queue.add(idx);

                    }
                    break;
                }
                remainN[idx]++;
                nB[nIdx].add(idx);
            }
        }
        while (!queue.isEmpty()) {
            int nIdx = queue.poll();
            for (int idx : nB[nIdx]) {
                remainN[idx]--;
                fTime[idx] = Math.max(fTime[idx], fTime[nIdx]);
                //본인 지음으로써 본인을 선행 건물로 하는 건물들 다 remainN--
                //자기 완성된 시간과 본인을 선행 건물로 하는 건물들의 현재 최대시간 비교해서 갱신
                if (remainN[idx] == 0) {
                    fTime[idx] += time[idx];
                    queue.add(idx);
                } //선행빌드 클리어시 가장 오래 걸린 건물 + 자기 짓는 시간 fTime 저장, 자기자신 queue에 넣기
            }
        } // while	





        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <=N ; i++) {
            sb.append(fTime[i] + "\n");
        }
        System.out.println(sb);
    }
}