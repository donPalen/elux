package com.test.controller;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by prokale on 2017-11-21.
 */
public class HomeControllerTest {

    @Test
    public void testHome() {
        HomeController hc = new HomeController();
        String result = hc.home();
        assertEquals(result, "welcome");
    }
}