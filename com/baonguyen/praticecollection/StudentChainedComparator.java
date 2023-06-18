package com.baonguyen.praticecollection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//chain comparator
public class StudentChainedComparator implements Comparator<Student> {

    private List<Comparator<Student>> comparatorList;

    public StudentChainedComparator(Comparator<Student>...comparators) {
        this.comparatorList = Arrays.asList(comparators);
    }

    @Override
    public int compare(Student o1, Student o2) {
        for (Comparator<Student> comparator: comparatorList){
            int result = comparator.compare(o1,o2);
            if (result != 0){
                return result;
            }
        }
        return 0;
    }
}
