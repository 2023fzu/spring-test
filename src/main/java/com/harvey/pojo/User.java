package com.harvey.pojo;

import java.util.Objects;

/**
 * @author : HarveyBlocks
 * @version : 1.0
 * @className : User
 * @date : 2023/11/02 13:32
 **/
public class User {
    private int id              ;
    private String name             ;
    private int age          ;
    private String gender      ;

    public User(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public User() {

    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return getId() == user.getId() && getAge() == user.getAge() && Objects.equals(getName(), user.getName())  && getGender().equals(user.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge(),  getGender());
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}




