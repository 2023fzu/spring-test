package com.harvey.pojo;

/**
 * @author : HarveyBlocks
 * @version : 1.0
 * @className : Root
 * @date : 2023/11/02 18:04
 **/
public class Root extends User{
    String name;
    String password;

    public Root(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Root() {
    }

    @Override
    public String toString() {
        return "Root{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
