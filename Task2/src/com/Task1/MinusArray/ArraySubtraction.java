package com.Task1.MinusArray;

import java.util.ArrayList;
import java.util.Arrays;

class ArraySubtraction
{

    String[] getSubtractedArray(String[] array1, String[] array2) {
        int resL = 0;
        String[] res = new String[array1.length];
        boolean isFound;

        for(int i=0; i<=array1.length-1; i++) {
            isFound = false;
            for(int j=0; j<=array2.length-1; j++) {
                if(array1[i].equals(array2[j])) {
                    isFound = true;
                }
            }
            if (!isFound) {
                res[resL] = array1[i];
                resL++;
            }
        }
        String[] dest_arr = new String[resL];
        System.arraycopy(res, 0, dest_arr,
                0, resL);

        return dest_arr;
    }

    ArrayList<String> getSubtractedCollection(String[] array1, String[] array2) {
        ArrayList<String> arrayList1 = new ArrayList<>(Arrays.asList(array1));
        ArrayList<String> arrayList2 = new ArrayList<>(Arrays.asList(array2));

        arrayList1.removeAll(arrayList2);

        return arrayList1;
    }

}