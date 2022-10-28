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
	
}
