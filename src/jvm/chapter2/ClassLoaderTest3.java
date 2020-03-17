package jvm.chapter2;

public class ClassLoaderTest3 {

    public static void main(String[] args) {
        try {
            //1
            ClassLoader strClassLoader = Class.forName("java.lang.String").getClassLoader();
            System.out.println(strClassLoader);
            //2
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            System.out.println(contextClassLoader);
            //3
            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
            ClassLoader extClassLoader = systemClassLoader.getParent();
            System.out.println(systemClassLoader);
            System.out.println(extClassLoader);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
