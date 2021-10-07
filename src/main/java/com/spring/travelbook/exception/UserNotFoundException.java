package com.spring.travelbook.exception;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String str)
    {
        // calling the constructor of parent Exception
        super(str);
    }
}
