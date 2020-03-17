package jvm.chapter5;

import java.util.Date;

public class LocalVariablesTest {

    public int count = 0;

    public LocalVariablesTest(){}

    public LocalVariablesTest(int count) {
        this.count = count;
    }

    public static void main(String[] args) {
        LocalVariablesTest test = new LocalVariablesTest();
        int num = 10;
        test.test1();
    }

    //练习
    public static int method(int num) {
        double d = 1.0;
        String str = "aaa";
        System.out.println(str);
        return num + (int)d;
    }

    public void test1() {
        Date date = new Date();
        String name1 = "zuofeng";
        String info = test2(date, name1);
        System.out.println(date + name1);
    }

    public String test2(Date dateP, String name2) {
        dateP = null;
        name2 = "zhangyu";
        double weight = 130.3;
        char gender = '男';
        return dateP + name2;
    }

    public void test3() {
        count++;
    }

    public void test4() {
        int a = 0;
        {
            int b = 0;
            b = a + 1;
        }
        int c = a + 1;
    }
}
