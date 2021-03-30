package com.luxoft.springioc.lab2.model;

public interface Person {
    void setName(String name);

    String getName();

    void sayHello(Person person);
}