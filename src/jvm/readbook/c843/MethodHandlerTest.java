package jvm.readbook.c843;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;

/**
 * JSR 292 MethodHandler基础用法演示
 */
public class MethodHandlerTest {

    static class ClassA {
        public void println(String s) {
            System.out.println(s);
        }
    }


    public static void main (String[] args) throws Throwable {
        Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
        getPrintlnMH(obj).invokeExact("zuofeng");
    }

    public static MethodHandle getPrintlnMH (Object obj) throws Throwable {
        //MethodType：代表"方法类型"，包含了方法的返回值（methodType()的第一个参数)和具体参数(methodType()第二个及以后的参数）
        MethodType mt = MethodType.methodType(void.class, String.class);
        //lookup()方法来自于MethodHandlers.lookup，句的作用是在指定类中查找符合给定的方法名称、方法类型，并且符合调用权限的方法句柄
        Lookup lookup = MethodHandles.lookup();
        //因为这里调用的是一个虚方法，按照Java语言的规则，方法第一个参数是隐式的，代表方法的接受者，也即this指向的对象，这个参数以前是放在参数列表中进行传递的，现在提供了bindTo()方法来完成这件事。
        return lookup.findVirtual(obj.getClass(), "println", mt).bindTo(obj);
    }
}
