package jvm.readbook.c733;

public class Test {

    static {
        i = 1;
        //System.out.print(i);//非法向前引用
    }

    static int i = 2;

    public static void main(String[] args) {
        System.out.println(Test.i);
    }
}

