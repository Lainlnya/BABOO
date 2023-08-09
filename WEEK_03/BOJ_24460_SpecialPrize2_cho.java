package WEEK_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		 StringBuilder stb = new StringBuilder();

	     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int N = Integer.parseInt(br.readLine());
		 
		 int[][] price = new int[N][N];
		for (int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < N ; j++) {
				price[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		
		int m = N;
		int count2= 0;
		while ( m >1) {
			m = m/2;
			count2++;
		}
		
		
		System.out.println(S(count2, 0, 0, price));
		
		

	}
	
	
	
	public static int S(int N, int i, int j, int[][] price) {
		int result = 0;
		int plus = (int)Math.pow(2, N-1);
		int[] dI = {0, 1, 0, 1};
		int[] dJ = {0, 0, 1, 1};
		
		
		
		if (N == 1) {
			
			
			
			
			int[] tmpArr = {price[i][j], price[i+1][j], price[i][j+1], price[i+1][j+1]};
//			for(int a = 0 ; a < 4; a++) {
//				System.out.println(tmpArr[a]);
//			}
			
			
			Arrays.sort(tmpArr);
			result = tmpArr[1];
			}
		else {
			
			int[] tmpArr = new int[4];
			for(int k = 0 ; k < 4 ; k++) {
				tmpArr[k] = S(N-1, i+dI[k]*plus, j+dJ[k]*plus, price);
			}
			Arrays.sort(tmpArr);
			result = tmpArr[1];
			
			
			
			
		}
		
		
		
		return result;
	}
}

// 초기 발상 및 재귀 사용