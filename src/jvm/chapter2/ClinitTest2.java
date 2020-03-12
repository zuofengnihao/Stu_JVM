package jvm.chapter2;

public class ClinitTest2 {

    static class Father {
        public static int A = 1;
        static {
            A = 2;
        }
    }

    static class Son extends Father {
        public static int B = A;
    }

    public static void main(String[] args) {
        //加载Father类
        System.out.println(Son.B);//2
    }
}
