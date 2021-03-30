package com.luxoft.springioc.lab1.model;

import java.util.Objects;

/**
 * Created by oyushche on 9/18/17.
 */
public class A {
    private int id;

    public A(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a = (A) o;
        return id == a.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "A{" +
                "id=" + id +
                '}';
    }
}
