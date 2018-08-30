package com.task1.Cases;

import java.util.List;
import java.util.Random;

/**
 * Class contain methods that define how to select cases
 *
 * @author a2.verbitsky
 * @version 1.0
 */
public class CaseSelection {

    /**
     * Method creates Random() instance and validate:
     * - if count of cases in the initial file >= number of entered cases, numberCases will be removed
     * from initial list and add to result list
     * - if count of cases in the initial file < number of entered cases, selection won't be performed
     *
     * @param initialList list of cases from selected txt file
     * @param resultList list of cases that will be added to result file
     * @param numberCases count of cases to select from selected file
     */
    public void cutAndPaste(List<String> initialList, List<String> resultList, Integer numberCases) {

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
