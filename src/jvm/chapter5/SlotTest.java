package jvm.chapter5;

public class SlotTest {

    public void localVar1() {
        int a = 1;
        System.out.println(a);
        int b = 1;
    }


    public void localVar2() {
        {
            int a = 0;
            System.out.println(a);
        }
        int b = 0;
    }
}
