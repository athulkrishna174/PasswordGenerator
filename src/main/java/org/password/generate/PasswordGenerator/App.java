package org.password.generate.PasswordGenerator;

import org.password.generate.PasswordGenerator.controller.AppController;

public class App {
	
	
    public static void main( String[] args ) {
    	AppController appController = new AppController();
    	appController.mainLoop();
    }
}
