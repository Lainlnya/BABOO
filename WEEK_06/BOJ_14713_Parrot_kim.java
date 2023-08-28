package WEEK_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 25m
public class BOJ_14713_Parrot_kim {
    static List<Queue<String>> parrot;
    static int total;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int senN = Integer.parseInt(br.readLine());
        parrot = new ArrayList<>();
        total = 0;

        for (int i = 0; i < senN; i++) {
            String[] temp = br.readLine().split(" ");
            Queue<String> sample = new LinkedList<>();
            for (int j = 0; j < temp.length; j++) {
                sample.add(temp[j]);
            }
            parrot.add(sample);
            total += sample.size();
        }

        String[] parrotSay = br.readLine().split(" ");

        if (parrotSay.length != total) {
            System.out.println("Impossible");
            return;
        }

        for (int i = 0; i < parrotSay.length; i++) {
            for (int j = 0; j < parrot.size(); j++) {
                if (parrotSay[i].equals(parrot.get(j).peek())) {
                    parrot.get(j).poll();
                }
            }
        }

        for (int i = 0; i < parrot.size(); i++) {
            if (!parrot.get(i).isEmpty()) {
                System.out.println("Impossible");
                return;
            }
        }

        System.out.println("Possible");
    }
}
