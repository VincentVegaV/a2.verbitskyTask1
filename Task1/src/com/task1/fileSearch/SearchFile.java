package com.task1.fileSearch;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchFile {
    private String filePath;
    private String fileExtension;
    //private String patternString;
    File f;
    File[] arrayFiles;
    Pattern p;

    SearchFile(String filePath, String fileExtension){
        this.filePath = filePath;
        this.fileExtension = fileExtension;
    }

    ResourceBundle resourceBundle = ResourceBundle.getBundle(
            "Resources.Messages", Locale.getDefault());
    ResourceBundle resourceBundleConfig = ResourceBundle.getBundle(
            "Resources.Config", Locale.getDefault());

    public Map<String, Long> returnListOfFileNameAndDate() throws IOException {

        //patternString = resourceBundleConfig.getString("patternString");
        String patternString = ".\\." + fileExtension + "$";

        f = new File(filePath);
        arrayFiles = f.listFiles();
        p = Pattern.compile(patternString);

        Map<String, Long> fileList = new LinkedHashMap<>();

        for (File arrayFile : arrayFiles) {
            Matcher m = p.matcher(arrayFile.getName());
            if (m.find() && !arrayFile.isDirectory()) {
                Path pa = Paths.get(arrayFile.getPath());
                BasicFileAttributes attr = Files.readAttributes(pa, BasicFileAttributes.class);

                fileList.put(arrayFile.getName(), attr.creationTime().toMillis());
            }
        }

        return fileList;
    }

}
