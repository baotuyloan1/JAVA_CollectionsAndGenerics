package com.baonguyen.praticecollection;

import java.util.Comparator;

public class JoinTimeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getJoinTime().compareTo(o2.getJoinTime());
    }
}
