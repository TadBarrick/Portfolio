package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner inputScanner = new Scanner(System.in);
        Scanner myScanner = new Scanner(new FileReader(new File("C:\\Users\\barrejoh004\\Downloads\\WorldPopulation.txt")));
        String userInput = "";
        String mystring = "";
        Scanner scanboi = new Scanner(System.in);
        BinaryTree binaryTree = new BinaryTree();
        System.out.println("Please enter a Country to find the population.");
        userInput = scanboi.nextLine().toLowerCase();

        while (myScanner.hasNext()) {

                // Change the following to a ArrayList:
                String myguy = myScanner.nextLine().toLowerCase();
                String[] inputy = myguy.split(",");

                int population = Integer.parseInt(inputy[2]);
                binaryTree.insertNode(inputy[0].toLowerCase(), population);

        }
        if (binaryTree.findNode(userInput)) {
            System.out.println("The population is :"+binaryTree.readNode(userInput));
        } else {
            System.out.println("Sorry dude. That country can't be found");
        }
    }


}
