package org.password.generate.PasswordGenerator.generator;

public class CheckPassword {
	
	public int charType(char character) {

		if(Character.isUpperCase(character)) return 1;
		
		else if(Character.isLowerCase(character)) return 2;
		
		else if (Character.isDigit(character)) return 3;
		
		else return 4;
	}
	
	public int passwordStrength(String password) {
		
		boolean usedUpper = false;
		boolean usedLower = false;
		boolean usedDigit = false;
		boolean usedSymbol = false;
		int type;
		int score = 0;
		
		for(int i = 0; i < password.length(); i++) {
			
			type = this.charType(password.charAt(i));
			
			if(type == 1) usedUpper = true;
			if(type == 2) usedLower = true;
			if(type == 3) usedDigit = true;
			if(type == 4) usedSymbol = true;
		}
		
		if(usedUpper) score += 1;
		if(usedLower) score += 1;
		if(usedDigit) score += 1;
		if(usedSymbol) score += 1;
		
		if(password.length() >= 8) score += 1;
		if(password.length() >= 16) score += 1;
		
		return score;		
	}
	
	public String calculateScore(int score) {
		
		if(score == 6)
			return "This is a very good password :D check the Useful Information section to make sure it satisfies the guidelines";
		
		else if (score >= 4) return "This is a good password :) but you can still do better";
	    else if (score >= 3) return "This is a medium password :/ try making it better";
	    else return "This is a weak password :( definitely find a new one";
	}
	
}
