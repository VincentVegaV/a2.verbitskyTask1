package com.task1.Cases;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

public class Runner {
    public static void main(String[] args) {
        ResourceBundle resourceBundleConfig = ResourceBundle.getBundle("Resources.config");
        String path = args[Integer.parseInt(resourceBundleConfig.getString("firstItem"))];
        SearchCases search = new SearchCases(path);
        PrintToFile print = new PrintToFile();
        String numberCases;
        List<String> initialList;

        if(args.length == Integer.parseInt(resourceBundleConfig.getString("numberParameters"))){
            numberCases = args[Integer.parseInt(resourceBundleConfig.getString("secondItem"))];
        }else{
            numberCases = resourceBundleConfig.getString("defaultNumberOfCases");
        }

        CaseSelection select = new CaseSelection(numberCases);

        try{
            initialList = search.searchAndReturnCasesFromFile();
            print.printCasesToFiles(initialList, select.cutAndPaste(initialList), path);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
