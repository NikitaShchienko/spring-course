package com.luxoft.springioc.lab1.model;

import java.io.Serializable;
import java.util.Objects;

public class Country implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String codeName;
    private A a;

    public Country(int id, String name, String codeName) {
        this(id, name, codeName, null);
    }

    public Country(String name, String codeName) {
        this(0, name, codeName);
    }

    public Country(int id, String name, String codeName, A a) {
        this.id = id;
        this.name = name;
        this.codeName = codeName;
        this.a = a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public A getA() {
        return a;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String toString() {
        return id + ". " + name + " (" + codeName + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return id == country.id && name.equals(country.name) && codeName.equals(country.codeName) && a.equals(country.a);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, codeName, a);
    }
}
