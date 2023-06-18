package com.baonguyen.collection;

import java.util.Comparator;

public class EmployeeAgeComparator implements Comparator<Employee> {


//    giam dan theo age
    @Override
    public int compare(Employee o1, Employee o2) {
        return o2.getAge() - o1.getAge();
    }
}
