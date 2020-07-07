package team.wble.util;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * 对数器工具类
 *
 * @author Kyle Ricardo
 */
public class JudgeUtils {

    private JudgeUtils() {}

    /**
     * 随机数组发生器
     *
     * @param size 数组大小
     * @param rangeMax 范围最大值
     * @return 生成的随机数组
     */
    public static int[] generateRandomArray(int size, int rangeMax) {
        if (size < 1 || rangeMax < 0) {
            throw new IllegalArgumentException("参数不正确");
        }
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((rangeMax + 1) * Math.random());
        }

        return arr;
    }

    public static int[] copyArray(int[] source) {
        if (source == null) {
            return null;
        }
        int[] dst = new int[source.length];
        for (int i = 0; i < source.length; i++) {
            dst[i] = source[i];
        }
        return dst;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1 != null && arr2 != null && arr1.length == arr2.length) {
            boolean equal = true;
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) {
                    equal = false;
                    break;
                }
            }
            return equal;
        }
        return false;
    }

    public static boolean check(Consumer<int[]> sortAlgorithm) {
        boolean success = true;
        for (int i = 0; i < 500000; i++) {
            int[] arr = JudgeUtils.generateRandomArray(10, 10);
            int[] arr1 = JudgeUtils.copyArray(arr);
            int[] arr2 = JudgeUtils.copyArray(arr);
            Arrays.sort(arr1);
            sortAlgorithm.accept(arr2);
            if (!JudgeUtils.isEqual(arr1, arr2)) {
                System.out.println(Arrays.toString(arr));
                System.out.println(Arrays.toString(arr1));
                System.out.println(Arrays.toString(arr2));
                success = false;
                break;
            }
        }
        System.out.println(success ? "Nice!" : "Fucking fucked!");
        return success;
    }






}
