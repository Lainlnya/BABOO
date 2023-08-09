package WEEK_03;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        StringBuilder stb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String st;

        while ((st = br.readLine()) != null && !st.isEmpty()) {
            int N = Integer.parseInt(st);
            
            String arr = "-";
            String blank = " ";
            for (int i = 1; i <= N ; i++ ) {
            	arr = arr + blank + arr;
            	blank = blank + blank +blank;
            }
            // 메모리 초과, 시간 초과를 막기 위해, 미리 만들어둔 2개의 String을 이용해 전부 계산;
            stb.setLength(0);
            stb.append(arr);
            bw.write(stb + "\n");
            bw.flush();

        }
       
        bw.close();

    }



}