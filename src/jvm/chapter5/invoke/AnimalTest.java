package jvm.chapter5.invoke;

class Animal {

    public void eat() {
        System.out.println("动物进食");
    }

}

interface Hunter {
    void hunt();
}

class Dog extends Animal implements Hunter {

    @Override
    public void eat () {
        System.out.println("狗吃骨头");
    }

    @Override
    public void hunt() {
        System.out.println("狗拿耗子 多管闲事");
    }

}

class Cat extends Animal implements Hunter {

    public Cat() {
        super();//早期绑定 静态链接
    }

    public Cat(String name) {
        this();//早期绑定 静态链接
    }

    @Override
    public void eat () {
        System.out.println("猫吃老鼠");
    }

    @Override
    public void hunt() {
        System.out.println("天经地义");
    }
}

public class AnimalTest {

    public void showAnimal(Animal animal) {
        animal.eat();//晚期绑定 动态链接
    }

    public void showHunt(Hunter hunter) {
        hunter.hunt();//晚期绑定 动态链接
    }
}

