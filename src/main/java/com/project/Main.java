package com.project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome! Please identify yourself.");
        System.out.println("1. Administrator");
        System.out.println("2. Employee");
        System.out.println("3. Employer");
        System.out.println("4. Exit");
        System.out.println("Please enter [1-4].");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        RecruitmentApp app = new RecruitmentApp();
        app.run(input);
    }
}
