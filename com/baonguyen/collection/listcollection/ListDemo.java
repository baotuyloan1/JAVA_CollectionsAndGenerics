package com.baonguyen.collection.listcollection;

import java.util.*;

public class ListDemo {

    public static void main(String[] args) {
//        mỗi lần thêm vào nó không đủ sẽ tạo 1 mảng mới rồi chép data từ mảng cũ sang mảng mới => chậm hơn khi
//        thêm vào 1 phần tử
//        Truy cập nhanh hơn vì truy cập theo index của mảng
//        Lưu ý rằng việc thu nhỏ kích thước mảng có thể là một quá trình tốn kém về mặt hiệu năng, vì nó đòi hỏi sao chép các phần tử sang một mảng mới có kích thước nhỏ hơn. Do đó, bạn cần cân nhắc sử dụng trimToSize() chỉ khi thực sự cần thiết để giảm tài nguyên bộ nhớ.
//        Nếu phần tử bị xóa không phải là phần tử cuối cùng, ArrayList sẽ di chuyển tất cả các phần tử nằm sau phần tử bị xóa lên một vị trí để lấp đầy khoảng trống. Khi đó, kích thước của ArrayList sẽ giảm đi 1.
        List<String> listStrings = new ArrayList<>();
        listStrings.add("One");
        listStrings.add("Two");
        listStrings.add("three");
        System.out.println(listStrings);


//        Nhanh hơn khi thêm vào 1 phần tử vì nó chỉ cần lấy node cuối cùng và chỉ đến địa chỉ của node mới là xong
//        Truy cập phần tử chậm hơn vì phải duyệt qua từng phần tử trong mảng
        List<String> listStrings1 = new LinkedList<>();
        listStrings1.add("Five");
        listStrings1.add("Six");
        listStrings1.add("seven");
        System.out.println(listStrings1);

        List<Integer> listNumbers = List.of(1, 2, 3, 4, 5);

//        java 10
        var integers = new ArrayList<Integer>();

//        Nếu biết số lượng phần tử cụ thế cần chứa thì nên định nghĩa luôn, để nó khỏi phải tạo mảng nhiều lần, copy mảng nhiều lần  => tăng performance
        List<Integer> listNumbers2 = new ArrayList<>(1000);

//        có thể xây dụng 1 list lấy các phần tử từ 1 existing collection. Ví dụ:
//        copy các elements từ numberSet sang integerList
        Set<Integer> numberSet = new LinkedHashSet<>(List.of(3, 5, 1, 2));
        List<Number> integerList = new ArrayList<>(numberSet);


        List<String> stringList = new ArrayList<>();
        stringList.add(0, "Four");
        System.out.println("String list" + stringList);

//        Add all collection
        integerList.addAll(numberSet);
//        That inserts all elements of the numberSet collection at first position of the integerList collection.
        integerList.addAll(0, numberSet);

        String element = listStrings.get(0);
        List<String> linkedList = new LinkedList<>();
//        LinkedList implements can't get by index
        LinkedList<Number> numbers = new LinkedList<>();
        numbers.addAll(List.of(1, 3, 5));
        Number first = numbers.getFirst();
        Number last = numbers.getLast();
//        getFirst() và getLast() methods are specific to the LinkedList class;

//        Updating elements in a List
//        replace 3rd element in the list by new String "Hi"
        listStrings.set(2, "Hi");

//        remove elements from a list
        listStrings.remove(1);
        listStrings.remove("Hi");
        numberSet.remove(-1);
//        remove(object) method
//        it compares the specified object with the elements in the list using their equals() method,method, so if you use your own defined object type, make sure it implements the equals() method correctly.
//        It only removes the first occurrence of the specified element in the list (i.e. if a list contains duplicate elements, only the first element is removed).
//        it returns true if the list contained the specified element, or false otherwise. Thus it's recommended to check return value of this method
//        khoong chứa element ten mà remove nó cũng false;
        if (listStrings.remove("Ten")) {
            System.out.println("Removed");
        } else {
            System.out.println("There is no such element");
        }

//        remove all list
        listStrings.clear();

        for (Number number : numberSet) {
            System.out.println(number);
        }

        Iterator<Integer> iterator = numberSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


        Iterator<String> iterator1 = linkedList.listIterator();
        Iterator<String> iterator2 = linkedList.iterator();

//        From java 8
        listStrings.forEach(s -> System.out.println(s));

//        search element in a list


//        các phương thức này so sánh elements bằng cách sử dụng equals() method,so if you define your own type, make sure it implements the equals() method correctly.
//        returns trueif the list contains the specified element.
        if (listStrings.contains("Hello")) {
            System.out.println("Found the element");
        } else {
            System.out.println("THere is no such element");
        }

//         returns the index of the first occurrence of the specified element in the list, or -1 if the element is not found.
        int firstIndex = listStrings.indexOf("hi");
        linkedList.indexOf("hi");
//         returns the index of the last occurrence of the specified element in the list, or -1 if the element is not found.
        int lastIndex = listStrings.lastIndexOf("hi");

//        before Java 8
        List<String> listStrings2 = new ArrayList<>();
        listStrings2.add("D");
        listStrings2.add("B");
        listStrings2.add("C");
        listStrings2.add("E");
        System.out.println("listStrings2 before sorting: " + listStrings2);
        //        note that all elements in the list must implement the Comparable interface, so if you defind your own type, make sure it implements that interface and its compareTo()
        // thì mới dùng Collections.sort đuược
        Collections.sort(listStrings2);
        System.out.println("listStrings2 affter sorting: " + listStrings2);


//        since java 8, List interface introduces the sort() method.
        listStrings2.sort(null);

//        Copying elements from one list into another
        List<String> sourceList = new ArrayList<>();
        sourceList.add("A");
        sourceList.add("B");
        sourceList.add("C");
        sourceList.add("D");

//        Note that the destination list must ben large enough to contain the entire source list
//        2 phần tử sẽ bị lỗi Exception in thread "main" java.lang.IndexOutOfBoundsException: Source does not fit in dest
//        nên có lớn hơn hoặc = 4 length
//        nó thay thế từ đầu đến hết list source. nếu list dest nhiều phần tử thì nó dữ nguyên các phần tử có index > length - 1 của list source
        List<String> destList = new ArrayList<>();
        destList.add("V");
        destList.add("W");
        destList.add("B");
        destList.add("Z");
        destList.add("M");
        destList.add("B");
        System.out.println("destList before copy: " + destList);
        Collections.copy(destList, sourceList);
        System.out.println("destList after copy: " + destList);

//        Shuffling(xáo trộn) elements in a List
        List<Integer> numbers3 = new ArrayList<>();
        int i = 0;
        for (; i <= 10; ) {
            numbers3.add(i);
            i++;
        }
        System.out.println("List before shuffling: " + numbers3);
        Collections.shuffle(numbers3);
        System.out.println("after shuffling: " + numbers3);

// Extracting a portion of a list
        List<String> listNames = Arrays.asList("Tom", "John", "Mary", "Peter", "David", "Alice");
        System.out.println("Original list: " + listNames);
        List<String> subList = listNames.subList(2, 5);
        System.out.println("Sub list: " + subList);
//        Note that the sub list is just a view of the original list, so any modifications made the original list will reflect in the sub list
        listNames.set(3, "Bao");
        System.out.println(subList);

//        Converting between Lists and arrays
//        The Arrays.asList(T… a) method converts an array of type T to a list of type T. Here’s an example:
//        Note that the returned array contains copies of elements in the list, which that mean we can safely modify the array without affecting the list
        List<String> listNames3 = Arrays.asList("John", "Peter", "Tom", "Mary", "David", "Sam");
        List<Integer> listNumbers3 = Arrays.asList(1, 3, 5, 7, 9, 2, 4, 6, 8);
        System.out.println(listNames3);
        System.out.println(listNumbers3);

        List<Integer> listWords = new ArrayList<>(listNumbers3);
        Object[] arrayWords = listWords.toArray();

        Integer[] words = listWords.toArray(new Integer[0]);
        Integer[] numbers1 = listNumbers.toArray(new Integer[0]);
        for (Integer integer : words) {
            System.out.println("integer : " + integer);
        }

//        list to Stream
//        From Java 8, you can convert a List to a stream to take advantages of the Streams API
        int sum = new ArrayList<Integer>(Arrays.asList(numbers1)).stream().reduce(0, (x, y)-> x+y);
        System.out.println(sum);

//        Concurrent(đồng bộ) lists
//        By default, ArrayList and LinkedList are not thread-safe, so if you want to use them in concurrent context, you have to synchronize them externally using the Collections.synchronizedList() static method which returns a synchronized list that wraps the specified list. For example:
        List<Objects> unsafeList = new ArrayList<>();
        List<Objects> safeList = Collections.synchronizedList(unsafeList);

//       Luu y phai dong bộ hóa danh sách trả về 1 cách thủ công khi lặp qua nó:
        synchronized (safeList){
            Iterator<Objects> iterator3 = safeList.iterator();
            while (iterator3.hasNext()){
                System.out.println(iterator3.next());
            }
        }
    }
}
