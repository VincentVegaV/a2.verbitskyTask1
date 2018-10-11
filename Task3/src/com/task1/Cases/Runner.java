package com.task1.Cases;

public class Runner {
    public static void main(String[] args) {
        FileOperations runApp = new FileOperations();
        runApp.cutAndSaveCases();


        SearchCases search = new SearchCases(args[0]);


    }
}
