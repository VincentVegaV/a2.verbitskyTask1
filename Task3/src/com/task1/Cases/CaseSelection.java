package com.task1.Cases;

import java.util.List;
import java.util.Random;


class CaseSelection {

    void cutAndPaste(List<String> initialList, List<String> resultList, Integer numberCases) {

        Random rand = new Random();

        if(initialList.size() >= numberCases){
            for (int i = 0; i < numberCases; i++) {
                int randomIndex = rand.nextInt(initialList.size());
                resultList.add(i, initialList.get(randomIndex));
                initialList.remove(randomIndex);
            }
        }else if(initialList.size() < numberCases){
                System.out.println("Not enough cases to select. You have only " + initialList.size() + " case(s) in the file.");
        }
    }
}
