package jvm.chapter2;

public class ClassLoaderTest {
    public static void main(String[] args) {
        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2

        //获取其上层：扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);//sun.misc.Launcher$ExtClassLoader@1b6d3586

        //获取其上层：
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapClassLoader);//null

        //对于用户自定义类来说: 使用系统类加载器加载
        ClassLoader classLoader = ClassInitTest.class.getClassLoader();
        System.out.println(classLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2

        //string类由引导类加载器bootstrap class loader 加载 --> Java核心类库都是由引导类加载器加载的
        ClassLoader strClassLoader = String.class.getClassLoader();
        System.out.println(strClassLoader);//null
    }
}
