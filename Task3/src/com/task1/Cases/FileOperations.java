package com.task1.Cases;

import java.io.*;
import java.util.*;

/**
 * "FileOperations" class summarize functions from:
 * @see CaseSelection
 * @see InputHandler
 *
 * @author a2.verbitsky
 * @version 1.0
 */
public class FileOperations {
    /**Field contains count of selected cases from the console input*/
    private int count;
    /**Field for saving lines of text from a file*/
    private String line = null;
    /**Filed for saving header line from cases table*/
    private String header = null;
    /**Field for saving result file name*/
    private String resultFileName;
    /**Collection for saving cases from initial file*/
    private List<String> casesList = new ArrayList<>();
    /**Collection for saving cases for result file*/
    private List<String> resultList = new ArrayList<>();

    private InputHandler inputHandler = new InputHandler();
    private CaseSelection caseSelection = new CaseSelection();

    /**
     * Method saves cases from initial file, select and remove cases using {@link CaseSelection} and
     * write results back to collections {@link FileOperations#casesList}, {@link FileOperations#resultList}.
     * Returns path to result file
     */
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
