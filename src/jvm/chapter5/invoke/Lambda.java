package jvm.chapter5.invoke;

/**
 * invokedynamic
 */

@FunctionalInterface
interface Func {
    public boolean func(String str);
}

public class Lambda {

    public void lambda(Func func) {
        return;
    }

    public static void main(String[] args) {
        Lambda lambda = new Lambda();
        //invokedynamic
        Func func = str -> {
            System.out.println(str);
            return true;
        };

        lambda.lambda(func);

        //invokedynamic
        lambda.lambda(s -> {
            System.out.println(s + "hello");
            return true;
        });

    }
}
