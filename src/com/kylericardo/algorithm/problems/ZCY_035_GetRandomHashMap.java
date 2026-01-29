package com.kylericardo.algorithm.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 测试链接 : https://leetcode.com/problems/insert-delete-getrandom-o1/
public class ZCY_035_GetRandomHashMap {

    class RandomizedSet {

        private Map<Integer, Integer> map;
        private List<Integer> list;

        public RandomizedSet() {
            this.map = new HashMap<>();
            this.list = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int index = map.get(val);
            int endVal = list.getLast();
            list.set(index, endVal);
            map.put(endVal, index);
            list.removeLast();
            map.remove(val);
            return true;
        }

        public int getRandom() {
            int n = (int) (Math.random() * list.size());
            return list.get(n);
        }

    }

}
