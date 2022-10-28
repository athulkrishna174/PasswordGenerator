package org.password.generate.PasswordGenerator.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("When running AppController Class")
class AppControllerTest {
	
	ByteArrayOutputStream outContent;
	AppController appController;
	
	@BeforeEach
	void init() {
		outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        appController = new AppController();
	}

	@Test
	@DisplayName("Testing PrintMenu Method")
	void testPrintMenu() throws Exception{
		
	    String exppectedOut = "Enter 1 - Password Generator\r\n"
	    		+ "Enter 2 - Password Strength Check\r\n"
	    		+ "Enter 3 - Useful Information\r\n"
	    		+ "Enter 4 - Quit\r\n"
	    		+ "Choice:";
	    
		Method method = AppController.class.getDeclaredMethod("printMenu");
		method.setAccessible(true);
		
		method.invoke(appController);
		
		assertEquals(exppectedOut, outContent.toString().trim());
	}

	@Test
	@DisplayName("Testing PrintQuitMessage Method")
	void testPrintQuitMessage() throws Exception{
		
		String exppectedOut = "Closing the program bye bye!";
		
		Method method = AppController.class.getDeclaredMethod("printQuitMessage");
		method.setAccessible(true);
		
		method.invoke(appController);
		
		assertEquals(exppectedOut, outContent.toString().trim());
	}
	
	@Test
	@DisplayName("Testing PrintUsefulInfo Method")
	void testPrintUsefulInfo() throws Exception{
		
		String exppectedOut = "1. Use a minimum password length of 8 or more characters if permitted\r\n"
				+ "\n"
				+ "2. Include lowercase and uppercase alphabetic characters, numbers and symbols if permitted\r\n"
				+ "\n"
				+ "3. Generate passwords randomly where feasible\r\n"
				+ "\n"
				+ "4. Avoid using the same password twice (e.g., across multiple user accounts and/or software systems)\r\n"
				+ "\n"
				+ "5. Avoid character repetition, keyboard patterns, dictionary words, letter or number sequences,\n"
				+ "usernames, relative or pet names, romantic links (current or past) and biographical information (e.g., ID numbers, ancestors' names or dates).\r\n"
				+ "\n"
				+ "6. Avoid using information that the user's colleagues and/or acquaintances might know to be associated with the user\r\n"
				+ "\n"
				+ "7. Do not use passwords which consist wholly of any simple combination of the aforementioned weak components";
		
		Method method = AppController.class.getDeclaredMethod("printUsefulInfo");
		method.setAccessible(true);
		
		method.invoke(appController);
		
		assertEquals(exppectedOut, outContent.toString().trim());
	}
	
	@Test
	@DisplayName("Testing PasswordRequestError Method")
	void testPasswordRequestError() throws Exception{
		
		String exppectedOut = "You have entered something incorrect let's go over it again";
		
		Method method = AppController.class.getDeclaredMethod("passwordRequestError");
		method.setAccessible(true);
		
		method.invoke(appController);
		
		assertEquals(exppectedOut, outContent.toString().trim());
	}
	
	@Test
	@DisplayName("Testing IsInclude Method")
	void testIsInclude() throws Exception{
		
		String exppectedOut = "You have entered something incorrect let's go over it again";
		
		Method method = AppController.class.getDeclaredMethod("isInclude", String.class);
		method.setAccessible(true);

		assertTrue((boolean) method.invoke(appController, "yes"));
		assertFalse((boolean) method.invoke(appController, "no"));
		
		method.invoke(appController, "");
		assertEquals(exppectedOut, outContent.toString().trim());
	}
	
}
