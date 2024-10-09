package com.finalproject;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello World!");
        HandleData.getAllMenu();
        JFrame mainFrame = GUI.createFrame();
        GUI.loadMenuGUI(mainFrame);
        mainFrame.setVisible(true);
    }
}