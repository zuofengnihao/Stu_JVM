package jvm.chapter2;

import sun.misc.Launcher;
import sun.misc.URLClassPath;
import sun.security.ec.CurveDB;

import java.net.URL;
import java.security.Provider;

public class ClassLoaderTest2 {

    public static void main(String[] args) {
        System.out.println("************启动类加载器************");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL url:urLs) {
            System.out.println(url.toExternalForm());
        }
        //从上面的路径中随意选择一个类，来看看他的类加载器是什么：引导类加载器 bootstrap class loader
        ClassLoader providerClassLoader = Provider.class.getClassLoader();
        System.out.println(providerClassLoader);//null

        System.out.println();
        System.out.println("************扩展类加载器************");
        String property = System.getProperty("java.ext.dirs");
        for (String path:property.split(";")) {
            System.out.println(path);
        }
        //从上面的路径中随意选择一个类，来看看他的类加载器是什么：扩展类加载器 extension class loader 对应类 ExtClassLoader
        ClassLoader curveDB_classLoader = CurveDB.class.getClassLoader();
        System.out.println(curveDB_classLoader);//sun.misc.Launcher$ExtClassLoader@4b67cf4d

        System.out.println();
        System.out.println("************系统类加载器************");
        ClassLoader appClassLoader = ClassLoaderTest2.class.getClassLoader();
        System.out.println(appClassLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2
    }
}
