package com.kylericardo.algorithm.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// 让数组整体累加和减半的最少操作次数
// 测试链接 : https://leetcode.cn/problems/minimum-operations-to-halve-array-sum/
public class ZCY_011_HalveArray {

    public static int halveArray(int[] nums) {
        PriorityQueue<Double> heap = new PriorityQueue<>(Comparator.reverseOrder());
        double sum = 0;
        for (int num : nums) {
            sum += num;
            heap.add((double) num);
        }
        sum /= 2;
        int ans = 0;
        for (double minus = 0, cur; minus < sum; minus += cur, ans++) {
            cur = heap.poll() / 2;
            heap.add(cur);
        }
        return ans;
    }

    public static int N = 100001;

    public static long[] heap = new long[N];

    public static int size;

    public static int halveArray2(int[] nums) {
        size = nums.length;
        long sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            heap[i] = (long) nums[i] << 20;
            sum += heap[i];
            heapify(i);
        }
        sum >>= 1;
        long minus = 0;
        int ans = 0;
        while (minus < sum) {
            heap[0] >>= 1;
            minus += heap[0];
            heapify(0);
            ans++;
        }
        return ans;
    }

    public static void swap(int a, int b) {
        long temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    public static void heapify(int i) {
        int l = (i << 1) + 1;
        while (l < size) {
            int best = l + 1 < size && heap[l + 1] > heap[l] ? l + 1 : l;
            best = heap[i] > heap[best] ? i : best;
            if (i == best) {
                break;
            }
            swap(i, best);
            i = best;
            l = (i << 1) + 1;
        }
    }

}
