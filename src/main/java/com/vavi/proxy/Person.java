package com.vavi.proxy;

public class Person implements Sleepable {

    @Override
    public void sleep() {
	System.out.println("He is sleeping");
    }

    @Override
    public void eat() {
	System.out.println("He is eating");

    }

}
