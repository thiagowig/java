package br.com.ithiago.springboot.camel.model;

/**
 * Created by thiago on 5/6/18.
 */
public class Person {

    private String name;

    private String address;

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
