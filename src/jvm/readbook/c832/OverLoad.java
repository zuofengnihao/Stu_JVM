package jvm.readbook.c832;

public class OverLoad {

    public static void sayHello(Object arg) {
        System.out.println("hello Object");
    }

    /*public static void sayHello(int arg) {
        System.out.println("hello int");
    }*/

    /*public static void sayHello(long arg) {
        System.out.println("hello long");
    }*/

    /*public static void sayHello(Character arg) {
        System.out.println("hello Character");
    }*/

    /*public static void sayHello(char arg) {
        System.out.println("hello char");
    }*/

    public static void sayHello(char... args) {
        System.out.println("hello char ...");
    }

    /*public static void sayHello(Serializable arg) {
        System.out.println("hello Serializable");
    }*/

    public static void main(String[] args) {
        sayHello('a');// char
        sayHello('a');// 注释char int
        sayHello('a');// 注释int long
        sayHello('a');// 注释long Character
        sayHello('a');// 注释Character Serializable | java.lang.Serializable是java.lang.Character类实现的一个接口
        sayHello('a');// 注释Serializable Object | 注释得只剩1个了，可见变长参数的重载优先级是最低的
    }
}
