package jvm.readbook.c733;

public class DeadLoopDemo {


    public static void main(String[] args) {
        Runnable script = () -> {
            System.out.println(Thread.currentThread() +  " start");
            DeadLoopClass deadLoopClass = new DeadLoopClass();
            System.out.println(Thread.currentThread() + " run over");
        };

        Thread t1 = new Thread(script);
        Thread t2 = new Thread(script);

        t1.start();
        t2.start();
    }

}
