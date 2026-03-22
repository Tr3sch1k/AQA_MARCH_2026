package org.prog.session5.homeWork5;

public class Android implements IPhone {
    @Override
    public void unlock() {
        System.out.println("Android unlock FingerPrint");
    }

    @Override
    public void call() {
        System.out.println("Andoid call");
    }
}
