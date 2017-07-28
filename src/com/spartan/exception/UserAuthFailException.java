package com.spartan.exception;

public class UserAuthFailException extends Exception{
    private String username;

    public UserAuthFailException(final String username){
        super("[+] The credentials are incorrect, the user needs to sign in again");
        this.username = username;
    }
}
