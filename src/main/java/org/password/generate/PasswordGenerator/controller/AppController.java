package org.password.generate.PasswordGenerator.controller;

import java.util.Scanner;

import org.password.generate.PasswordGenerator.generator.CheckPassword;
import org.password.generate.PasswordGenerator.generator.PasswordGenerator;

public class AppController {
	
	Scanner scanner;
	
	public AppController() {
		scanner = new Scanner(System.in);
	}
	
	
	public void mainLoop() {

        System.out.println("Welcome to Password Services :)");
        
        String userOption;
        
        do {
        	printMenu();
        	userOption = scanner.nextLine();
        	
        	switch (userOption) {
        		case "1" : requestPassword();
        				break;
        				
        		case "2" : checkPassword();
        				break;
        			
        		case "3" : printUsefulInfo();
        				break;
        			
        		case "4" : printQuitMessage();
        				break;
        			
        		default : System.out.println("\nKindly select one of the available commands");
        	}
        }while (!userOption.equals("4"));
        
        scanner.close();
	}
	
	private void requestPassword() {
        boolean includeUpper = false;
        boolean includeLower = false;
        boolean includeDigit = false;
        boolean includeSymbol = false;

        boolean correctParams = false;

        System.out.println();
        System.out.println("Hello, welcome to the Password Generator :) answer"
                + " the following questions by Yes or No \n");

        do {
            System.out.println("Do you want Lowercase letters \"abcd...\" to be used? ");
            String input = scanner.nextLine();

            if (isInclude(input)) includeLower = true;

            System.out.println("Do you want Uppercase letters \"ABCD...\" to be used? ");
            input = scanner.nextLine();

            if (isInclude(input)) includeUpper = true;

            System.out.println("Do you want Numbers \"1234...\" to be used? ");
            input = scanner.nextLine();

            if (isInclude(input)) includeDigit = true;

            System.out.println("Do you want Symbols \"!@#$...\" to be used? ");
            input = scanner.nextLine();

            if (isInclude(input)) includeSymbol = true;

            if (!includeUpper && !includeLower && !includeDigit && !includeSymbol) {
                System.out.println("You have selected no characters to generate your " +
                        "password at least one of your answers should be Yes");
                correctParams = true;
            } else correctParams = false;
        } while (correctParams);

        System.out.println("Great! Now enter the length of the password");
        int length = Integer.parseInt(scanner.nextLine());
        PasswordGenerator generator = new PasswordGenerator(includeUpper, includeLower, includeDigit, includeSymbol);

        System.out.print("\nYour generated password -> " + generator.generatePassword(length));        
    }
	
	private boolean isInclude(String Input) {
        if (Input.equalsIgnoreCase("yes")) {
            return true;
        } else {
            if (!Input.equalsIgnoreCase("no")) {
                passwordRequestError();
            }
            return false;
        }
    }
	
	private void passwordRequestError() {
        System.out.println("You have entered something incorrect let's go over it again \n");
    }
	
	private void checkPassword() {
        String password;

        System.out.print("\nEnter your password:");
        password = scanner.nextLine();

        final CheckPassword checkPassword = new CheckPassword();

        System.out.println("\n" + checkPassword.calculateScore(checkPassword.passwordStrength(password)));

    }
	
	private void printUsefulInfo() {
        System.out.println("\n1. Use a minimum password length of 8 or more characters if permitted");
        System.out.println("\n2. Include lowercase and uppercase alphabetic characters, numbers and symbols if permitted");
        System.out.println("\n3. Generate passwords randomly where feasible");
        System.out.println("\n4. Avoid using the same password twice (e.g., across multiple user accounts and/or software systems)");
        System.out.println("\n5. Avoid character repetition, keyboard patterns, dictionary words, letter or number sequences," +
                "\nusernames, relative or pet names, romantic links (current or past) " +
                "and biographical information (e.g., ID numbers, ancestors' names or dates).");
        System.out.println("\n6. Avoid using information that the user's colleagues and/or " +
                "acquaintances might know to be associated with the user");
        System.out.println("\n7. Do not use passwords which consist wholly of any simple combination of the aforementioned weak components");
    }
	
	private void printMenu() {
        System.out.println();
        System.out.println("Enter 1 - Password Generator");
        System.out.println("Enter 2 - Password Strength Check");
        System.out.println("Enter 3 - Useful Information");
        System.out.println("Enter 4 - Quit");
        System.out.print("Choice:");
    }

    private void printQuitMessage() {
        System.out.println("\nClosing the program bye bye!");
    }
}
