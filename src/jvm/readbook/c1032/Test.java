package jvm.readbook.c1032;

public class Test {

    public static void main(String[] args) {
        Integer a = 1,
                b = 2,
                c = 3,
                d = 3,
                e = 321,
                f = 321;
        Long g = 3L;


        System.out.println(c == d);//两个对象比较 都为缓存Integer(值为3)的对象 返回 true
        System.out.println(e == f);//两个对象 无缓存 为两个不同对象 返回false
        System.out.println(c == (a + b));//右边拆箱计算得到int型值为3 ==两边有普通类型 左边自动拆箱int型值为3 int值类型比较 3 == 3 返回 true
        System.out.println(c.equals(a + b));//右边拆箱计算得到int型值为3 equals()方法自动装箱 Integer型值为3 Integer.equals(Integer) 值都为3 返回true
        System.out.println(g == (a + b));//右边拆箱计算得到int型值为3 ==两边有普通类型 左边自动拆箱long型值为3 两边类型不同统一将小转大 3L == 3L 返回true
        System.out.println(g.equals(a + b));//右边拆箱计算得到int型值为3 equals()方法自动装箱 Integer型值为3 Long.equals(Integer) 类型不同 返回false

    }
}
