package com.task1.Cases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

public class PrintToFile {
    String path;
    String resultFileName;
    ResourceBundle resourceBundleConfig = ResourceBundle.getBundle("Resources.config");

    //нужно либо сделать один метод для печати обоих файлов
    //либо метод, который можно переиспользовать для каждого файла поотдельности
    //(есть сложность, т.к. для второго файла нужно вывести путь в консоль, а для первого нет)
    void printCases(List<String> list, String path) throws IOException {
        File file = new File(path);
        resultFileName = file.getPath().replaceFirst(resourceBundleConfig.getString("regex"),
                resourceBundleConfig.getString("replacement"));
        File resultFile = new File(resultFileName);

        FileWriter writer = new FileWriter(file, false);
        for (String x:
                list) {
            writer.write("\n" + x);
        }
    }

}
