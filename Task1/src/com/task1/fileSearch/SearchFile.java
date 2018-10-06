package com.task1.fileSearch;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

 class SearchFile {
    private String filePath;
    private String fileExtension;

     SearchFile(String filePath, String fileExtension){
        this.filePath = filePath;
        this.fileExtension = fileExtension;
    }

    private ResourceBundle resourceBundleConfig = ResourceBundle.getBundle("Resources.Config");

     Map<String, FileTime> returnListOfFileNameAndDate() throws IOException, NullPointerException {

        String patternString = resourceBundleConfig.getString("patternString") + fileExtension;

        File f = new File(filePath);
        File[] arrayFiles = f.listFiles();
        Pattern p = Pattern.compile(patternString);

        Map<String, FileTime> fileList = new LinkedHashMap<>();

        for (File arrayFile : arrayFiles) {
            Matcher m = p.matcher(arrayFile.getName());
            if (m.find() && !arrayFile.isDirectory()) {
                Path pa = Paths.get(arrayFile.getPath());
                BasicFileAttributes attr = Files.readAttributes(pa, BasicFileAttributes.class);

                fileList.put(arrayFile.getName(), attr.creationTime());
            }
        }

        return fileList;
    }

}
