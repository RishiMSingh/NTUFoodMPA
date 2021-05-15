package com.example.foodcollectionntu.User;

import com.example.foodcollectionntu.helperClass.dashboardAdapter.ItemData;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CartActivityTest {

    private CartActivity activity;

    @Before
    public void setUp() throws Exception {

        activity = new CartActivity();
    }

    @After
    public void tearDown() throws Exception {
        activity = null;

    }
/*
    @Test
    public void calculateAmount() {
        String val = "£0.99";
        Double price = Double.parseDouble(val);
        List<ItemData> itemDataList;
        itemDataList.getPrice();


        assertEquals(2.99 , activity.calculateAmount());

        assertEquals(0.99, calculateAmount(val));
        assertEquals(5.88, calculateAmount(val));
        assertEquals(0.34, calculateAmount(val));
        assertEquals(3.49, calculateAmount(val));
    }

    @Test
    public void calculateAmount() {
        String val = "6.99";
        Double price = Double.parseDouble(val);

        assertEquals(1.00, calculateAmount(val));
        assertEquals(2.443244, calculateAmount(val));
        assertEquals(2, calculateAmount(val));
        assertEquals("234rtt", calculateAmount(val));
    }

    @Test
    public void calculateAmount() {
        String val = "6.99";
        Double price = Double.parseDouble(val);

        assertEquals("3.233233232", calculateAmount(val));
        assertEquals("44444444", calculateAmount(val));
        assertEquals(2333.3, calculateAmount(val));
        assertEquals("234rtt", calculateAmount(val));
    }


    @Test
    public void calculateAmount() {
        String val = "6.99";
        Double price = Double.parseDouble(val);

        assertEquals(1.00112122, calculateAmount(val));
        assertEquals("HIHEFEFE", calculateAmount(val));
        assertEquals(22222222, calculateAmount(val));
        assertEquals("234rtt", calculateAmount(val));
    }
*/

}