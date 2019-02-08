package com.codecool.dynamicArrayDojo;

import java.util.Arrays;

public class DynamicIntArray {

    private int[] dynamicIntArray;
    private int lastElementIndex;

    public DynamicIntArray() {
        dynamicIntArray = new int[10];
        lastElementIndex = -1;
    }

    public DynamicIntArray(int length) {
        dynamicIntArray = new int[Math.max(length, 10)];
        lastElementIndex = -1;
    }

    public void add(int newElement) {
        int containerArrayLength = dynamicIntArray.length;
        if (lastElementIndex + 1 == containerArrayLength) {
            int[] temp = Arrays.copyOf(dynamicIntArray, lastElementIndex + 1);
            dynamicIntArray = new int[containerArrayLength * 2];
            System.arraycopy(temp, 0, dynamicIntArray, 0, lastElementIndex + 1);
        }
        dynamicIntArray[++lastElementIndex] = newElement;
    }

    public void remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > lastElementIndex) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int[] temp = Arrays.copyOf(dynamicIntArray, lastElementIndex + 1);
        int containerArrayLength = dynamicIntArray.length;
        if (lastElementIndex == containerArrayLength / 4) {
            dynamicIntArray = new int[containerArrayLength / 2];
            System.arraycopy(temp, 0, dynamicIntArray, 0, index);
        }
        System.arraycopy(temp, index + 1, dynamicIntArray, index, lastElementIndex - index);
        lastElementIndex--;
    }

    public void insert(int index, int newElement) throws IndexOutOfBoundsException {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index > lastElementIndex) {
            add(newElement);
            return;
        }
        int[] temp = Arrays.copyOf(dynamicIntArray, lastElementIndex + 1);
        int containerArrayLength = dynamicIntArray.length;
        if (lastElementIndex + 1 == containerArrayLength) {
            dynamicIntArray = new int[containerArrayLength * 2];
            System.arraycopy(temp, 0, dynamicIntArray, 0, index);
        }
        dynamicIntArray[index] = newElement;
        System.arraycopy(temp, index, dynamicIntArray, index + 1, ++lastElementIndex - index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lastElementIndex + 1; i++) {
            sb.append(" ");
            sb.append(dynamicIntArray[i]);
        }
        return sb.toString();
    }
}
