package com.task1.Cases;

import java.io.*;
import java.util.*;


public class FileOperations {

    private int count;

    private String line = null;

    private String header = null;

    private String resultFileName;

    private List<String> casesList = new ArrayList<>();

    private List<String> resultList = new ArrayList<>();

    private InputHandler inputHandler = new InputHandler();
    private CaseSelection caseSelection = new CaseSelection();


    void cutAndSaveCases(){

        ResourceBundle resourceBundleConfig = ResourceBundle.getBundle("Resources.config");

        File file = new File(inputHandler.getPath());

        resultFileName = file.getPath().replaceFirst(resourceBundleConfig.getString("regex"),
                                                resourceBundleConfig.getString("replacement"));
        File resultFile = new File(resultFileName);

        try{
            count = inputHandler.getNumber();
        }
        catch (InputMismatchException | NumberFormatException e){
            System.out.println("Is not an integer number.");
        }

        try{
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null){
                casesList.add(line);
            }
            header = casesList.get(0);
            casesList.remove(0);

            caseSelection.cutAndPaste(casesList, resultList, count);

            FileWriter writer = new FileWriter(file, false);
            writer.write(header);

            for (String x:
                    casesList) {
                writer.write("\n" + x);
            }

            FileWriter writerResult = new FileWriter(resultFile, false);
            writerResult.write(header);

            for (String q:
                    resultList) {
                writerResult.write("\n" + q);
            }

            System.out.println(resultFile.getPath());

            bufferedReader.close();
            writer.close();
            writerResult.close();
        }catch (IOException e){
            System.out.println("File not found.");
        }
    }
}
