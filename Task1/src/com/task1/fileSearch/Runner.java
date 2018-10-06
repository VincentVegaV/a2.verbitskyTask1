package com.task1.fileSearch;

import java.io.IOException;

class Runner {

    public static void main(String[] args){
        SearchFile search = new SearchFile(args[0], args[1]);

        try{
            PrintFile.printFiles(SortFile.sortListOfFilesByDateDESC(search.returnListOfFileNameAndDate()));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
