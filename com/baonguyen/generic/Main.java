package com.baonguyen.generic;

public class Main {

    public static void main(String[] args) {
        GeneralDAO<Student> studentDAO = new GeneralDAO<>();
        Student newStudent = new Student();
        studentDAO.save(newStudent);
        Student oldStudent = studentDAO.get(100);

        GeneralDAO<Professor> professorGeneralDAO = new GeneralDAO<>();
        Professor newProfessor = new Professor();
        professorGeneralDAO.save(newProfessor);
        Professor oldProfessor = professorGeneralDAO.get(100);

//        T is just a name of type parameter, like a variable name.
//        naming type conventions: T for type; E for element; K for key; V for value ...

//        with bounded type definition, the GeneralDAO class can be used only work with sub types of People,
//        not with every type
//        Because Integer is not a sub type of People, so will receive
//     "Type parameter 'java.lang.Integer' is not within its bound; should implement 'com.baonguyen.generic.People'"
//        GeneralDAO<Integer> dao = new GeneralDAO<Integer>();
//        dao.save(new Integer());
        String[] helloWorld = {"h", "e", "l", "l", "o", "w", "o", "r", "l", "d"};
        int count = count(helloWorld, "l");
        System.out.println("#occurrences of l: " + count);

        Integer[] integers = {1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0};
        int count1 = count1(helloWorld, "l");
        System.out.println("1 #occurrences of l: " + count1);

        int count2 = count1(integers, 0);
        System.out.println("#occurrences of zeros: " + count2);
    }

    public static int count(String[] array, String item) {
        int count = 0;
        if (item == null) {
            for (String s : array) {
                if (s == null) count++;
            }
        } else {
            for (String s : array) {
                if (item.equals(s)) {
                    count++;
                }
            }
        }
        return count;
    }

//    - The <T> is always placed before the return type of the method. It indicates that the T identifier is a type parameter, to distinguish it with concrete types.
    public static <T> int count1(T[] array, T item){
        int count = 0;
        if (item == null){
            for (T element: array){
                if (element ==null) count++;
            }
        }else {
            for (T element:array){
                if (item.equals(element)){
                    count++;
                }
            }
        }
        return count;
    }

}
