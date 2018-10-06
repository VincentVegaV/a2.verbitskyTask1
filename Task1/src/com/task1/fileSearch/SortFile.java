package com.task1.fileSearch;


import java.nio.file.attribute.FileTime;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

 class SortFile {

     static Map<String, FileTime> sortListOfFilesDESC(Map<String, FileTime> unsortedMap){

        Map<String, FileTime> sortedMap = unsortedMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        return sortedMap;
    }

}
