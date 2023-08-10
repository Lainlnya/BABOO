package WEEK_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_6580_QuadTree_kim {
    public static String[][] arr;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arrayRow = 0, arrayCol = 0; // row와 column 값 받기
        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken(); // 앞에 #define 
            st.nextToken(); // quadtree_width와 quadtree_height 생략을 위한 nextToken()
            // 첫번째는 width, 두 번째는 height
            if (i == 0) arrayRow = Integer.parseInt(st.nextToken());
            else arrayCol = Integer.parseInt(st.nextToken());
        }
        
        arr = new String[arrayRow][arrayCol];
        // static char quadtree_bits[] = { 생략
        String temp = br.readLine();

        for (int i = 0; i < arrayRow; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ",");
            String totalBin = "";
            String a = "";
            // 정수 arrayRow와 arraCol이 변할 수 있기 때문에 token이 있을 때까지 가져옴
            while(st.countTokens() > 0) {
            	// 들어온 값은 string -> integer -> BinaryString -> 8칸에 맞춰 나오도록 변경 -> 나머지 칸은 0으로 변경
            	a = String.format("%8s", Integer.toBinaryString(Integer.decode(st.nextToken()))).replaceAll(" ", "0");
            	// 순서를 반대로 바꾸기 위한 string buffer 선언
            	StringBuffer sf = new StringBuffer(a);
            	String reverseStr = sf.reverse().toString();
            	// totalBin에 변한 reverseStr 붙이기
            	totalBin = totalBin.concat(reverseStr);
            }
            
            arr[i] = totalBin.split("");
        }
        
        quadTree(0, 0, arrayRow);
        System.out.println(arrayRow);
        System.out.println(sb);
    }

    // 쿼드트리인지 확인하는 메서드
    public static void quadTree(int x, int y, int size) {
    	if (isSame(x, y, size)) {
            if (arr[x][y].equals("1")) {
                sb.append("B");
            } else if(arr[x][y].equals("0")){
                sb.append("W");
            }
            return;
        }
    	// 크기를 2분의 1으로 나누어 확인
        int newSize = size / 2;

        // 왼쪽 위
        quadTree(x, y, newSize);
        // 오른쪽 위
        quadTree(x, y + newSize, newSize);
        // 왼쪽 아래
        quadTree(x + newSize, y, newSize);
        // 오른쪽 아래
        quadTree(x + newSize, y + newSize, newSize);

    }

    // 같은지 아닌지 확인하는 메서드
    public static boolean isSame(int x, int y, int size) {
        String tmp = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
            	// 같지 않으면 "Q" 출력
                if (!tmp.equals(arr[i][j])) {
                    sb.append("Q");
                    return false;
                };
            }
        }
        return true;
    }
}
