package jvm.readbook.c832;

import java.util.Random;

public class StaticDispatch {

    static abstract class Human{}

    static class Man extends Human{}

    static class Woman extends Human{}

    public void sayHello(Human guy) {
        System.out.println("hello,guy!");
    }

    public void sayHello(Man guy) {
        System.out.println("hello,gentleman!");
    }

    public void sayHello(Woman guy) {
        System.out.println("hello,lady!");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch dispatch = new StaticDispatch();
        dispatch.sayHello(man);
        dispatch.sayHello(woman);

        Human human = new Random().nextBoolean() ? new Man() : new Woman();
        dispatch.sayHello((Man) human);
        dispatch.sayHello((Woman) human);
    }
}
