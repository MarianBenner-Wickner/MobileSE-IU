package com.example.helloworldexample;

import junit.framework.TestCase;

import org.junit.Assert;

public class UserTest extends TestCase {

    public void testTestGetName() {
        User user = new User("Max", "Black");
        Assert.assertEquals("Max, Black", user.getName());
    }
}