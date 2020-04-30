package jvm.readbook.c733;

public class DeadLoopClass {

    static {
        if (true) {
            System.out.println("init DeadLoopClass");
            while (true) {}
        }
    }

}
