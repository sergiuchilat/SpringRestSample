package com.example.demo.model;

public class Country {
    private Integer id = 1;
    private String name;
    public static Integer autoincrement = 1;

    public Country(String name){
        this.id = autoincrement;
        this.name = name;
        autoincrement++;
    }

    public Country(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName(){
        return this.name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                '}';
    }
}
