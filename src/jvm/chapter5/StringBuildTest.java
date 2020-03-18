package jvm.chapter5;

public class StringBuildTest {

    //内部声明 不存在线程不安全
    public void method1() {
        StringBuilder builder = new StringBuilder();
        builder.append("a");
        builder.append("b");
    }

    //传入的值 有可能存在线程不安全
    public void method2(StringBuilder builder) {
        builder.append("a");
        builder.append("b");
    }

    //内部声明但是返回出去 有可能线程不安全
    public StringBuilder method3() {
        StringBuilder builder = new StringBuilder();
        builder.append("a");
        builder.append("b");
        return builder;
    }

    //返回出去的已经不是声明的这个对象 而是一个新的String对象 线程安全
    public String method4() {
        StringBuilder builder = new StringBuilder();
        builder.append("a");
        builder.append("b");
        return builder.toString();
    }
}
