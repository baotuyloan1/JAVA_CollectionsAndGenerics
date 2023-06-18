package com.baonguyen.collection.setcollection;

import java.util.*;

public class SortedSetTreeSet {

  public static void main(String[] args) {
    //        besides inheriting behaviors of a typical Set, TreeSet also inherits behaviors of
    // SortedSet and NavigableSet

    //        Use TreeSet when you want a collection: no dupplicate, elements are sorted by their
    // natural ordering (deffault) or by a specified comparator
    SortedSet<Integer> setNumbers = new TreeSet<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2-o1;
      }
    });
    setNumbers.addAll(Arrays.asList(2, 1, 4, 3, 6, 5, 8, 7, 0, 9));
    System.out.println("Sorted Set: " + setNumbers);

//    subset chỉ hoạt động với các tập con được 1 phần liên tục với tập hợp gốc
    //        range view operations
    System.out.println(setNumbers.subSet(7,6));

//    lấy các phần tử trong set và đứng trước cái toElement
    System.out.println(setNumbers.headSet(5));

    //    lấy các phần tử đứng bằng hoặc sau toElement
    System.out.println(setNumbers.tailSet(5));

    System.out.println(setNumbers.first());
    System.out.println(setNumbers.last());

    SortedSet<Integer> setNumbers1 = new TreeSet<>();
    setNumbers1.addAll(Arrays.asList(2, 1, 4, 3, 6, 5, 8, 7, 0, 9));
    System.out.println("Original Set: " + setNumbers1);
    Integer first = setNumbers1.first();
    System.out.println("First element: " + first);
    Integer last = setNumbers1.last();
    System.out.println("Last element: " + last);
    SortedSet<Integer> subSet = setNumbers1.subSet(3, 7);
    System.out.println("Sub Set: " + subSet);
    SortedSet<Integer> headSet = setNumbers1.headSet(5);
    System.out.println("Head Set: " + headSet);
    SortedSet<Integer> tailSet = setNumbers1.tailSet(5);
    System.out.println("Tail Set: " + tailSet);
    Comparator comparator = setNumbers1.comparator();
    System.out.println("Sorted by natural ordering? " + (comparator == null));


  }
}
