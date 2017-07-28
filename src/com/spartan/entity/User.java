package com.spartan.entity;

public class User implements EntityInterface, ICopyable{
    private String name;
    private String pass;

    public User(final String name, final String pass){
        this.name = name;
        this.pass = pass;
    }

    public User(){
        this.name = "";
        this.pass = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String serialize() {
        return "{user:"+this.name+", pass: "+this.pass+"}";
    }

    @Override
    public ICopyable copy() {
        User tmpuser = new User(this.name, this.pass);
        return tmpuser;
    }
}
