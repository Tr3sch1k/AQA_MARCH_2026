package org.prog.session5.homeWork5;


public class Apple implements IPhone {
    @Override
    public void unlock() {
        System.out.println("Apple unlock faceID");

    }

    @Override
    public void call() {
        System.out.println("Apple call FaceTime");
    }
}
