package com.example.demo.model;

public class Country {
    Integer id = 1;
    String name = null;
    public static Integer autoincrement = 1;
    public Country(String name){
        this.id = autoincrement;
        this.name = name;
        autoincrement++;
    }

    public Integer getId() {
        return id;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                '}';
    }
}
