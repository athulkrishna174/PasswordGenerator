package org.password.generate.PasswordGenerator.generator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("When running Alphabet Class")
class AlphabetTest {

	@Test
	@DisplayName("Testing GetAlphabet Method")
	void testGetAlphabet() {
		Alphabet alphabet = new Alphabet(true, true, true, true);
		
		String expectedOut = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()-_=+\\/~?";
		
		assertEquals(expectedOut, alphabet.getAlphabet());
	}

	@Test
	@DisplayName("Testing GetAlphabet Method When only uppercaseIncluded and numbersIncluded true")
	void testGetAlphabetOnlyTwoTrue() {
		Alphabet alphabet = new Alphabet(true, false, true, false);
		
		String expectedOut = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		
		assertEquals(expectedOut, alphabet.getAlphabet());
	}
}
