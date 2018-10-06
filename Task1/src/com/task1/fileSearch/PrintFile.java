package com.task1.fileSearch;

import java.nio.file.attribute.FileTime;
import java.time.ZoneId;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

 class PrintFile {
     private static int fileCount;

     static void printFiles(Map<String, FileTime> list){

        ResourceBundle resourceBundleConfig = ResourceBundle.getBundle("Resources.Config");
        ResourceBundle resourceBundle = ResourceBundle.getBundle(
                 "Resources.Messages", Locale.getDefault());

        Map.Entry<String, FileTime> newestFile = list.entrySet().iterator().next();
        long value = newestFile.getValue().toMillis() - Long.parseLong(resourceBundleConfig.getString("timeDifference"));

        for (Map.Entry<String, FileTime> mapEntry : list.entrySet()){
            if(mapEntry.getValue().toMillis() >= value){
                System.out.println(mapEntry.getKey() + ": \n" + mapEntry.getValue().toInstant().atZone(ZoneId.systemDefault()) + resourceBundle.getString("newLine"));
                ++fileCount;
            }
        }
        System.out.println(resourceBundle.getString("found") + fileCount);
    }

}
