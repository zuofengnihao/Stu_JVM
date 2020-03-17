package jvm.chapter5;

/**
 *  方法的结束方式分为两种：1.正常结束 return为代表 2.出现未捕获的异常 以抛出异常的方式结束
 */
public class StackFrameTest {

    public static void main(String[] args) {
        try {
            StackFrameTest test = new StackFrameTest();
            test.method1();
        }catch (Exception e) {
            e.printStackTrace();
        } {
            System.out.println("main()正常结束");
        }
    }

    public void method1() {
        System.out.println("method1开始执行...");
        method2();
        //System.out.println(10/0);
        System.out.println("method1执行结束...");
    }

    public int method2() {
        System.out.println("method2开始执行...");
        int i = 10;
        double d = method3();
        System.out.println("method2即将结束...");
        return i + (int)d;
    }

    public double method3() {
        System.out.println("method3开始执行...");
        double d = 4.0;
        System.out.println("method3即将结束...");
        return d;
    }
}
