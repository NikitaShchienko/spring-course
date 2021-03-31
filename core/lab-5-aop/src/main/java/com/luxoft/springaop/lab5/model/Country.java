package com.luxoft.springaop.lab5.model;

public interface Country {
    int getId();

    void setId(int id);

    String getName();

    void setName(String name);

    String getCodeName();

    void setCodeName(String codeName);

    int hashCode();

}