package com.baonguyen.praticecollection;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingMultipleAttributes {
  public static void main(String[] args) {
    System.out.println("===== SORTING BY MULTIPLE ATTRIBUTES =====");
    List<Student> studentList = new ArrayList<>();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    try {
      studentList.add(new Student("Nguyen Duc Tai", "18IT1", dateFormat.parse("2023-06-18"), 21));
      studentList.add(new Student("Le Duc Tai", "18IT1", dateFormat.parse("2023-06-18"), 21));
      studentList.add(new Student("Nguyen Duc Khanh", "18IT5", dateFormat.parse("2023-06-20"), 21));
      studentList.add(new Student("Nguyen Duc Khanh", "18IT5", dateFormat.parse("2023-06-17"), 21));

      studentList.add(new Student("Le Duc Tai", "18IT1", dateFormat.parse("2023-06-18"), 21));
      studentList.add(new Student("Le Duong Bao Lam", "18IT1", dateFormat.parse("2023-06-18"), 21));
      studentList.add(new Student("Nguyen Duc Bao", "18IT5", dateFormat.parse("2023-06-19"), 21));
      studentList.add(new Student("Nguyen Duc Bao", "18IT5", dateFormat.parse("2023-06-16"), 21));
      studentList.add(new Student("Nguyen Duc Binh", "18IT4", dateFormat.parse("2023-06-18"), 21));
    } catch (ParseException e) {
      throw new RuntimeException(e);
    }

    for (Student student : studentList) {
      System.out.println(student);
    }
    Collections.sort(
        studentList,
        new StudentChainedComparator(
            new ClassNameComparator(), new NameComparator(), new JoinTimeComparator()));
    System.out.println("After sorting:");
    for (Student student : studentList) {
      System.out.println(student);
    }
  }
}
