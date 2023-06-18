package com.baonguyen.collection.setcollection;

import java.util.*;

public class NavigableSetExample {
  public static void main(String[] args) {
    TreeSet<Integer> setNumbers = new TreeSet<>();
    setNumbers.addAll(Arrays.asList(4, 8, 3, 9, 1, 6, 4, 5, 3, 2, 7, 8, 0));
    NavigableSet<Integer> setNumbers1 = setNumbers.descendingSet();
    System.out.println(setNumbers);
    System.out.println(setNumbers1);

    NavigableSet<String> setFruits = new TreeSet<>();
    setFruits.add("Banana");
    setFruits.add("Apple");
    setFruits.add("Orange");
    setFruits.add("Mango");
    System.out.println("Set Fruits: " + setFruits);
    Iterator<String> descIterator = setFruits.descendingIterator();
    System.out.println("Fruits by descending order: ");
    while (descIterator.hasNext()) {
      System.out.print(descIterator.next() + ", ");
    }
    System.out.println("");
    NavigableSet<Employee> setEmployees = new TreeSet<>(new EmployeeComparator());

    setEmployees.add(new Employee("Tom", 80000));
    setEmployees.add(new Employee("Jack", 35000));
    setEmployees.add(new Employee("Jim", 62500));
    setEmployees.add(new Employee("Peter", 58200));
    setEmployees.add(new Employee("Mary", 77000));
    setEmployees.add(new Employee("Jane", 69500));
    setEmployees.add(new Employee("David", 54000));
    setEmployees.add(new Employee("Sam", 82000));

    System.out.println("Employees: " + setEmployees);
    Employee Tom = new Employee(58200);

    //    đứng sau trong treeset chứ không phải là cao hơn, mặc định nó sắp xếp theo tăng dần nên sẽ
    // thấy cao hơn
    //    Nhưng khi dùng comparator để sắp xếp ngược, thì dùng higher nó trả về phía sau chứ không
    // phải cao hơn,

//    sau nó
    Employee emp1 = setEmployees.higher(Tom);
    if (emp1 != null) {
      System.out.println("The employee whose salary < Tom em: " + emp1);
    }

//    trước nó
    Employee emp2 = setEmployees.lower(Tom);
    if (emp2 != null) {
      System.out.println("The employee whose salary > Tom: " + emp2);
    }


//    sau hoặc bằng chính nó
    Employee emp3 = setEmployees.ceiling(new Employee(58200));
    if (emp3 != null) {
      System.out.println("The employee whose <= 58200: " + emp3);
    }

    Employee emp4 = setEmployees.floor(Tom);
    if (emp4 != null) {
      System.out.println("The employee whose >= 58200: " + emp3);
    }

    SortedSet<Employee> lowPaidEmployees = setEmployees.tailSet(new Employee(70000));
    System.out.println("Low paid employees: " + lowPaidEmployees);

    SortedSet<Employee> highPaidEmployees = setEmployees.headSet(new Employee(60000));
    System.out.println("High paid employees: " + highPaidEmployees);

//    * With the subSet() method, we can know the employees who are good paid (salary is between 60,000 and 70,000):

    SortedSet<Employee> goodPaidEmployees = setEmployees.subSet(new Employee(70000),new Employee(60000));
    System.out.println("Good paid employees: " + goodPaidEmployees);
    System.out.println(goodPaidEmployees);

//    treeSet không thể chưa null vì khi chứa null thì làm sao nó có thể gọi compareTo để nó so sánh giá trị
//    sẽ bắn ra lỗi : Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.lang.Comparable.compareTo(Object)" because "k1" is null
//    Set<Employee> nullSet = new TreeSet<>();
//    nullSet.add(null);
//    nullSet.add(new Employee(23123));
  }
}
