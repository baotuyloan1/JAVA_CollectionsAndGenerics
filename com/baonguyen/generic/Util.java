package com.baonguyen.generic;

import javax.swing.*;
import java.util.*;

public class Util<T> {

    // If the type parameter of a non-static generic method is same as the enclosing class, the indicator <T> is not required.
    public int count(T[] array, T item) {
//        code
        return 0;
    }

    //    Static generic method , the indicator <T> is required
//    We can use bounded type parameters to restrict the types
    public static <T extends Number> int count1(Collection<T> array, T item) {
        return 0;
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(0, 2, 3, 5, 1, 23, 5, 12, 2);
        int count = count1(integers, 2);
        System.out.println("#2 :" + count);

    }

    public static <T extends JComponent & Runnable> int count(Collection<T> collection, T item) {
        return 1;
    }


    public static <T, U> void paring(T first, U second) {
        Map<T, U> map = new HashMap<>();
        map.put(first, second);
    }

    public static int countWildCard(Collection<? extends Number> collection, Number item) {
        int count = 0;

        if (item == null) {
            for (Number element : collection) {
                if (element == null) count++;
            }
        } else {
            for (Number element : collection) {
                if (item.equals(element)) {
                    count++;
                }
            }
        }

        return count;
    }


}
