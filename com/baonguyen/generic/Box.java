package com.baonguyen.generic;

import javax.swing.*;
import java.util.List;

public class Box <T extends JComponent>{
    private List<T> list;

    public void add (T comp){
        list.add(comp);
    }
}
