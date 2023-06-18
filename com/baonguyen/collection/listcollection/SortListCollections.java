package com.baonguyen.collection.listcollection;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//the sort operation uses a merge sort algorithm
//Fast: it guarantees O(n log n) performance in average and worst cases, and runs faster if the original list is nearly sorted.
//Stable: it preservers the order the equal elements so it’s useful for sorting the list repeatedly on different attributes.
public class SortListCollections {

    public static void main(String[] args) {
        List<String> listStrings = Arrays.asList("Orange", "Grape", "Apple", "Lemon", "Banana");

        System.out.println("Before sorting: " + listStrings);

        Collections.sort(listStrings);

        System.out.println("After sorting: " + listStrings);

        List<Character> listCharacters = Arrays.asList('F', 'C', 'A', 'B', 'Z', 'E', 'K', 'P');

        System.out.println("Before sorting: " + listCharacters);

        Collections.sort(listCharacters);

        System.out.println("After sorting: " + listCharacters);

        List<Integer> listIntegers = Arrays.asList(1, 6, 9, 3, 2, 0, 8, 4, 7, 5);

        System.out.println("Before sorting: " + listIntegers);

        Collections.sort(listIntegers);

        System.out.println("After sorting: " + listIntegers);

        List<Date> listDates = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            listDates.add(dateFormat.parse("2023-06-16"));
            listDates.add(dateFormat.parse("2023-06-17"));
            listDates.add(dateFormat.parse("2023-06-15"));
        }catch (ParseException exception){
            System.err.println(exception);
        }
        System.out.println("Before sorting: " + listDates);

        Collections.sort(listDates);

        System.out.println("After sorting: " + listDates);

//        Reversing sort order
        List<Integer> listIntegers1 = Arrays.asList(1, 6, 9, 3, 2, 0, 8, 4, 7, 5);

        System.out.println("Before sorting: " + listIntegers1);

        Collections.sort(listIntegers1);

        System.out.println("After sorting: " + listIntegers1);

        //        The reverse(list) method doesn't sort the list, it just re-order the list's elements in the reverse order.
//        Do đó, danh sách phải được sắp xếp bằng phương thức sort(list) trước khi đảo ngược thứ tự để có được danh sách được sắp xếp theo thứ tự giảm dần.
        Collections.reverse(listIntegers1);

        System.out.println("After reversing: " + listIntegers1);


        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Tom",45,8000));
        employeeList.add(new Employee("Sam",56,7500));
        employeeList.add(new Employee("Alex",30,12000));
        employeeList.add(new Employee("Peter",25,6000));
        System.out.println("Before sorting: "+employeeList);
        Collections.sort(employeeList);
        System.out.println("after sorting: "+employeeList);

        System.out.println("-------------");
        List<Employee> employeeList1 = new ArrayList<>();
        employeeList1.add(new Employee("Tom",45,8000));
        employeeList1.add(new Employee("Sam",56,7500));
        employeeList1.add(new Employee("Alex",30,12000));
        employeeList1.add(new Employee("Peter",25,6000));
        System.out.println("Before sorting age: "+employeeList1);
        Collections.sort(employeeList1, new EmployeeAgeComparator());
        System.out.println("after sorting age: "+employeeList1);





    }
}
