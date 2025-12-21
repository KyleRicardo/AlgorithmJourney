package com.kylericardo.algorithm.problems;

import java.io.*;

// 测试链接 : https://www.nowcoder.com/practice/edfe05a1d45c4ea89101d936cac32469
public class ZCY_008_SmallSum {

    public static int N = 100001;

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
            long ans = smallSum(0, n - 1);
            out.println(ans);
        }
        out.flush();
        out.close();
    }

    public static long smallSum(int l, int r) {
        if (l == r) {
            return 0;
        }
        int m = l + ((r - l) >> 1);
        return smallSum(l, m) + smallSum(m + 1, r) + merge(l, m, r);
    }

    public static long merge(int l, int m, int r) {
        long ans = 0;
        // 注意 sum = 0 初始化不能写在 for 里面
        for(int i = l, j = m + 1, sum = 0; j <= r; j++) {
            while(i <= m && arr[i] <= arr[j]) {
                sum += arr[i++];
            }
            ans += sum;
        }
        int a = l;
        int i = l;
        int j = m + 1;
        while (i <= m && j <= r) {
            help[a++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while(i <= m) {
            help[a++] = arr[i++];
        }
        while(j <= r) {
            help[a++] = arr[j++];
        }
        for(a = l; a <= r; a++) {
            arr[a] = help[a];
        }
        return ans;
    }

}
