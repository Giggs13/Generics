package ua.giggs13.generics;

public class Entry {

    public static void main(String[] args) {
        Box box = new Box();
        box.set("Run");
        System.out.println(box.get());
    }
}
