package com.baonguyen.generic;

//T is called type parameter of the GeneralDAO
//T stands for any type.
//THe generalDAO class is said to be generified
//People can be any class or interface
//Extends keyword is used for both class and interface in the cased of bounded type parameter
public class GeneralDAO<T extends People> {
    public void save(T entity){
//        code to save entity details to database
    }

    public T get (long id){

//        code to get details from database..
//        return a T object

        return null;
    }


}
