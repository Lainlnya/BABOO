package WEEK_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] tmpArr = new int[4];

	static int[] dI = { 0, 1, 0, 1 };
	static int[] dJ = { 0, 0, 1, 1 };
// 계속 쓰이는 부분 메모리 초과, 시간 초과에 의해 미리 선언
	public static void main(String[] args) throws IOException {
		StringBuilder stb = new StringBuilder();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 시간 단축을 위한 버퍼로 불러오기
		int N = Integer.parseInt(br.readLine());

		int[][] price = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				price[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//2차원 배열에 번호 받아오기

		br.close();
		
		while( N >=1) {
			N = N/2;
			for (int i = 0 ; i < N ;i++) {
				for (int j = 0 ; j < N ; j++) {
					price[i][j] = S(price, i*2, j*2);
				}
			}
			//재귀 사용 bottom-up, 공간을 줄여나가면서 계산
			//메모리를 줄이기 위해 2차원 배열인 price에 재할당;
			
		}


		System.out.println(price[0][0]);
	}
	
	public static int S(int[][] price, int i , int j) {
		
		int mMin = Integer.MAX_VALUE;
		int secondMin = Integer.MAX_VALUE;
		for (int a = 0; a < 4; a++) {
			tmpArr[a] = price[i + dI[a]][j + dJ[a]];
			if (mMin > tmpArr[a])
				mMin = tmpArr[a];
		}
		for (int a = 0; a < 4; a++) {
			if (tmpArr[a] != mMin && secondMin > tmpArr[a])
				secondMin = tmpArr[a];
		}
		
		return secondMin;
	}
	//sort에 문제가 있나 싶어 만든 두번째로 작은 값을 뽑는 메소드;
	
}