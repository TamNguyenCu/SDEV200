package com.finalproject;

import java.io.File;

public class FilePath {
    final static String COMMON_PATH = "repo/SDEV200/final_project/src/main/";

    public static String menuItem() {
        File file = new File(COMMON_PATH + "resources/Menu.json");
        return file.getAbsolutePath();
    }
}
