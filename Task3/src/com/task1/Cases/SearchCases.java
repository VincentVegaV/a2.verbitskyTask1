package com.task1.Cases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class SearchCases {
    private String path;

    private String line = null;


    SearchCases(String path){
        this.path = path;
    }

    List<String> searchAndReturnCasesFromFile() throws IOException {
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> casesList = new ArrayList<>();

        while ((line = bufferedReader.readLine()) != null){
            casesList.add(line);
        }

        return casesList;
    }



}
