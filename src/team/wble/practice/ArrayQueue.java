package team.wble.practice;

/**
 * 用数组实现一个固定大小的队列
 *
 * @author Kyle
 */
public class ArrayQueue {

    private int[] arr;
    private int start;
    private int end;
    private int size;

    public ArrayQueue(int initSize) {
        if (initSize < 1) {
            throw new IllegalArgumentException("容量不能小于1");
        }
        arr = new int[initSize];
    }

    public void push(int value) {
        if (size == arr.length) {
            throw new ArrayIndexOutOfBoundsException("已超出最大容量");
        }
        arr[start++] = value;
        size++;
        start = start == arr.length ? 0 : start;
    }

    public int poll() {
        if (size == 0) {
            throw new RuntimeException("队列为空");
        }
        size--;
        int tmp = end;
        end = end + 1 == arr.length ? 0 : end;
        return arr[tmp];
    }

    public int peek() {
        if (size == 0) {
            throw new RuntimeException("队列为空");
        }
        return arr[end];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

}
