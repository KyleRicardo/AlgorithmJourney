package com.kylericardo.algorithm.problems;

import java.util.*;

// https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
public class ZCY_035_RandomizedSetWithDuplicateValueAllowed {

    class RandomizedCollection {

        private Map<Integer, Set<Integer>> map;
        private List<Integer> list;

        public RandomizedCollection() {
            this.map = new HashMap<>();
            this.list = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                map.get(val).add(list.size());
                list.add(val);
                return false;
            }
            Set<Integer> set = new HashSet<>();
            set.add(list.size());
            list.add(val);
            map.put(val, set);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int endVal = list.getLast();
            Set<Integer> set = map.get(val);
            if (val == endVal) {
                set.remove(list.size() - 1);
            } else {
                int index = set.iterator().next();
                set.remove(index);
                map.get(endVal).remove(list.size() - 1);
                map.get(endVal).add(index);
                list.set(index, endVal);
            }
            list.removeLast();
            if (set.isEmpty()) {
                map.remove(val);
            }
            return true;
        }

        public int getRandom() {
            int n = (int) (Math.random() * list.size());
            return list.get(n);
        }

    }

}
