package com.coolslow.datastruct;


/**
 * By MrZ
 * 2019-11-16
 */
public class MyArrayList<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elementData;
    private int size = 0;

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }
    public MyArrayList(int capacity) {
        elementData = new Object[capacity];
    }

    private void ensureCapacity() {
        if (elementData.length == size()) {
            Object[] oldElementData = elementData;
            elementData = new Object[size() * 2];
            for (int i = 0; i < size(); i++) {
                elementData[i] = oldElementData[i];
            }
        }
    }

    public void add(T data) {
        add(size(), data);
    }

    public void add(int idx, T data) {
        ensureCapacity();
        for (int i = size(); i > idx; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[idx] = data;
        size++;
    }

    public T remove(int idx) {
        if (idx >= size()) {
            return null;
        }
        T t = (T) elementData[idx];
        for (int i = idx; i < size() - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
        return t;
    }

    public T get(int idx) {
        if (idx >= size()) {
            return null;
        }
        return (T) elementData[idx];
    }

    public T set(int idx, T t) {
        if (idx >= size()) {
            return null;
        }
        T old = (T) elementData[idx];
        elementData[idx] = t;
        return old;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean clear() {
        elementData = new Object[0];
        return true;
    }

}
