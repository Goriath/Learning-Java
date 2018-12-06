package com.kfryc;

public class Main {

    public static void main(String[] args) {
	// write your code here

        SearchTree tree = new SearchTree(null);

        MyLinkedList list = new MyLinkedList(null);
        list.traverse(list.getRoot());

        String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";

        String[] data = stringData.split(" ");
        for (String s : data){
            tree.addItem(new Node(s));

        }


//        for (String s : data){
//            list.addItem(new Node(s));
//
//        }

        //list.traverse(list.getRoot());
        tree.traverse(tree.getRoot());
    }
}
