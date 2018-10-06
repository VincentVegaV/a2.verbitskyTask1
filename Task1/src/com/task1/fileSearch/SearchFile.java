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
    private File f;
    private File[] arrayFiles;
    private Pattern p;

    SearchFile(String filePath, String fileExtension){
        this.filePath = filePath;
        this.fileExtension = fileExtension;
    }

    ResourceBundle resourceBundleConfig = ResourceBundle.getBundle(
            "Resources.Config", Locale.getDefault());

     Map<String, FileTime> returnListOfFileNameAndDate() throws IOException {

        //patternString = resourceBundleConfig.getString("patternString");
        String patternString = ".\\." + fileExtension + "$";

        f = new File(filePath);
        arrayFiles = f.listFiles();
        p = Pattern.compile(patternString);

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
