package com.giggs13.generics;

public class TestClassForMultipleBounds
        implements Interface1,
        Interface2 {

    private final String value;

    public TestClassForMultipleBounds(final String value) {
        this.value = value;
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "TestClassForMultipleBounds{" +
                "value='" + value + '\'' +
                '}';
    }
}
