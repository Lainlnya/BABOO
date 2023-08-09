package WEEK_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6580_QuadTree_kim {
    public static String[][] arr;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arrayRow = 0, arrayCol = 0;
        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            st.nextToken();
            if (i == 0) arrayRow = Integer.parseInt(st.nextToken());
            else arrayCol = Integer.parseInt(st.nextToken());
        }
        arr = new String[arrayRow][arrayCol];
        String temp = br.readLine();

        for (int i = 0; i < arrayRow; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ",");
            int first = Integer.decode(st.nextToken());
            int second = Integer.decode(st.nextToken());
            String firstS = String.format("%8s", Integer.toBinaryString(first)).replaceAll(" ", "0");
            String secondS = String.format("%8s", Integer.toBinaryString(second)).replaceAll(" ", "0");

            String a = firstS.concat(secondS);
            arr[i] = a.split("");
        }
        String temp2 = br.readLine();
        quadTree(0, 0, arrayRow);
        System.out.println(arrayRow);
        System.out.println(sb);
    }

    public static void quadTree(int x, int y, int size) {
        if (isSame(x, y, size)) {
            if (arr[x][y].equals("1")) {
                sb.append("W");
            } else if(arr[x][y].equals("0")){
                sb.append("B");
            }
            return;
        }
        int newSize = size / 2;

        quadTree(x, y, newSize);
        quadTree(x, y + newSize, newSize);
        quadTree(x + newSize, y, newSize);
        quadTree(x + newSize, y + newSize, newSize);

    }

    public static boolean isSame(int x, int y, int size) {
        String tmp = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (!tmp.equals(arr[i][j])) {
                    sb.append("Q");
                    return false;
                };
            }
        }
        return true;
    }
}
