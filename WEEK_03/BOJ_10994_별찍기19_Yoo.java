import java.util.*;

public class BOJ_10994_별찍기19_Yoo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		
		//한변에 들어가는 별 개수
		int real = 4*N-3;
		
		char[][] arr = new char[real][real];
		int idx = 0;

		// i는 N까지니까 돌아가는 번째 ex) 3 입력 3개사각형 4입력 4개사각형
		for (int A = 0; A < N; A++) {
			for (int i = idx; i < real - idx; i++) {
				arr[idx][i] = '*'; 				// 윗줄
				arr[real - idx - 1][i] = '*'; 	// 아랫줄
				arr[i][idx] = '*'; 				// 왼쪽
				arr[i][real - idx - 1] = '*'; 	// 오른쪽
			}
			idx+=2; //xy 좌표 2씩 줄어듬
		}
		
		//출력!
		for(int x=0; x<real; x++) {
			for(int y=0; y<real; y++) {
				if(arr[x][y]!='*') {
					arr[x][y]=' ';
				}
				System.out.print(arr[x][y]);
			}
			System.out.println();
		}
	}
}