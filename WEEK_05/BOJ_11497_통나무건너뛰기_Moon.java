package BOJ_11497_통나무건너뛰기;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {

            int N = sc.nextInt();
            int[] tree = new int[N];
            for (int i = 0; i < N; i++) {
                tree[i] = sc.nextInt();
            }
            
            Arrays.sort(tree); // 각 통나무의 높이를 오름차순으로 정렬
            
            int[] newTree = new int[N]; // 처음과 끝이 연결된 원형의 배열이라고 생각하고
            int p = 0; // 첫 번째 index랑
            int q = N-1; // 마지막 index에서부터
            int idx = 0;
            while (idx < N) {
            	// 번갈아가며 재배치한다. 그렇게 한다면 가장 큰 값의 원소는 배열의 중앙에 위치하게 된다.
                newTree[p] = tree[idx]; 
                p++;
                idx++;
                if (idx == N) break; // 만약 통나무의 수가 홀수라면 다음 index가 없을 것이므로 여기서 break해준다.
                newTree[q] = tree[idx];
                q--;
                idx++;
            }
            
            int level = 0; // 난이도
            int temp = 0;
            // 이웃하는 통나무끼리의 높이 차를 계산했을 때 가장 차이가 큰 곳의 높이차를 난이도로 설정한다.
            for (int i = 0; i < N; i++) {
                if (i == N-1) temp = Math.abs(newTree[0] - newTree[i]);
                else temp = Math.abs(newTree[i+1] - newTree[i]);
                if (temp > level) level = temp;
            }
            
            System.out.println(level);
            
        } // tc
        
        sc.close();
    }
}