package com.project;

import java.util.Scanner;

public class Administrator {
    private Scanner scanner;

    public void initInfo() {
        System.out.println("Administrator, what would you like to do?");
        System.out.println("1. Create tables");
        System.out.println("2. Delete tables");
        System.out.println("3. Load tables");
        System.out.println("4. Check data");
        System.out.println("5. Go back");
    }

    public void start() {
        System.out.println("Please enter [1-5].");
        scanner = new Scanner(System.in);
        Integer input = Integer.parseInt(scanner.next());

        runAdminMethod(input);
    }

    private void runAdminMethod(Integer input) {
        if (input == 1) {
            createTables();
        } else if (input == 2) {
            deleteTables();
        } else if (input == 3) {
            loadTables();
        } else if (input == 4) {
            checkData();
        } else if (input == 5) {
            goBack();
        } else {
            System.out.println("[ERROR] Invalid input");
            start();
        }
    }

    private void createTables() {
    	backend.createTables();
    	System.out.println("Processing...Done! Tables are created!");
        initInfo();
        start();
    }

    private void deleteTables() {
    	backend.deleteTables();
    	System.out.println("Processing...Done! Tables are deleted!");
        initInfo();
        start();
    }

    private void loadTables() {
        System.out.println("Please enter the folder path.");
        String path = scanner.next();
        backend.load_data(path);
        System.out.println("Processing...Done! Data is loaded!");
        initInfo();
        start();
    }

    private void checkData() {
        backend.check_data();
        initInfo();
        start();
    }

    private void goBack() {
        //scanner.close();
        Main.main(new String[0]);
    }


}
