package com.mateo9x;

import java.util.UUID;

public class User {

    public String getUniqueID() {
        return uniqueID;
    }

    public String uniqueID = UUID.randomUUID().toString();
    public String name ;
    public String surname;
    public int age;
    public double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }



}
