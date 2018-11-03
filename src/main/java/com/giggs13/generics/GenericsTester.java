package com.giggs13.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericsTester {
    public static void main(String[] args) {
        BoxTester<Integer, String> box = new BoxTester<Integer, String>();
        box.add(Integer.valueOf(10), "Hello World");
        System.out.printf("Integer Value: %d\n", box.getFirst());
        System.out.printf("String Value: %s\n", box.getSecond());

        PairTester<String, Integer> pair = new PairTester<String, Integer>();
        pair.addKeyValue("1", Integer.valueOf(10));
        System.out.printf("(PairTester)Integer Value: %d\n", pair.getValue("1"));

        CustomListTester<BoxTester> list = new CustomListTester<BoxTester>();
        list.addItem(box);
        System.out.printf("(CustomListTester)Integer Value: %d\n", list.getItem(0).getFirst());
    }
}

class BoxTester<T, S> {
    private T t;
    private S s;

    public void add(T t, S s) {
        this.t = t;
        this.s = s;
    }

    public T getFirst() {
        return t;
    }

    public S getSecond() {
        return s;
    }
}

class PairTester<K, V> {
    private Map<K, V> map = new HashMap<K, V>();

    public void addKeyValue(K key, V value) {
        map.put(key, value);
    }

    public V getValue(K key) {
        return map.get(key);
    }
}

class CustomListTester<E> {
    private List<E> list = new ArrayList<E>();

    public void addItem(E value) {
        list.add(value);
    }

    public E getItem(int index) {
        return list.get(index);
    }
}