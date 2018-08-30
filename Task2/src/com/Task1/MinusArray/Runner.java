package com.Task1.MinusArray;

public class Runner {
    public static void main(String[] args)
    {
        ArrayData arr = new ArrayData();
        ArraySubtraction subs = new ArraySubtraction();

        for(String x : subs.getSubtractedArray(arr.array1, arr.array2))
        {
            System.out.print(x + " ");
        }

        System.out.print("\n");

        for(String z : subs.getSubtractedCollection(arr.array1, arr.array2))
        {
            System.out.print(z + " ");
        }
    }
}
