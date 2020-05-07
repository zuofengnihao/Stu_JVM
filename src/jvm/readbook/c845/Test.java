package jvm.readbook.c845;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

public class Test {

    class GrandFather {
        void thinking () throws Throwable {
            System.out.println("I am grandfather");
        }
    }

    class Father extends GrandFather {
        void thinking () throws Throwable {
            System.out.println("I am father");
        }
    }

    class Son extends Father {
        void thinking() throws Throwable {
            //请读者在这里填入适当的代码
            //实现调用祖父类的thinking方法,打印"I am grandfather"
            MethodType mt = MethodType.methodType(void.class);
            Field lookupImpl = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
            lookupImpl.setAccessible(true);
            MethodHandle mh = ((MethodHandles.Lookup) lookupImpl.get(null)).findSpecial(GrandFather.class, "thinking", mt, GrandFather.class);
            mh.invoke(this);
        }
    }

    public static void main(String[] args) {
        try {
            (new Test().new Son()).thinking();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}


