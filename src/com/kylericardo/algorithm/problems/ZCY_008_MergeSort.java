package com.kylericardo.algorithm.problems;

import java.io.*;

// ACM 写法
// 测试链接：https://www.nowcoder.com/practice/bc25055fb97e4a0bb564cb4b214ffa92
public class ZCY_008_MergeSort {

    public static int N = 501;

    public static int[] arr = new int[N];

    public static int[] help = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(System.out);
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            int n = (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                arr[i] = (int) in.nval;
            }
            mergeSort(0, n - 1);
            out.print(arr[0]);
            for (int i = 1; i < n; i++) {
                out.print(" " + arr[i]);
            }
            out.println();
        }
        out.flush();
        out.close();
    }

    public static void mergeSort(int l, int r) {
        if (l == r) {
            return;
        }
        int m = l + ((r - l) >> 1);
        mergeSort(l, m);
        mergeSort(m + 1, r);
        merge(l, m, r);
    }

    public static void mergeSort2(int n) {
        for (int step = 1; step < n; step <<= 1) {
            for (int l = 0; l < n; l += (step << 1)) {
                int m = l + step - 1;
                int r = l + (step << 1) - 1;
                // 左右都有数才 merge
                if (m + 1 < n) {
                    r = Math.min(n - 1, r);
                    merge(l, m, r);
                }
            }
        }
    }

    public static void merge(int l, int m, int r) {
        int a = l;
        int i = l;
        int j = m + 1;
        while (i <= m && j <= r) {
            help[a++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= m) {
            help[a++] = arr[i++];
        }
        while (j <= r) {
            help[a++] = arr[j++];
        }
        for (a = l; a <= r; a++) {
            arr[a] = help[a];
        }
    }

}
