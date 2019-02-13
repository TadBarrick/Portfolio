package com.company;
//Node.java
public class Node {
    int population;
    String countryName;
    Node left;
    Node right;

    public Node(String countryName, int population){
        this.countryName = countryName;
        this.population = population;
        left = null;
        right = null;
    }
}
