package jvm.chapter5.invoke;

class Father {
    public Father() {
        System.out.println("father的构造器");
    }

    public static void showStatic(String str) {
        System.out.println("father " + str);
    }

    public final void showFinal() {
        System.out.println("father show final");
    }

    public void showCommon() {
        System.out.println("father 普通方法");
    }
}

public class Son extends Father{
    public Son() {
        super();
    }

    public Son(int age) {
        this();
    }

    public static void showStatic(String str) {
        System.out.println("son " + str);
    }

    private void showPrivate(String str) {
        System.out.println("son private " + str);
    }

    public void show() {
        //invokestatic
        showStatic("zuofeng");
        //invokestatic
        super.showStatic("zhangyu");
        //invokespecial
        showPrivate("hello");
        //invokespecial
        super.showCommon();
        //invokevirtual
        showFinal();
        //invokespecial
        super.showFinal();
        //invokevirtual
        showCommon();
        //invokevirtual
        info();

        MethodInterface in = null;
        //invokeinterface
        in.methodA();
    }

    public void info() {}
}

interface MethodInterface {
    void methodA();
}