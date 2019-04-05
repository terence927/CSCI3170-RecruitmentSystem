package com.project;

import java.util.Scanner;

public class RecruitmentApp {

    public void run(String input, Scanner s) {
        Integer x = Integer.parseInt(input);
        if (x == 1 ) {
            Administrator admin = new Administrator();
            admin.initInfo();
            admin.start();
        } else if (x == 2) {
            Employee emp = new Employee();
            emp.initInfo();
            emp.start();
        } else if (x == 3) {
            Employer empl = new Employer();
            empl.initInfo();
            empl.start();
        } else if (x == 4) {
            System.out.println("Thank you! The system will now exit.");
            s.close();
            System.exit(1);
        } else {
            System.out.println("[ERROR] Invalid input!");
            Main.main(new String[0]);
        }
    }
}
