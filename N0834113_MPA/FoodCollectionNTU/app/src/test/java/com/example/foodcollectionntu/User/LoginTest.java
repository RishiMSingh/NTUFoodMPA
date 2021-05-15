package com.example.foodcollectionntu.User;

import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

public class LoginTest {

    private Login activity;

    @Before
    public void setUp() throws Exception {
        activity = new Login();
    }

    @After
    public void tearDown() throws Exception {
        activity = null;
    }


}