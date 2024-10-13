package com.finalproject;

import java.io.File;

public class FilePath {
    final static String COMMON_PATH = "repo/SDEV200/final_project/src/main/";
    // get file Menu.json path
    public static String menuItem() {
        File file = new File(COMMON_PATH + "resources/Menu.json");
        return file.getAbsolutePath();
    }
    // get icon image path
    public static String iconImage() {
        File file = new File(COMMON_PATH + "images/favicon.ico");
        return file.getAbsolutePath();
    }
    // get remove icon image path
    public static String iconRemove() {
        File file = new File(COMMON_PATH + "images/delete-button.png");
        return file.getAbsolutePath();
    }
}
