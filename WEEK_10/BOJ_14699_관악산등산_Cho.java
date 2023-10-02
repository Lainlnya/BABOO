package BOJ_14699_Cho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14699_관악산등산_Cho {
	static boolean[] visited;
	static int[][] h;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		h = new int[N + 1][2];
		h[0][1] = Integer.MAX_VALUE; // 내림차순 정렬할 것인데 0값이 거슬리므로 제일 큰값으로 반드시 맨 앞에 오도록 함
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			h[i][0] = i; // 쉼터 번호
			h[i][1] = Integer.parseInt(st.nextToken()); // 쉼터 위치 높이
		}
		ArrayList<Integer>[] E = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			E[i] = new ArrayList<>();
		//쉼터 높이 연결용
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int connect1 = Integer.parseInt(st.nextToken());
			int connect2 = Integer.parseInt(st.nextToken());
			if (h[connect1][1] > h[connect2][1])
				E[connect1].add(connect2);
			else
				E[connect2].add(connect1); // 더 높은곳에만 연결해놈 위에있을수록 dp 에서는불리
		}
		Arrays.sort(h, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o2[1] - o1[1];
			}

		});
		//내림차순으로 정리
		int[] dp = new int[N + 1]; //dp배열
		for (int i = 1; i <= N; i++) {
			int node = h[i][0];
			if (dp[node] ==0)
				dp[node] = 1; //시작지점이면 일단 1넣기
			for (int nNode : E[node])
				dp[nNode] = Math.max(dp[nNode], dp[node]+1);
			//연결된 노드로 가돼 이미 값이 있으면 비교해서 큰 값 남김 
		} // startN for
		for (int i = 1; i <=N; i++)
			sb.append(dp[i] + "\n");
		System.out.println(sb); 

	}
}
