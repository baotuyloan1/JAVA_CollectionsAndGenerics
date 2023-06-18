package com.baonguyen.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EmployeeChainedComparator implements Comparator<Employee> {

    private List<Comparator<Employee>> listComparators;

    public EmployeeChainedComparator() {
    }

    public EmployeeChainedComparator(Comparator<Employee> ...comparators) {
        this.listComparators = Arrays.asList(comparators);
    }

    @Override
    public int compare(Employee e1, Employee e2) {
        for (Comparator<Employee> comparator: listComparators){
            int result = comparator.compare(e1,e2);
            if (result != 0){
                return  result;
            }
        }
        return 0;
    }
}
