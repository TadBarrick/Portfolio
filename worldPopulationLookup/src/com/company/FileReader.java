package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
    private String filePath;
    private ArrayList<String> inputList = new ArrayList<>();
    private String fileName;

    public FileReader() {
        filePath= "";
    }

    public FileReader(String filePath) {

    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<String> readFile(String fileName) throws FileNotFoundException {
        String fullPath = filePath + "\\" + fileName;
        File newFile = new File(fullPath);
        if (newFile.exists()) {
            Scanner fileScanner = new Scanner(newFile);
            while (fileScanner.hasNext()) {
                inputList.add(fileScanner.nextLine());
            }
            fileScanner.close();
            return inputList;
        } else {
            System.out.println("File does not exist");
            return null;
        }
    }


}
