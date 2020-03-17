package jvm.chapter5;

public class StackTest {

    private static int i = 1;

    public static void main(String[] args) {
        System.out.println(i++);
        main(args);
    }
}
