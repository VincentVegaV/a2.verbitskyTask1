package com.task1.Cases;

import java.io.IOException;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        SearchCases search = new SearchCases(args[0]);
        //нужно чтобы пропуск второго значения засчитывался за null
        CaseSelection select = new CaseSelection(args[0], args[1]);
        List<String> initialList;

        try{
            initialList = search.searchAndReturnCasesFromFile();

            for (String x:
                    select.cutAndPaste(initialList)) {
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
