package com.task1.Cases;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;


class CaseSelection {
    private ResourceBundle resourceBundleConfig = ResourceBundle.getBundle("Resources.config");

    List<String> cutAndPaste(List<String> initialList, String numberCases){
        int n = Integer.parseInt(numberCases);
        int headerPosition = Integer.parseInt(resourceBundleConfig.getString("headerPosition"));
        String header = initialList.get(headerPosition);
        initialList.remove(headerPosition);
        List<String> resultList = new ArrayList<>();

        Random rand = new Random();

        if(initialList.size() >= n){
            for (int i = 0; i < n; i++) {
                int randomIndex = rand.nextInt(initialList.size());
                resultList.add(i, initialList.get(randomIndex));
                initialList.remove(randomIndex);
            }
        }else{
            System.out.println("Not enough cases to select. You have only " + initialList.size() + " case(s) in the file.");
        }
        initialList.add(headerPosition, header);
        resultList.add(headerPosition, header);

        return resultList;
    }
}
