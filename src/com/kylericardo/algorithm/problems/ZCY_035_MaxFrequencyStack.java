package com.kylericardo.algorithm.problems;

import java.util.*;

// 测试链接 : https://leetcode.com/problems/maximum-frequency-stack/
public class ZCY_035_MaxFrequencyStack {

    class FreqStack {

        private Map<Integer, List<Integer>> stack;
        private Map<Integer, Integer> map;
        private int maxFrequency;

        public FreqStack() {
            this.stack = new HashMap<>();
            this.map = new HashMap<>();
            this.maxFrequency = 0;
        }

        public void push(int val) {
            int level = map.getOrDefault(val, 0) + 1;
            List<Integer> arr = stack.getOrDefault(level, new ArrayList<>());
            arr.add(val);
            if (!stack.containsKey(level)) {
                stack.put(level, arr);
            }
            map.put(val, level);
            maxFrequency = Math.max(maxFrequency, level);
        }

        public int pop() {
            List<Integer> arr = stack.get(maxFrequency);
            int ans = arr.removeLast();
            if (arr.isEmpty()) {
                stack.remove(maxFrequency--);
            }
            int level = map.get(ans);
            if (level == 1) {
                map.remove(ans);
            } else {
                map.put(ans, level - 1);
            }
            return ans;
        }
    }

}
