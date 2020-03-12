package jvm.chapter1;

public class StackStruTest {
    public static void main(String[] args) {
        //int i = 2 + 3;
        int j = 2;
        int k = 3;
        int l = j + k;

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {

        }

        System.out.println("hello");

    }
}
