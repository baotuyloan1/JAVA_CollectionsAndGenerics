package com.baonguyen.collection.setcollection;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class ZtoAComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }

public static void main(String[] args){
    SortedSet<String> setStrings = new TreeSet<>(new ZtoAComparator());
    setStrings.add("Banana");
    setStrings.add("Apple");
    setStrings.add("Grape");
    setStrings.add("Lemon");
    setStrings.add("Watermelon");

    System.out.println(setStrings);

//    java 8, lamda
    SortedSet<String> sortedSet = new TreeSet<>((s1,s2)-> s2.compareTo(s1));
    sortedSet.add("Banana 1");
    sortedSet.add("Apple 2");
    sortedSet.add("Grape");
    sortedSet.add("Lemon");
    sortedSet.add("Watermelon");
    System.out.println(sortedSet);
}

}
