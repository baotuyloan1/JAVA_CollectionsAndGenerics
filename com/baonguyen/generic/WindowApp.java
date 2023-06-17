package com.baonguyen.generic;

import javax.swing.*;

public class WindowApp <T extends JFrame & Runnable>{
    T theApp;
    public WindowApp(T app){
        theApp = app;
    }
}
