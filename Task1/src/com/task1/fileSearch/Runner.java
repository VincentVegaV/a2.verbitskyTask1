package com.task1.fileSearch;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

class Runner {
    public static void main(String[] args){
        //sortByPath sbp = new sortByPath("D:\\1", "bmp");
        //sbp.findFiles();

        SearchFile search = new SearchFile("D:\\1", "bmp");

        ResourceBundle resourceBundle = ResourceBundle.getBundle(
                "Resources.Messages", Locale.getDefault());

        try{
            System.out.println(resourceBundle.getString("found"));
            for (Map.Entry<String, Long> entry :
                    SortFile.sortListOfFilesDESC(search.returnListOfFileNameAndDate()).entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue().toString());
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
