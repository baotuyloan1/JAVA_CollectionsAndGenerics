package com.baonguyen.collection.listcollection;

import java.util.*;

public class CollectionsUtility {

  public static void main(String[] args) {
    List<Integer> listNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

    System.out.println("Before rotate:\n " + listNumbers);

    //        dịch các phần tử trong mảng sang bên phải 3 bước
    Collections.rotate(listNumbers, 3);

    System.out.println("After rotate:\n " + listNumbers);

    //        dịch phần tử trong mảng sublist
    Collections.rotate(listNumbers.subList(3, 6), 2);
    System.out.println("Sublist rotate: " + listNumbers);

    List<String> listCountries =
        Arrays.asList("USA", "Japan", "UK", "France", "Canada", "Singapore");

    System.out.println("Before swap: " + listCountries);

    Collections.swap(listCountries, 1, 5);

    System.out.println("After swap: " + listCountries);

    List<Integer> source = Arrays.asList(2, 4, 6, 8, 10);
    List<Integer> dest = Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15);

    System.out.println("dest before copy: " + dest);

    Collections.copy(dest, source);

    System.out.println("dest after copy: " + dest);


    List<String> listLetters
            = Arrays.asList("h", "e", "l", "l", "o", "w", "o", "r", "l", "d");

    System.out.println("Before replace:\n " + listLetters);

    Collections.replaceAll(listLetters, "l", "L");

    System.out.println("After replace:\n " + listLetters);

  }
}
