package com.kylericardo.algorithm.problems;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

// setAll功能的哈希表
// 测试链接 : https://www.nowcoder.com/practice/7c4559f138e74ceb9ba57d76fd169967
public class ZCY_035_SetAllHashMap {

    private static Map<Integer, int[]> map;
    private static int stamp;
    private static int lastSetAllStamp;
    private static int lastSetAllValue;

    public static void put(int key, int val) {
        map.put(key, new int[]{val, stamp++});
    }

    public static int get(int key) {
        if (!containsKey(key)) {
            return -1;
        }
        int[] val = map.get(key);
        if (val[1] < lastSetAllStamp) {
            return lastSetAllValue;
        } else {
            return val[0];
        }
    }

    public static boolean containsKey(int key) {
        return map.containsKey(key);
    }

    public static void setAll(int val) {
        lastSetAllStamp = stamp++;
        lastSetAllValue = val;
    }

    private static int n, op, a, b;

    public static void main(String[] args) throws IOException {
        map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            map.clear();
            stamp = 0;
            lastSetAllStamp = -1;
            n = (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                op = (int) in.nval;
                if (op == 1) {
                    in.nextToken();
                    a = (int) in.nval;
                    in.nextToken();
                    b = (int) in.nval;
                    put(a, b);
                } else if (op == 2) {
                    in.nextToken();
                    a = (int) in.nval;
                    out.println(get(a));
                } else if (op == 3) {
                    in.nextToken();
                    a = (int) in.nval;
                    setAll(a);
                }
            }
        }
        out.flush();
        out.close();
        br.close();
    }

}
