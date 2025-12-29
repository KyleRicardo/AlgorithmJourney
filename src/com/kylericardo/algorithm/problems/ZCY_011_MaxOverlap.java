package com.kylericardo.algorithm.problems;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

// 线段最多重合数问题
// https://www.nowcoder.com/practice/1ae8d0b6bb4e4bcdbf64ec491f63fc37
public class ZCY_011_MaxOverlap {

    public static int N = 10001;

    public static int[][] line = new int[N][2];

    public static int[] heap = new int[N];

    public static int n;

    public static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(System.out);
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                line[i][0] = (int) in.nval;
                in.nextToken();
                line[i][1] = (int) in.nval;
            }
            int ans = getMaxOverlap();
            out.println(ans);
        }
        out.flush();
        out.close();
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void heapInsert(int[] arr, int num) {
        arr[size++] = num;
        int cur = size - 1;
        int p = (cur - 1) >> 1;
        while (p >= 0 && arr[p] > num) {
            swap(arr, cur, p);
            cur = p;
            p = (cur - 1) >> 1;
        }
    }

    public static void heapify(int[] arr, int x) {
        int l = (x << 1) + 1;
        while (l < size) {
            int best = l + 1 < size && arr[l + 1] < arr[l] ? l + 1 : l;
            best = arr[x] < arr[best] ? x : best;
            if (best == x) {
                break;
            }
            swap(arr, x, best);
            x = best;
            l = (x << 1) + 1;
        }
    }

    public static int getMaxOverlap() {
        size = 0;

        Arrays.sort(line, 0, n, Comparator.comparingInt(a -> a[0]));
        int max = 0;
        for (int i = 0; i < n; i++) {
            while (size > 0 && heap[0] <= line[i][0]) {
                swap(heap, 0, --size);
                heapify(heap, 0);
            }
            heapInsert(heap, line[i][1]);
            max = Math.max(max, size);
        }
        return max;
    }

}
