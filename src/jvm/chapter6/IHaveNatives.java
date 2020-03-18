package jvm.chapter6;

/**
 *
 */
public class IHaveNatives {

    public native void Native1(int x);

    public static native long Native2();

    native synchronized private float Native3(Object o);

    native void Native4(int[] ary) throws Exception;
}
