package jvm.chapter2.mytest;

public class Son extends Father {

    {
        System.out.println("Son被初始化");
    }

    @Override
    public void method() {
        System.out.println("Son do something");
    }
}
