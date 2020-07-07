package team.wble.practice;

import java.util.EmptyStackException;

/**
 * 用数组实现一个固定大小的栈
 *
 * @author Kyle
 */
public class ArrayStack {

    private int index;
    private int[] arr;

    public ArrayStack(int initSize) {
        if (initSize < 1) {
            throw new IllegalArgumentException("容量不能小于1");
        }
        arr = new int[initSize];
    }

    public void push(int value) {
        if (index == arr.length) {
            throw new ArrayIndexOutOfBoundsException("已超出栈的最大容量");
        }
        arr[index++] = value;
    }

    public int pop() {
        if (index == 0) {
            throw new EmptyStackException();
        }
        return arr[--index];
    }

    public int peek() {
        if (index == 0) {
            throw new EmptyStackException();
        }
        return arr[index - 1];
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public int size() {
        return index;
    }

}
