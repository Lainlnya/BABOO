package asdf;

import java.util.Scanner;

public class 옥상정원꾸미기 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//층 수
		int N = sc.nextInt();
		
		// 층 저장할 배열 생성
		int [] arr = new int [N];
		
		for(int i =0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		//빌딩높이 최대 10억 이므로 long !
		long ans =0; 
		
		//탈출시키기 위한 f1 지정
		f1 : for(int i=0; i<N; i++) {
			//앞에서부터 하나씩 선택하며 완전탐색
			int select = arr[i];
			
			for(int j=i+1; j<N; j++) {
				//높은거 찾으면 ans++
				if(arr[j]<select) {
					ans++;
				}
				//같거나 큰 빌딩 만나면 f1으로 탈출해서 다음칸 빌딩 계산
				else {
				continue f1;
				}
			}
		}
		System.out.println(ans);
	}
}