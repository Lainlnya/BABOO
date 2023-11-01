package 용액;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int [] arr= new int [N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		//시작과 끝 인덱스
		int start = 0;
		int end = N-1;
		
		//답이 될 용액 두개
		int ans1 = 0;
		int ans2 = 0;
		
		//최대값으로 초기 설정
		int min = Integer.MAX_VALUE;
		
		//투포인터에서 앞 인덱스가 뒤 인덱스랑 같아지면 끝!
		while (start<end) {
			int check = Math.abs(arr[start]+arr[end]);
			
			//최소값 갱신, 답 저장
			if(check<min) {
				min = check;
				ans1 = arr[start];
				ans2 = arr[end];
			}
			
			if(check==0) {
				break;
			}
			
			// 최대한 0에 가깝게 하는 부분
			// 더했는데 0보다 크면 오른쪽(큰 값) 을 줄여줘야겠죠?  
			// 음수면 최소값을 줄여줘야겠죠
			if(arr[start]+arr[end]>0) {
				end--;
			}
			else {
				start++;
			}
		}
		System.out.println(ans1+" "+ans2);
		
	}
}
