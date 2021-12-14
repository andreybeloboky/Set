package com.company;

public class Main {

    public static void main(String[] args) {
        Set1 set = new Set1();
        set.add("1");
        set.add("1");
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("3");
        System.out.println(set.size() + " SIZE");
        set.print();

    }
}
