package jvm.chapter2.mytest;

public class InitTest {

    public static void main(String[] args) {
        Father father = new Son();
        int i = 1;
        ((Son) father).method();
    }
}

