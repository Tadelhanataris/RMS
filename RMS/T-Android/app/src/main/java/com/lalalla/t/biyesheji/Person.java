package com.lalalla.t.biyesheji;

import java.io.Serializable;

/**
 * Created by T on 2016/3/8.
 */
public class Person implements Serializable {

    private Integer id;
    private Long number;
    private String password;
    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person (int id,long number,String password){
        super();
        this.id=id;
        this.number=number;
        this.password=password;

    }
    public Person(long number,String password){
        super();
        this.number=number;
        this.password=password;


    }
    public Person(int id,long number,String password,String name)
    {
        super();
        this.id=id;
        
    }

}
