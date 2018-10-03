package com.task1.fileSearch;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static com.task1.fileSearch.SortByDate.*;
import static com.task1.fileSearch.SortByName.*;

class sortByPath {
    private int fileCount;
    private String filePath;
    private String fileExtension;

    sortByPath(String filePath, String fileExtension){
        this.filePath = filePath;
        this.fileExtension = fileExtension;
    }

    ResourceBundle resourceBundle = ResourceBundle.getBundle(
            "Resources.Messages", Locale.getDefault());

    void findFiles() {

        try {
            final String patternString;
            patternString = "." + "\\." + fileExtension + "$";

            File f = new File(filePath);

            Pattern p = Pattern.compile(patternString);

            File[] arrayFiles = f.listFiles();

            ArrayList<FileTime> foundDates = new ArrayList<>();
            ArrayList<String> foundNames = new ArrayList<>();

            for (File arrayFile : arrayFiles) {
                Matcher m = p.matcher(arrayFile.getName());
                if (m.find() && !arrayFile.isDirectory()) {
                    Path pa = Paths.get(arrayFile.getPath());
                    BasicFileAttributes attr = Files.readAttributes(pa, BasicFileAttributes.class);

                    foundDates.add(attr.creationTime());
                    foundNames.add(arrayFile.getName());

                    fileCount++;
                }
            }




            System.out.print(resourceBundle.getString("found") + fileCount);

                System.out.println(resourceBundle.getString("newestFileName") + SortByName.getNewestFileName(foundDates, foundNames));
                System.out.println(resourceBundle.getString("newestFileDate") + getNewestFileDate(foundDates).toInstant().atZone(ZoneId.systemDefault()));

                ArrayList<FileTime> t;
                ArrayList<String> n;
                t = getListFileDate(getNewestFileDate(foundDates), foundDates, foundNames);
                n = getListFileName(getNewestFileDate(foundDates), foundDates, foundNames);

                System.out.println(resourceBundle.getString("listFiles"));

                sortByDate(t, n);

                for(int i=0; i < n.size(); i++) {
                    System.out.println((i+1) + ") " + n.get(n.size()-i-1));
                    System.out.println("Date: " + t.get(t.size()-i-1).toInstant().atZone(ZoneId.systemDefault()));
                }

        } catch (NullPointerException | ArrayIndexOutOfBoundsException | IOException e) {
            e.printStackTrace();
        }
    }
}