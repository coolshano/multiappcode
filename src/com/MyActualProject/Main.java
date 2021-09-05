package com.MyActualProject;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        var enter = new HelloWorld();
        var myDiary = new DearDiary();

        Scanner selectProgram = new Scanner(System.in);
        System.out.print("Please type option: 1 for Diary / 2 for PhoneBook: ");

        try {
            int myProgram = selectProgram.nextInt();
            switch (myProgram) {
                case 1:
                    enter.helloWorld();
                    break;
                case 2:
                    myDiary.helloDiary();
                    break;
                default:
                    System.out.println("Invalid Selection!");

            }

        }catch (Exception e){
            System.out.println("Cannot accept alphebetic characters!");
        }

    }
}
