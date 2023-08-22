package WEEK_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20035_서강근육맨_Kim {
	static long[] lose; // 근손실 배열
	static long loseMin; // 배열 중 최솟값을 찾기 위한 변수
	static int equip; // 운동기구 개수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		equip = Integer.parseInt(br.readLine()); // 운동기구 개수
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		lose = new long[equip]; // 근손실 배열
		loseMin = Long.MIN_VALUE;
		
		for(int i = 0; i < lose.length; i++) { // 근손실 배열 넣기
			lose[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(lose); // 정렬
		findLose(); 
		System.out.println(loseMin);
		
	}
	
	// 최솟값을 찾기 위한 함수
	public static void findLose() {
		if (lose.length % 2 == 0) { // 짝수일 때
			for (int i = 0; i < (lose.length / 2) + 1; i++) {
				long temp = lose[i] + lose[lose.length - 1 - i];
				loseMin = Math.max(temp, loseMin);
			}
		} else { // 홀수 일 때
			loseMin = lose[equip - 1];
			for (int i = 0; i < (lose.length / 2) + 1; i++) {
				long temp = lose[i] + lose[lose.length - 2 - i];
				loseMin = Math.max(temp, loseMin);
			}
		}
	}
}
