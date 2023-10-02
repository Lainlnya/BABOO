package BOJ_13325_Cho;

import java.util.Scanner;

public class BOJ_13325_이진트리_Cho {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int wSum = 0; //가중치합 저장용
		int maxNum = (int) Math.pow(2, k+1); //트리크기를 통한 배열 만들기
		int[] weight = new int[maxNum]; //가중치
		int[] dp = new int[maxNum]; //트리 dp 아래것 가중치를 더한거
		for (int i = 2; i < maxNum; i++)
			weight[i] = sc.nextInt(); //입력끝
		for (int i = maxNum / 2; i < maxNum; i++)
			dp[i] = weight[i]; // 트리 맨 아래부분은 dp에 바로 저장
		for (int i = maxNum / 2 - 1; i >= 1; i--) {
			dp[i] = weight[i]+ Math.max(dp[i * 2], dp[i * 2 + 1]); // 트리 윗 부분은 밑의 가지 중 큰 값 + 가중치
			wSum += Math.max(dp[i*2],  dp[i*2+1]); //가중치에 저장 마지막에 dp[1]을 더해주면 모든 가중치의 합이 됨
		}
		wSum += dp[1];
		System.out.println(wSum);
	}
}
