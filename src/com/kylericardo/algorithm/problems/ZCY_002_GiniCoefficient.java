package com.kylericardo.algorithm.problems;

import java.util.Arrays;

/*
一个有趣的实验

一开始有100人，每个人都有100元
在每一轮都做如下的事情：
每个人都必须拿出1元钱给除自己以外的其他人，给谁完全随机
如果某个人在这一轮开始时钱数为0，那么他可以不给，但是可以接收
发生很多很多轮之后，这100人的社会财富分布很均匀吗？
 */
public class ZCY_002_GiniCoefficient {

    public static void main(String[] args) {
        // 人数
        int n = 100;
        // 实验轮数
        int t = 1000000;

        System.out.println("人数：" + n);
        System.out.println("轮数：" + t);
        experiment(n, t);
        System.out.println("实验结束");
    }

    private static void experiment(int n, int t) {
        int[] wealth = new int[n];
        Arrays.fill(wealth, 100);
        boolean[] hasMoney = new boolean[n];

        for(int i = 0; i < t; i++) {
            Arrays.fill(hasMoney, true);
            for(int j = 0; j < n; j++) {
                if (wealth[j] == 0) {
                    hasMoney[j] = false;
                }
            }
            for(int j = 0; j < n; j++) {
                if(hasMoney[j]) {
                    int other;
                    do {
                        other = (int)(Math.random() * n);
                    } while(other == j);
                    wealth[j]--;
                    wealth[other]++;
                }
            }
        }

        double sumOfDifferences = 0;
        double sumOfMoney = 0;
        for(int i = 0; i < n; i++) {
            sumOfMoney += wealth[i];
            for(int j = 0; j < n; j++) {
                sumOfDifferences += Math.abs(wealth[j] - wealth[i]);
            }
        }
        double giniCoefficient = sumOfDifferences / (2 * n * sumOfMoney);
        Arrays.sort(wealth);
        for(int i = 0; i < n; i++) {
            System.out.print(wealth[i] + "\t");
            if(i % 10 == 9) {
                System.out.println();
            }
        }
        System.out.println("基尼系数为: " + giniCoefficient);
    }
}
