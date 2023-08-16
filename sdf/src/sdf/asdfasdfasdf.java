package sdf;

import java.io.*;
import java.util.Arrays;

public class asdfasdfasdf {
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
            stb.setLength(0);
            stb.append(arr);
            bw.write(stb + "\n");
            bw.flush();

        }
       
        bw.close();

    }



}