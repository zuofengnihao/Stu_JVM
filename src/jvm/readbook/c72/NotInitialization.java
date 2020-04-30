package jvm.readbook.c72;

import jvm.readbook.c72.test.SubClass;

public class NotInitialization {

    public static void main(String[] args) {
        /**
         * 没有输出“ConstClass init！”，这是因为虽然在Java源码中确实引用了ConstClass类的常量HELLOWORLD，
         * 但其实在编译阶段通过常量传播优化，已经将此常量的值“hello world”直接存储在NotInitialization类的常量池中，
         * 以后NotInitialization对常量ConstClass.HELLOWORLD的引用，实际都被转化为NotInitialization类对自身常量池的引用了。
         * 也就是说，实际上NotInitialization的Class文件之中并没有ConstClass类的符号引用入口，这两个类在编译成Class文件后就已不存在任何联系了。
         */
        System.out.println(ConstClass.HELLOWORLD);

        /**
         * 通过子类引用父类的静态字段,不会导致子类初始化
         */
        System.out.println(SubClass.value);

        /**
         * 通过数组定义来引用类,不会触发此类的初始化
         */
        SubClass[] subs = new SubClass[10];
    }
}
