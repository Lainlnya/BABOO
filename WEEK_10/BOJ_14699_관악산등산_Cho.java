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
		h[0][1] = Integer.MAX_VALUE; //
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			h[i][0] = i; // 쉼터 번호저장
			h[i][1] = Integer.parseInt(st.nextToken()); // 쉼터 높이 저장
		}
		ArrayList<Integer>[] E = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			E[i] = new ArrayList<>();
		// 위에서 아래방향으로만 저장할 예정
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int connect1 = Integer.parseInt(st.nextToken());
			int connect2 = Integer.parseInt(st.nextToken());
			if (h[connect1][1] > h[connect2][1])
				E[connect1].add(connect2);
			else
				E[connect2].add(connect1); //위에서 아래로 떨어지기 때문에 높이가 높은 곳에서만 저장
		}
		Arrays.sort(h, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o2[1] - o1[1];
			}

		});
		//먼저 저장하고 크기순으로 정렬(내림차순)
		int[] dp = new int[N + 1]; //dp용
		for (int i = 1; i <= N; i++) {
			int node = h[i][0];
			if (dp[node] ==0)
				dp[node] = 1; //맨 위 쉼터는 자기자신만 갈 수 있으므로 1
			for (int nNode : E[node])
				dp[nNode] = Math.max(dp[nNode], dp[node]+1);
			// 내려갈수록 더해줌 특정 쉼터에 갈 때 이미 저장된 값과 비교해서 큰거선택
		} // startN for
		for (int i = 1; i <=N; i++)
			sb.append(dp[i] + "\n");
		System.out.println(sb); 

	}
}
