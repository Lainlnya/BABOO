package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470_Cho {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int pIdx = -1;
		int mIdx = -1;
		int[] plus = new int[N];
		int[] minus = new int[N];
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num >= 0)
				plus[++pIdx] = num;
			else
				minus[++mIdx] = num;
		}
		// mIdx, pIdx가 배열의 끝값을 가리키도록 보정
		// 플러스는 plus배열에 마이너스 값은 minus 배열에 담기
		if (pIdx >= 1)
			Arrays.sort(plus, 0, pIdx +1);
		if (mIdx >= 1)
			Arrays.sort(minus, 0, mIdx +1);
		// 플마 따로 정렬 놀랍게도 앞에 문제는 정렬이 필요없어서 맞았음 앞에것도 고쳤음
		int mArr[] = new int[2];
		// 두 용액 담을 그릇 만들기
		Arrays.fill(mArr, 1000000001);
		if (pIdx >= 1) {
			mArr = near(mArr, plus[0], plus[1]);
		}
		if (mIdx >= 1) {
			mArr = near(mArr, minus[mIdx - 1], minus[mIdx]);
		}
		if (pIdx >= 0 && mIdx >= 0) {
			mArr = near(mArr, plus[pIdx], minus[0]);
			mArr = near(mArr, plus[0], minus[mIdx]);			
		}
		

		// 마지막 예외처리용 - 2개, +2개 더한 값과, +- 양 끝값 더한값도 비교
		int mUpperIdx = 0; // 오름차순 이기에 가장작은게(- 가 가장 큰게) 0번에 위치함
		// 그래서 올라가면서 체크해야해서 새롭게 변수 만듬
		while (pIdx > 0 || mUpperIdx < mIdx) {
			if (pIdx == -1 || mIdx == -1)
				break;
		 // 둘중 하나의 배열이 비어있다면 의미 없으므로 바로 탈출
			mArr = near(mArr, plus[pIdx], minus[mUpperIdx]);
			if (pIdx == 0) {
				mUpperIdx++;
				continue;
			}
			
			if (mUpperIdx == mIdx) {

				pIdx--;
				continue;
			} //하나가 이미 끝에 도달했다면 다른 하나만 계속 변경

			if (plus[pIdx] + minus[mUpperIdx] >= 0) {
				pIdx--;
				continue;
			} else {
				mUpperIdx++;
				continue;
			} //그게 아니라면 비교해서 +쪽이 더 컸다면(절대값이) +줄이기  -가 더 컸다면 - 줄이기

		}
		Arrays.sort(mArr);
		for (int i = 0; i < 2; i++) {
			System.out.print(mArr[i] + " ");

		}

	}

	static int[] near(int[] near, int a, int b) {
		if (Math.abs(near[0] + near[1]) > Math.abs(a + b))
			return new int[] { a, b };
		else
			return near;
	} // 비교용 새롭게 나온 두 숫자가 전보다 작으면 그 배열 반환
}
