package WEEK_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_24060_MergeSort_kim {
    public static int[] temp;
    public static int findNum;
    public static int num = 0;
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int totalNum = Integer.parseInt(st.nextToken());
        findNum = Integer.parseInt(st.nextToken());
        int[] mergeArr = new int[totalNum];
        temp = new int[totalNum];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < totalNum; i++) {
            mergeArr[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(mergeArr, 0, mergeArr.length - 1);
        if (num < findNum) {
            System.out.println(-1);
        } else System.out.println(answer);
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) >> 1;
            mergeSort(arr, left, mid);
            mergeSort(arr,mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right){
        int i = left, j = mid + 1, t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = arr[i++];
        }

        while (j <= right) {
            temp[t++] = arr[j++];
        }

        i = left; t = 0;
        
        while (i <= right) {
            num++;
            if (num == findNum) {
                answer = temp[t];
            }
            arr[i++] = temp[t++];
        }
    }
}
