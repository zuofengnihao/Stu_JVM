package jvm.chapter2;

public class ClassInitTest {

    public static final int INT = 10;

    private static int num = 1;

    static {
        num = 2;
        number = 20;
        System.out.println(num);
        //System.out.println(number);//报错：非法的前向引用
    }

    private static int number = 10;

    public static void main(String[] args) {
        //System.out.println(ClassInitTest.num);//2
        //System.out.println(ClassInitTest.number);//10 顺序执行
        System.out.println(ClassInitTest.INT);
    }
}
