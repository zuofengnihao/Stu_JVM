package jvm.readbook.c923;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {

    interface IHello{
        void sayHello();
    }

    static class Hello implements IHello {
        @Override
        public void sayHello() {
            System.out.println("hello,world!");
        }
    }

    static class Fuck implements IHello {
        @Override
        public void sayHello() {
            System.out.println("fuck,world!");
        }
    }

    static class DynamicProxy implements InvocationHandler {
        Object originalObj;

        Object bindObj(Object originalObj) {
            this.originalObj = originalObj;
            return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(), originalObj.getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("welcome");
            return method.invoke(originalObj, args);
        }
    }

    public static void main(String[] args) {
        IHello hello = (IHello) new DynamicProxy().bindObj(new Hello());
        hello.sayHello();
        IHello fuck = (IHello) new DynamicProxy().bindObj(new Fuck());
        fuck.sayHello();
    }
}
