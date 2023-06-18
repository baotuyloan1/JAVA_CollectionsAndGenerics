package com.baonguyen.collection.listcollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingMultipleAttributesExample {

  public static void main(String[] args) {
    System.out.println("=========Sorting by multiple============");
    List<Employee> employeeList = new ArrayList<>();
    employeeList.add(new Employee("Tom", "Developer", 45, 80000));
    employeeList.add(new Employee("Sam", "Designer", 30, 75000));
    employeeList.add(new Employee("Bob", "Designer", 45, 134000));
    employeeList.add(new Employee("Peter", "Programmer", 25, 60000));
    employeeList.add(new Employee("Tim", "Designer", 45, 130000));
    employeeList.add(new Employee("Craig", "Programmer", 30, 52000));
    employeeList.add(new Employee("Anne", "Programmer", 25, 51000));
    employeeList.add(new Employee("Alex", "Designer", 30, 120000));
    employeeList.add(new Employee("Bill", "Programmer", 22, 30000));
    employeeList.add(new Employee("Samuel", "Developer", 28, 80000));
    employeeList.add(new Employee("John", "Developer", 35, 67000));
    employeeList.add(new Employee("Patrick", "Developer", 35, 140000));
    employeeList.add(new Employee("Alice", "Programmer", 35, 80000));
    employeeList.add(new Employee("David", "Developer", 35, 99000));
    employeeList.add(new Employee("Jane", "Designer", 30, 82000));

    System.out.println("*** Before sorting: ");
    for (Employee emp : employeeList) {
      System.out.println(emp);
    }

    Collections.sort(
        employeeList,
        new EmployeeChainedComparator(
            new EmployeeJobTitleComparator(),
            new EmployeeAgeComparator(),
            new EmployeeSalaryComparator()));

    System.out.println("*** After sorting");
    for (Employee emp : employeeList) {
      System.out.println(emp);
    }
  }
}
