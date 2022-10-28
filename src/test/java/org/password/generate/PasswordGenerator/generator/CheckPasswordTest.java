package org.password.generate.PasswordGenerator.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("When running CheckPassword Class")
class CheckPasswordTest {

	@Test
	@DisplayName("Testing CharType Method")
	void testCharType() {
		CheckPassword checkPassword = new CheckPassword();
		
		assertEquals(3, checkPassword.charType('2'));
	}

	@Test
	@DisplayName("Testing PasswordStrength Method")
	void testPasswordStrength() {
		CheckPassword checkPassword = new CheckPassword();
		
		assertEquals(5, checkPassword.passwordStrength("Password@123"));
		assertEquals(6, checkPassword.passwordStrength("Password@12334567"));
	}
	
	@Test
	@DisplayName("Testing CalculateScore Method")
	void testCalculateScore() {
		CheckPassword checkPassword = new CheckPassword();
		
		String expectedOut = "This is a weak password :( definitely find a new one";
		
		assertEquals(expectedOut, checkPassword.calculateScore(2));	
		
		expectedOut = "This is a medium password :/ try making it better";
		
		assertEquals(expectedOut, checkPassword.calculateScore(3));
		
		expectedOut = "This is a good password :) but you can still do better";
		
		assertEquals(expectedOut, checkPassword.calculateScore(4));
		
		expectedOut = "This is a very good password :D check the Useful Information section to make sure it satisfies the guidelines";
		
		assertEquals(expectedOut, checkPassword.calculateScore(6));	

	}
}
