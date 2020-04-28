package jvm.readbook.c63;

public class Test {

    public static void main(String[] args) {
        System.out.println(new Test().inc());
    }

    public int inc() {
        int x;
        try {
            x = 1;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
            return x;
        }
    }
}
