package org.prog.cycles;

import java.util.Scanner;

public class CyclesDemo {

    public static void main(String[] args) {
        boolean b1 = false;
        boolean b2 = false;

        if (trueFlag() || falseFlag() || b1) {
            System.out.println("always true");
        } else {
            System.out.println("never works");
        }

        test("CHROME");
        test("Avant");
        test("IE");

        Scanner sc = new Scanner(System.in);
        int day;
        System.out.println("Input day");
        day = sc.nextInt();

        switch (day) {
            case 1:
                System.out.println("Понедельник");
                break;
            case 2:
                System.out.println("Вторник");
                break;
            case 3:
                System.out.println("Среда");
                break;
            case 4:
                System.out.println("Четверг");
                break;
            case 5:
                System.out.println("Пятница");
                break;
            case 6:
                System.out.println("Суббота");
                break;
            case 7:
                System.out.println("Воскресенье");
                break;
            default:
                System.out.println("Input error");
        }
    }

    //TODO: switch practice

    private static void test(String s) {
        switch (s) {
            case "CHROME":
                System.out.println("CHROME");
                break;
            case "OPERA":
                System.out.println("OPERA");
                break;
            case "FIREFOX":
                System.out.println("FIREFOX");
                break;
            case "EDGE":
                System.out.println("EDGE");
                break;
            case "SAFARI":
                System.out.println("SAFARI");
                break;
            default:
                throw new RuntimeException("Unsupported browser!");
        }
    }

    private static boolean falseFlag() {
        return false;
    }

    private static boolean trueFlag() {
        return true;
    }
}
