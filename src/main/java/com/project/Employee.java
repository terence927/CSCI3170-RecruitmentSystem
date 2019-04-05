package com.project;

import java.util.Scanner;

public class Employee {
    private Scanner scanner;

    public void initInfo() {
        System.out.println("Employee, what would you like to do?");
        System.out.println("1. Show available positions");
        System.out.println("2. Mark interested position");
        System.out.println("3. Check average working time");
        System.out.println("4. Go back");
    }

    public void start() {
        System.out.println("Please enter [1-4].");
        scanner = new Scanner(System.in);
        Integer input = Integer.parseInt(scanner.next());

        runEmployeeMethod(input);
    }

    private void runEmployeeMethod(Integer input) {
        if (input == 1) {
            showAvailablePositions();
        } else if (input == 2) {
            markInterestedPosition();
        } else if (input == 3) {
            checkAvgWorkTime();
        } else if (input == 4) {
            goBack();
        } else {
            System.out.println("[ERROR] Invalid input");
            start();
        }
    }

    private void showAvailablePositions() {
        System.out.println("Please enter your ID.");
        String input = scanner.next();
        Integer id = Integer.parseInt(input);

        // LOGIC

        initInfo();
        start();
    }

    private void markInterestedPosition() {
        System.out.println("Please enter your ID.");
        String input = scanner.next();
        Integer id = Integer.parseInt(input);

        // LOGIC

        initInfo();
        start();
    }

    private void checkAvgWorkTime() {
        System.out.println("Please enter your ID.");
        String input = scanner.next();
        Integer id = Integer.parseInt(input);

        // LOGIC

        initInfo();
        start();
    }

    private void goBack() {
        scanner.close();
        Main.main(new String[0]);
    }
}
