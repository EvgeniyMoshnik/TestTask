package com.moshnyk.testtaskone;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import static org.junit.Assert.*;

public class HelloWorldTest {

    private Locale locale = null;

    @Test
    public void resultMorningWithLocalUSTest() {
        locale = new Locale("en", "US");
        String expected = "Good morning, World!";
        String actual = HelloWorld.getGreeting("Morning", locale);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void resultDayWithLocalUSTest() {
        locale = new Locale("en", "US");
        String expected = "Good day, World!";
        String actual = HelloWorld.getGreeting("Day", locale);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void resultEveningWithLocalUSTest() {
        locale = new Locale("en", "US");
        String expected = "Good evening, World!";
        String actual = HelloWorld.getGreeting("Evening", locale);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void resultNightWithLocalUSTest() {
        locale = new Locale("en", "US");
        String expected = "Good night, World!";
        String actual = HelloWorld.getGreeting("Night", locale);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void resultMorningWithLocalRUTest() {
        locale = new Locale("ru", "RU");
        String expected = "Хорошего утра, Мир!";
        String actual = HelloWorld.getGreeting("Morning", locale);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void resultDayWithLocalRUTest() {
        locale = new Locale("ru", "RU");
        String expected = "Хорошего дня, Мир!";
        String actual = HelloWorld.getGreeting("Day", locale);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void resultEveningWithLocalRUTest() {
        locale = new Locale("ru", "RU");
        String expected = "Хорошего вечера, Мир!";
        String actual = HelloWorld.getGreeting("Evening", locale);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void resultNightWithLocalRUTest() {
        locale = new Locale("ru", "RU");
        String expected = "Хорошей ночи, Мир!";
        String actual = HelloWorld.getGreeting("Night", locale);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void currentTimeOfDayOnMorningTest() {
        String expected = "Morning";
        String actual;
        int[] hoursOfMorning = {6, 7, 8};
        for (int hour : hoursOfMorning) {

            actual = HelloWorld.getCurrentTimesOfDay(hour);
            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void currentTimeOfDayOnDayTest() {
        String expected = "Day";
        String actual;
        int[] hoursOfMorning = {9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
        for (int hour : hoursOfMorning) {

            actual = HelloWorld.getCurrentTimesOfDay(hour);
            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void currentTimeOfDayOnEveningTest() {
        String expected = "Evening";
        String actual;
        int[] hoursOfMorning = {19, 20, 21, 22};
        for (int hour : hoursOfMorning) {

            actual = HelloWorld.getCurrentTimesOfDay(hour);
            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void currentTimeOfDayOnNightTest() {
        String expected = "Night";
        String actual;
        int[] hoursOfMorning = {23, 0, 1, 2, 3, 4, 5};
        for (int hour : hoursOfMorning) {

            actual = HelloWorld.getCurrentTimesOfDay(hour);
            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void resultInvalidDateTest() {
        String expected = "Invalid date!";
        String actual = HelloWorld.getCurrentTimesOfDay(26);
        Assert.assertEquals(expected, actual);
    }
}