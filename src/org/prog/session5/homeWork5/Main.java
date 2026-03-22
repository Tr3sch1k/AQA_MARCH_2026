package org.prog.session5.homeWork5;

public class Main {
    public static void main(String[] args) {
        Android myAndroid = new Android();
        Apple myIphone = new Apple();

        myAndroid.unlock();
        myAndroid.call();
        myIphone.unlock();
        myIphone.call();

        needCall(myIphone);
        needCall(myAndroid);
    }

    public static void needCall(IPhone iPhone){
        iPhone.unlock();
        iPhone.call();
    }
}
