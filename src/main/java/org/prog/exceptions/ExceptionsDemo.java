package org.prog.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


//TODO: Catch parent exceptions (EXception / Throwable)
//TODO: Catch specific exception
//TODO: Convert FileNotFoundException into Throwable in readFile3
//TODO: Process Throwable in readFile1
public class ExceptionsDemo {

    public static void main(String[] args) {
        // Catch specific exception
        try {
            print("123");
        } catch (NullPointerException ex) {
            ex.getMessage();
        }

        try {
            readFile1();
        } catch (Throwable t) {
            System.out.println("OOPS Throwable is in readFile1");
        }
        System.out.println("test");
    }

    public static void readFile1() {
        readFile2();
    }

    public static void readFile2() {
        try {
            readFile3();
        } catch (Throwable e) {
            System.out.println("OOPS in readFile2");
            throw new RuntimeException(e);
        }
    }

    public static void readFile3() throws Throwable {
        try {
            readFile4();
        } catch (FileNotFoundException e) {
            System.out.println("OOPS in readFile3");
            throw new Throwable("Throwable is in redFile3");
        }
    }

    public static void readFile4() throws FileNotFoundException {
        File f = new File("qwe.txt");
        FileReader fileReader = new FileReader(f);
        f.setReadable(true);
    }

//    public static void readFile5() throws FileNotFoundException {
//        File f = new File("abc.txt");
//        FileReader fileReader = new FileReader(f);
//        f.setReadable(true);
//    }

    public static void print(String value) {
        if (value == null) {
            throw new NullPointerException("Exception: value is null!");
        }
        System.out.println("Inside method print: " + value);
    }
}