package com.baonguyen.praticecollection;

import java.util.Comparator;

public class ClassNameComparator implements Comparator<Student> {

//    sắp xếp lớp giảm dần
    @Override
    public int compare(Student s1, Student s2) {
        return s2.getClassName().compareTo(s1.getClassName());
    }
}
