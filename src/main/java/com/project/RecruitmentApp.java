package com.project;

import org.apache.commons.cli.*;

public class RecruitmentApp {

    public void run(String[] args) {
        CommandLine cmdline = parseInput(args);

        if (cmdline.hasOption("1")) {
            Administrator admin = new Administrator();
            admin.start();
        } else if (cmdline.hasOption("2")) {
            Employee emp = new Employee();
            emp.start();
        } else if (cmdline.hasOption("3")) {
            Employer empl = new Employer();
            empl.start();
        } else if (cmdline.hasOption("4")) {
            System.out.println("Thank you! The system will now exit.");
            System.exit(1);
        } else {
            System.out.println("[ERROR] Invalid input!");
        }
    }

    private CommandLine parseInput(String[] args) {
        Options options = getOptions();
        CommandLineParser parser = new DefaultParser();

        try {
            return parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println( "[ERROR] " + e.getMessage() );
        }
        return null;
    }

    private Options getOptions() {
        Options options = new Options();
        options.addOption("1", false, "Administrator");
        options.addOption("2", false, "Employee");
        options.addOption("3", false, "Employer");
        options.addOption("4", false, "Exit");

        return options;
    }
}
