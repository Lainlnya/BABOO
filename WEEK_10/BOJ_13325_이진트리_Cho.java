package BOJ_13325_Cho;

import java.util.Scanner;

public class BOJ_13325_이진트리_Cho {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int wSum = 0; //가중치 합
		int maxNum = (int) Math.pow(2, k+1); //전체 트리 깊이를 이용한 배열 크기 기록
		int[] weight = new int[maxNum]; //가중치 기록
		int[] dp = new int[maxNum]; //아래에서 위로올라가면서 가중치들 합 기록용
		for (int i = 2; i < maxNum; i++)
			weight[i] = sc.nextInt(); //받아오기
		for (int i = maxNum / 2; i < maxNum; i++)
			dp[i] = weight[i]; // 제일 깊은 곳에 있는 노드들에 해당하는 가중치 기록
		for (int i = maxNum / 2 - 1; i >= 1; i--) {
			dp[i] = weight[i]+ Math.max(dp[i * 2], dp[i * 2 + 1]); // 자기 아래 두 가중치 중 큰걸로 둘다 똑같이 만들어주어야 하므로 이렇게 기록
			wSum += Math.max(dp[i*2],  dp[i*2+1]); //제일 깊은곳까지 중 1개만 더함 // 다른 한개는 자동으로dp[1]에 누적되어 마지막에 더해줌
		}
		wSum += dp[1];
		System.out.println(wSum);
	}
}
