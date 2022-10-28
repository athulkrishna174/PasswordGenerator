package org.password.generate.PasswordGenerator.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("When running PasswordGenerator Class")
class PasswordGeneratorTest {

	@Test
	@DisplayName("Testing GeneratePassword Method")
	void testGeneratePassword() {
		
		PasswordGenerator passwordGenerator = new PasswordGenerator(true, true, true, true);
		
		int length = 10;
		
		assertEquals(length, passwordGenerator.generatePassword(length).length());
	}

}
