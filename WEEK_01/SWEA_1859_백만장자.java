package swea_백만;

import java.util.Scanner;

public class 백만장자프로젝트 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int T = sc.nextInt();  // TestCase
		
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt(); //숫자 개수 =배열크기
			int benefit=0;
			int max_value=0;
			int[] arr=new int[N];
			
			// 배열완료
			for (int j = 0; j < N; j++) {
				arr[j]=sc.nextInt();
			}
			// 반대로 탐색
			for (int j = N-1; j >=0; j--) {				
				if(arr[j]>max_value)
				max_value=arr[j];
				benefit+=max_value-arr[j];
			}
			System.out.printf("#%d %d\n",i+1,benefit);
		}
	}
}