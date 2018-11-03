/*
The most commonly used type parameter names are:

    E - Element (used extensively by the Java Collections Framework)
    K - Key
    N - Number
    T - Type
    V - Value
    S,U,V etc. - 2nd, 3rd, 4th types
*/
package com.giggs13.generics;

public class Entry {

    public static void main(String[] args) {
        Box<Integer> box = new Box<>();
        box.set(17);
        System.out.println(box.get());

        OrderedPair<String, Box<Integer>> p = new OrderedPair<>("primes", new Box<Integer>());
        p.getValue().set(202);
        System.out.println(p.getKey() + "   " + p.getValue().get() + "   " + p.getValue().getClass());

        Pair<Integer, String> p1 = new OrderedPair<>(1, "apple");
        Pair<Integer, String> p2 = new OrderedPair<>(2, "pear");
        boolean same = Util.compare(p1, p2);
        System.out.println(same);

        Box<Integer> integerBox = new Box<Integer>();
        integerBox.set(new Integer(10));
        integerBox.inspect(new TestClassForMultipleBounds("Get instance of TestClassForMultipleBounds class."));
    }
}
