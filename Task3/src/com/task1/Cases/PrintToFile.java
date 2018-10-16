package com.task1.Cases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

class PrintToFile {
    private String resultFileName;
    private ResourceBundle resourceBundleConfig = ResourceBundle.getBundle("Resources.config");

    void printCasesToFiles(List<String> initialList, List<String> resultList, String path) throws IOException {
        File initialFile = new File(path);
        resultFileName = initialFile.getPath().replaceFirst(resourceBundleConfig.getString("regex"),
                resourceBundleConfig.getString("replacement"));
        File resultFile = new File(resultFileName);

        FileWriter initialWriter = new FileWriter(initialFile, false);
        for (String x:
                initialList) {
            initialWriter.write(x + "\n");
        }
        FileWriter resultWriter = new FileWriter(resultFile, false);
        for (String q:
                resultList){
            resultWriter.write(q + "\n");
        }
        initialWriter.close();
        resultWriter.close();

        System.out.println(resultFileName);
    }
}
