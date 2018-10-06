package com.task1.fileSearch;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

class Runner {
    public static void main(String[] args){
        SearchFile search = new SearchFile("E:\\test", "bmp");

        ResourceBundle resourceBundle = ResourceBundle.getBundle(
                "Resources.Messages", Locale.getDefault());
        try{
            System.out.println(resourceBundle.getString("found"));

            PrintFile.printFiles(SortFile.sortListOfFilesDESC(search.returnListOfFileNameAndDate()));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
