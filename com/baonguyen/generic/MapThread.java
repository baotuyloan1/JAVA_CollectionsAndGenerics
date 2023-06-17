package com.baonguyen.generic;

import java.util.HashMap;
import java.util.Map;

public class MapThread<T extends Number, U extends Runnable>{
    private Map<T,U> map = new HashMap<>();

    public void put(T num, U thread){
        map.put(num, thread);
    }
}
