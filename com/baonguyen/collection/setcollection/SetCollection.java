package com.baonguyen.collection.setcollection;

import java.util.*;
import java.util.stream.Collectors;

public class SetCollection {
  public static void main(String[] args) {
    //        sử dụng Set khi không muốn duplication
    //        không quan tâm về order of elements
    //        ví dụ như : store unique integer numbers, store cards randomly in a card game; store
    // numbers in random order...

    //         the uniqueness of elements that a Set guarantees, consider using HashSet when
    // ordering does not matter; using LinkedHashSet when you want to order elements by their
    // insertion order; using TreeSet when you want to order elements by their values.

    java.util.Set<Integer> numbers = new HashSet<>();
    numbers.add(1);
    numbers.add(2);

    java.util.Set<String> names = new LinkedHashSet<>();

    List<Integer> listNumbers =
        Arrays.asList(3, 9, 1, 4, 1, 2, 4, 2, 3, 512, 3, 512, 4, 165, 5123, 12, 512, 312);
    System.out.println(listNumbers);
    java.util.Set<Integer> uniqueNumbers = new HashSet<>(listNumbers);
    System.out.println(uniqueNumbers);

    //    since java 8
    java.util.Set<Integer> uniqueOddNumbers =
        listNumbers.stream()
            .filter(number -> number % 2 != 0)
            .collect(Collectors.toCollection(LinkedHashSet::new));
    System.out.println(uniqueOddNumbers);
    //    chú ý là capacity của HashSet và LinkedHashSet là 16, nếu biết giá trị hơn 16 thì khởi tạo
    java.util.Set<String> bigNames = new HashSet<>(1000);
    java.util.Set<String> bigNames1 = new LinkedHashSet<>(1000);
    //    với list thì chỉ có arrayList là có capacity

    //    The add()method returns true if the set does not contain the specified element, and
    // returns false if the set already contains the specified element:
    java.util.Set<String> names1 = new HashSet<>();
    names1.add("Tom");
    names1.add("Mary");
    if (names1.add("Peter")) {
      System.out.println("peter is added to the set");
    }
    if (names1.add("Tom")) {
      System.out.println("Tom is added to the set");
    } else {
      System.out.println("Tom is already added to the set");
    }

    //    Set can contain a null element
    names1.add(null);
    System.out.println(names1);

    if (names1.remove("Mary")) {
      System.out.println("Mary is removed");
    } else {
      System.out.println("Mary was not present");
    }

    if (names1.isEmpty()) {
      System.out.println("The set is empty");
    } else {
      System.out.println("The set is not empty");
    }
    names1.clear();
    if (names1.isEmpty()) {
      System.out.println("The set is empty");
    } else {
      System.out.println("The set is not empty");
    }

    java.util.Set<String> names3 = new HashSet<>();
    names3.add("Tom");
    names3.add("Mary");
    names3.add("Peter");
    names3.add("Alice");
    System.out.printf("The set has %d elements \n", names3.size());

    Iterator<String> iterator = names3.iterator();
    while (iterator.hasNext()) {
      String name = iterator.next();
      System.out.println(name);
    }

    for (String name : names3) {
      System.out.println(name);
    }

    System.out.println("=========Lamda========");
    //    java 8
    names3.forEach(System.out::println);

    if (names3.contains("Mary")) {
      System.out.println("found marry");
    }

    java.util.Set<Integer> s1 = new HashSet<>(Arrays.asList(20, 56, 89, 31, 8, 5));
    java.util.Set<Integer> s2 = new HashSet<>(Arrays.asList(8, 89));
    if (s1.containsAll(s2)){
      System.out.println("s2 is a subset of s1");
    }

    java.util.Set<Integer> s3 = new LinkedHashSet<>(Arrays.asList(1, 3, 5, 7, 9));
    java.util.Set<Integer> s4 = new LinkedHashSet<>(Arrays.asList(2, 4, 6, 8, 3, 51, 23, 2, 7));

    System.out.println("s3 before union: " + s3);

    s3.addAll(s4);

    System.out.println("s3 after union: " + s3);

    s3.clear();
    s3.addAll(Arrays.asList(1, 3, 5, 7, 9));

//    giao lấy các phần tử
    System.out.println("s3 before intersection: "+s3);
    s3.retainAll(s4);
    System.out.println("s3 after intersection: "+s3);

    java.util.Set<Integer> s5 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7, 9));
    java.util.Set<Integer> s6 = new HashSet<>(Arrays.asList(2, 4, 6, 8));

    System.out.println("s5 before difference: " + s5);

    s5.removeAll(s6);

    System.out.println("s5 after difference: " + s5);

//    concurrent Sets
//    All three implementations HashSet, LinkedHashSet and TreeSet are not synchronized. So if you use them in concurrent context (multi-threads), you have to synchronize them externally using

    java.util.Set<Integer> numbers7 = Collections.synchronizedSet(new HashSet<Integer>());

    synchronized (numbers7){
      Iterator<Integer> iterator1 = numbers7.iterator();
      while (iterator.hasNext()){
        Integer integer = iterator1.next();
        System.out.println(integer);
      }

    }
  }
}
