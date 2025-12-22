package com.kylericardo.algorithm.problems;

import java.io.*;

public class ZCY_009_QuickSort {

    public static int N = 50001;

    public static int[] arr = new int[N];

    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(System.out);
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                arr[i] = (int) in.nval;
            }
            quickSort2(0, n - 1);
            out.print(arr[0]);
            for (int i = 1; i < n; i++) {
                out.print(" " + arr[i]);
            }
            out.println();
        }
        out.flush();
        out.close();
    }

    public static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static int partition1(int l, int r, int x) {
        int a = l;
        int xi = 0;
        for (int i = l; i <= r; i++) {
            if (arr[i] <= x) {
                swap(a, i);
                if (arr[i] == x) {
                    xi = a;
                }
                a++;
            }
        }
        swap(xi, a - 1);
        return a - 1;
    }

    // 经典快排
    public static void quickSort1(int l, int r) {
        if (l >= r) {
            return;
        }
        int x = arr[l + (int) (Math.random() * (r - l + 1))];
        int a = partition1(l, r, x);
        quickSort1(l, a - 1);
        quickSort1(a + 1, r);
    }

    public static int first;
    public static int last;

    // 荷兰国旗问题
    public static void partition2(int l, int r, int x) {
        first = l;
        last = r;
        int i = l;
        while (i <= last) {
            if (arr[i] < x) {
                swap(first++, i++);
            } else if (arr[i] > x) {
                swap(last--, i);
            } else {
                i++;
            }
        }
    }

    // 使用荷兰国旗优化过的快排
    public static void quickSort2(int l, int r) {
        if (l >= r) {
            return;
        }
        int x = arr[l + (int) (Math.random() * (r - l + 1))];
        partition2(l, r, x);
        int left = first;
        int right = last;
        quickSort2(l, left - 1);
        quickSort2(right + 1, r);
    }

}
