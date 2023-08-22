package WEEK_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11497_통나무건너뛰기_Kim {
	static int[] tree;  // 통나무 배열
	static int[] changeTree; // 바꿀 통나무 배열
	static int maxValue; // 최소 난이도를 구하기 위한 변수 선언
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()); // 테스트 케이스

        for (int t = 0;  t < tc; t++) {
            int num = Integer.parseInt(br.readLine());
            tree = new int[num];
            changeTree = new int[tree.length];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < tree.length; i++) { // 통나무 입력
                tree[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(tree); // 일단 통나무 오름차순 정렬
            treeSort(); // 인접 값이 가장 적게 나오게 하기 위한 정렬
            System.out.println(getMin()); // 최소 난이도 출력

        } // 테케 끝
        
	}
	
	// 통나무 인접 값이 가장 낮게 만드는 함수
	public static void treeSort() {
        if (tree.length % 2 == 1) { // length가 홀수일 경우
            changeTree[0] = tree[tree.length - 1];
            int len = tree.length - 2; // 5
            int j = 1;
            while (len >= 0) {
                changeTree[j] = tree[len--];
                changeTree[tree.length - j] = tree[len--];
                j++;
            }
        } else {
            int len = tree.length - 1;
            int j = 0;
            while (len >= 0) {
                changeTree[j] = tree[len--];
                changeTree[tree.length - 1 - j] = tree[len--];
                j++;
            }
        }
	}
	
	// 최소난이도를 구하는 함수
	public static int getMin() {
        int maxValue = 0;
        for (int i = 1; i < changeTree.length; i++) {
            int tempMax = Math.abs(changeTree[i - 1] - changeTree[i]);
            if (tempMax > maxValue) {
                maxValue = tempMax;
            }
        }
        
        // 마지막은 반복문으로 계산하기 어렵기 때문에 배열의 index 마지막 + 처음 값을 더한 abs를 구한다.
        int lastValue = Math.abs(changeTree[changeTree.length - 1] - changeTree[0]);
        maxValue = lastValue > maxValue ? lastValue : maxValue;
        
        return maxValue;
	}
}
