package com.company;
 //BinaryTree.java;
    public class BinaryTree {

        public static Node root;

        public BinaryTree(){
            root = null;
        }
        // The finding of the Node.
        public boolean findNode(String countryName){
            Node current = root;
            while (current != null){
                if(current.countryName.equals(countryName)){
                    return true;
                } else if(current.countryName.compareTo(countryName) < 0){
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
            return false;
        }
        //The reading of the Node.
        public int readNode(String countryName){
            Node current = root;
            while(current != null){
                if(current.countryName.equals(countryName)){
                    return current.population;
                } else if(current.countryName.compareTo(countryName) < 0){
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
            return -1;
        }
        // The Insertion of the Node.
        public void insertNode(String countryName, int population){
            Node newNode = new Node(countryName, population);
            if(root == null){
                root = newNode;
                return;
            }
            Node current = root;
            Node parent = null;
            while (true){
                parent = current;
                if(current.countryName.compareTo(countryName) < 0) {  //Use the "compareTo" string method
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if(current == null){
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
        //The Display of for the Node.
        public void displayNode(Node root){
            if(root != null){
                displayNode(root.left);
                System.out.print(" " + root.countryName + ",");
                displayNode(root.right);
            }
        }
    }


