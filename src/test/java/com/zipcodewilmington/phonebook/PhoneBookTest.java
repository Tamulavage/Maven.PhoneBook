package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {
    private PhoneBook testingPhoneBook;

    @Before
    public void setup() {
        this.testingPhoneBook = new PhoneBook();
    }

    @Test
    // addTest
    // not adding new object, just setting instance variables to existing object
    // Similiar to setters
    public void addTest() {
        // Given
        String expectedName = "David T";
        String expectedNumber = "123-444-5343";

        // When
        testingPhoneBook.add(expectedName, expectedNumber);

        // Then
        String actualNumber = testingPhoneBook.lookUp(expectedName);
        String actualName = testingPhoneBook.reverseLookUp(expectedNumber);

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedNumber, actualNumber);
    }


    @Test
    // lookUpTest
    public void lookUpTest() {
        // Given
        String name = "Not David";
        String expectedNumber = "555-444-5343";
        testingPhoneBook.add(name, expectedNumber);


        // When
        String actualNumber = testingPhoneBook.lookUp(name);

        // Then
        Assert.assertEquals(expectedNumber, actualNumber);

    }

    @Test
    // lookUpTest
    public void lookUpTestNotFound() {
        // Given
        String name = "Not David";
        String nameNotIn = "Yello";
        String number = "555-444-5343";
        String expectedNumber = "Not Found";
        testingPhoneBook.add(name, expectedNumber);


        // When
        String actualNumber = testingPhoneBook.lookUp(nameNotIn);

        // Then
        Assert.assertEquals(expectedNumber, actualNumber);

    }


    @Test
    // ReverseLookUpTest
    public void reverseLookUpTest() {
        // Given
        String expectedName = "Third Person";
        String number = "555-SHOES";
        testingPhoneBook.add(expectedName, number);

        // WHen
        String actualName = testingPhoneBook.reverseLookUp(number);

        // Then
        Assert.assertEquals(expectedName, actualName);
    }


    @Test
    // RemoveTest
    public void removeTest() {
        // Given
        String name = "To be Removed";
        String number = "123-444-5343";
        String expectedNumber = "Not Found";
        testingPhoneBook.add(name, number);

        // When
        testingPhoneBook.remove(name);

        // Then
        String actualNumber = testingPhoneBook.lookUp(name);
        Assert.assertEquals(expectedNumber, actualNumber);
    }

    @Test
    // RemoveTest
    public void removeNum2ndNumTest() {
        // Given
        String name = "Bob";
        String expectedNumber = "123-444-5343";
        String number2 = "555-123-5343";
        testingPhoneBook.add(name, expectedNumber);
        testingPhoneBook.add(name, number2);

        // When
        testingPhoneBook.removeNum(number2);

        // Then
        String actualNumber = testingPhoneBook.lookUp(name);
        Assert.assertEquals(expectedNumber, actualNumber);
    }

    @Test
    // RemoveTest
    public void removeNumOnlyOneNumTest() {
        // Given
        String name = "Bob";
        String number = "123-444-5343";

        String expectedNumber = "Not Found";
        testingPhoneBook.add(name, number);

        // When
        testingPhoneBook.removeNum(number);

        // Then
        String actualNumber = testingPhoneBook.lookUp(name);
        Assert.assertEquals(expectedNumber, actualNumber);
    }


    @Test
    public void displayTest() {
        testingPhoneBook.add("hello", "1234");
        testingPhoneBook.add("not here", "2314");
        testingPhoneBook.add("a person", "0902");
        testingPhoneBook.add("David", "89123");
        testingPhoneBook.add("David", "892123");

        testingPhoneBook.removeNum("1234");
        testingPhoneBook.removeNum("892123");
        testingPhoneBook.remove("a person");

        testingPhoneBook.display();
    }
    // HOW DO WE TEST DISPLAYS WORK PROPERLY?
    // ListNamesAndNumbersTest
    //  ListNames


}
