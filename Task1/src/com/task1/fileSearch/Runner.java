package com.task1.fileSearch;

import java.io.IOException;
import java.util.ResourceBundle;

class Runner {

    public static void main(String[] args){
        ResourceBundle resourceBundleConfig = ResourceBundle.getBundle("Resources.Config");
        String path = args[Integer.parseInt(resourceBundleConfig.getString("pathItem"))];
        String extension = args[Integer.parseInt(resourceBundleConfig.getString("extensionItem"))];
        SearchFile search = new SearchFile(path, extension);

        try{
            PrintFile.printFiles(SortFile.sortListOfFilesByDateDESC(search.returnListOfFileNameAndDate()));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
