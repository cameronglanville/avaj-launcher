package com.avaj;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello World");
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                System.out.println(args[i]);
            }
        }
    }

}