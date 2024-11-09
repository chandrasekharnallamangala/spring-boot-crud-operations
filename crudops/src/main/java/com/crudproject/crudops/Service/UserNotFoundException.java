package com.crudproject.crudops.Service;

public class UserNotFoundException extends Exception
{
    public UserNotFoundException(String message) {
        super(message);
    }
}
