package com.baonguyen;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class GenericExample {
    public static void main(String[] args) {
        List listName = new ArrayList();
        listName.add("Tom");
        listName.add("Mary");
        listName.add("Peter");

//        The cast to String is needed because the get() method returns an object of type Object
        String name2 =(String) listName.get(1);

        Date startDate = new Date();
//        This code is still legal, as the add() method can accept any kind of object.
        listName.add(startDate);

//        a problem will rise in this statement
//        String name3 = (String) listName.get(3);

//        This assignment excepts a String object on the right side, but the actual object returned is a Data object
//        This problem cannot be detected at compile time by the compiler because everything seems fine until that
//        statement is executed at runtime, a ClassCaseException will be thrown:
//
//java.lang.ClassCastException: java.util.Date cannot be cast to java.lang.String

//        Therefore generics come to rescue.
        List<String> listNames = new ArrayList<>();
        listNames.add("Tom");
        listNames.add("Mary");
        listNames.add("Peter");

        Date startDate1 = new Date();

//     The list listNames is parameterized with the String type. the compiler will issue an error if add a
//     non-String object
//        listNames.add(startDate1);

//        we don't need to cast object when getting an element out of the generic collection
        String namee2 = listNames.get(2);

        List bookTitles = new ArrayList();
        bookTitles.add("Effective Java");
        bookTitles.add("Thinking in Java");
        bookTitles.add("Head First in Java");

        Iterator it = bookTitles.iterator();
        while (it.hasNext()){
            String nextTitle = (String) it.next();
            System.out.println(nextTitle);
        }

//        using generics
        List<String> bookTitles1 = new ArrayList<>();
        bookTitles1.add("Effective Java");
        bookTitles1.add("Thinking in Java");
        bookTitles1.add("Head First in Java");
        Iterator<String> iterator = bookTitles1.iterator();
        System.out.println("===");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
