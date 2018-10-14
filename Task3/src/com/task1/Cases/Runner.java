package com.task1.Cases;

import java.io.IOException;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        SearchCases search = new SearchCases(args[0]);
        CaseSelection select = new CaseSelection();
        List<String> initialList;

        try{
            initialList = search.searchAndReturnCasesFromFile();

            for (String x:
                    select.cutAndPaste(initialList, args[1])) {
                System.out.println("\n" + x);
            }

            System.out.println("initial");

            for (String q:
                    initialList) {
                System.out.println("\n" + q);
            }

        }catch(IOException e){
            e.printStackTrace();
        }


    }
}
