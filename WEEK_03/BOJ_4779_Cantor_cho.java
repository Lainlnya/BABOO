package WEEK_03;

import java.io.*;
import java.util.Arrays;

public class BOJ_4779_Cantor_cho {
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
            // 硫붾え由� 珥덇낵, �떆媛� 珥덇낵瑜� 留됯린 �쐞�빐, 誘몃━ 留뚮뱾�뼱�몦 2媛쒖쓽 String�쓣 �씠�슜�빐 �쟾遺� 怨꾩궛;
            stb.setLength(0);
            stb.append(arr);
            bw.write(stb + "\n");
            bw.flush();

        }
       
        bw.close();

    }



}