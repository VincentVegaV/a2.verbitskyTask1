package com.Task1.MinusArray;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * "ArraySubtraction" class contain methods that can subtract
 * two string arrays in different ways: using arrays or collections.
 *
 * @author a2.verbitsky
 * @version 1.0
 */
class ArraySubtraction
{

    /**
     * Method subtract array2 from array1 (using indexes) and returns result array
     *
     * @param array1 string type array
     * @param array2 string type array
     * @return String type result array (array1 - array2)
     */
    String[] getSubtractedArray(String[] array1, String[] array2)
    {
        int len1 = array1.length;
        int len2 = array2.length;
        int resL = 0;
        int n = len1-len2;
        String[] res = new String[n];
        boolean isFound;

        for(int i=0; i<=len1-1; i++)
        {
            isFound = false;
            for(int j=0; j<=len2-1; j++)
            {
                if(array1[i].equals(array2[j]))
                {
                    isFound = true;
                }
            }
            if (!isFound)
            {
                res[resL] = array1[i];
                resL++;
            }
        }
        return res;
    }

    /**
     * Method subtract array2 from array1 (using collections) and returns result array
     *
     * @param array1 string type array
     * @param array2 string type array
     * @return String type result arrayList (collection1 - collection2)
     */
    ArrayList<String> getSubtractedCollection(String[] array1, String[] array2)
    {
        ArrayList<String> arrayList1 = new ArrayList<>(Arrays.asList(array1));
        ArrayList<String> arrayList2 = new ArrayList<>(Arrays.asList(array2));

        arrayList1.removeAll(arrayList2);

        return arrayList1;
    }

}