package com.project;

import java.util.Scanner;

public class Employer {
    private Scanner scanner;

    public void initInfo() {
        System.out.println("Employer, what would you like to do?");
        System.out.println("1. Post position recruitment");
        System.out.println("2. Check employees and arrange an interview");
        System.out.println("3. Accept an employee");
        System.out.println("4. Go back");
    }

    public void start() {
        System.out.println("Please enter [1-4].");
        scanner = new Scanner(System.in);
        Integer input = Integer.parseInt(scanner.next());

        runEmployerMethod(input);
    }

    private void runEmployerMethod(Integer input) {
        if (input == 1) {
            postPosition();
        } else if (input == 2) {
            checkEmployees();
        } else if (input == 3) {
            acceptEmployee();
        } else if (input == 4) {
            goBack();
        } else {
            System.out.println("[ERROR] Invalid input");
            start();
        }
    }

    private void postPosition() {
    	scanner = new Scanner(System.in);
    	System.out.println("Please enter your ID.");
    	String id = scanner.next();
    	System.out.println("Please enter the position title.");
    	String title = scanner.next();
    	System.out.println("Please enter an upper bound of salary.");
    	Integer salary = Integer.parseInt(scanner.next());
    	System.out.println("Please enter required experience");
    	Integer Exp = Integer.parseInt(scanner.next());
    	//System.out.println(Exp); ???input enter to exit ??? =>  exp=0
    	backend.post_pos(id, title, salary, Exp);
    	initInfo();
    	start();
    }

    private void checkEmployees() {
    	System.out.println("Please enter your ID.");
    	String id = scanner.next();
    	backend.check_ee(id);
    	initInfo();
    	start();
    }

    private void acceptEmployee() {
    	System.out.println("Please enter your ID.");
    	String erid = scanner.next();
    	System.out.println("Please enter the employee_ID you want to hire.");
    	String eeid = scanner.next();
    	backend.accept_ee(erid,eeid);
    	initInfo();
    	start();
    }

    private void goBack() {
        //scanner.close();
        Main.main(new String[0]);
    }
}
