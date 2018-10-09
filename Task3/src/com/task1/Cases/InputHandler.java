package com.task1.Cases;

import java.util.Scanner;
import java.io.*;


public class InputHandler {
    /**Field for saving file path string*/
    private String path = "";
    /**Field for saving number of cases string*/
    private String number = "";
    /**New instance of File*/
    File fileChecker;

    Scanner scanner = new Scanner(System.in);

    String getPath() {

        while (path.trim().equals("")) {
            System.out.println("Enter absolute Path:");
            path = scanner.nextLine();
        }
        fileChecker = new File(path);

        while (!fileChecker.exists()) {
            System.out.println("File doesn't exist.");
            path = scanner.nextLine();
            fileChecker = new File(this.path);
        }

        return path;
    }

    /**
     * Method set default value in case user leave "Number" input empty
     *
     * @return integer number of cases
     */
    Integer getNumber() {
        System.out.println("Enter number (Press ENTER to set default):");

        number = scanner.nextLine();

        if (number.trim().equals("")) {
            number = "10";
            System.out.println("Default number is " + number + ".");
        }

        return Integer.parseInt(number);
    }

}
