package lab2.lab.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringStatisticController {

	@GetMapping("/ccountAllStatistics")
	public String countAllStatisticsEndpoint(@RequestParam(value = "stringToCheck") String stringToCheck) {
		return countAllStatistic(stringToCheck);
	}
	
	@GetMapping("/countLowerLetter")
	public int countLowerLetterEndpoint(@RequestParam(value = "stringToCheck") String stringToCheck) {
		return countLowerLetterInString(stringToCheck);
	}

	@GetMapping("/countUpperLetter")
	public int countUpperLetterEndpoint(@RequestParam(value = "stringToCheck") String stringToCheck) {
		return countUpperLetterInString(stringToCheck);
	}

	@GetMapping("/countSpecialLetter")
	public int countSpecialLetterEndpoint(@RequestParam(value = "stringToCheck") String stringToCheck) {
		return countSpecialLetterInString(stringToCheck);
	}

	int countLowerLetterInString(String stringToCheck){
		String[] str = stringToCheck.split("");
		int lowerCaseCounter = 0;
		for (String s : str) {
			if (Character.isLowerCase(s.charAt(0))) {
				lowerCaseCounter++;
			}
		}
		return lowerCaseCounter;
	}


	int countUpperLetterInString(String stringToCheck){
		String[] str = stringToCheck.split("");
		int upperCaseCounter = 0;
		for (String s : str) {
			if (Character.isUpperCase(s.charAt(0))) {
				upperCaseCounter++;
			}
		}
		return upperCaseCounter;
	}


	private int countSpecialLetterInString(String stringToCheck) {
		int specialLetterCounter = 0;
		String[] splittedString = stringToCheck.split("");
		for (String letter : splittedString) {
			char ch = letter.charAt(0);
			if (ch >= 'A' && ch <= 'Z')
				continue;
			else if (ch >= 'a' && ch <= 'z')
				continue;
			else if (ch >= '0' && ch <= '9')
				continue;
			else
				specialLetterCounter++;
		}
		return specialLetterCounter;
	}

	private String countAllStatistic(String stringToCheck) {
		int countUpperLetter = countUpperLetterInString(stringToCheck);
		int countLowerLetter = countLowerLetterInString(stringToCheck);
		int countSpecialLetter = countSpecialLetterInString(stringToCheck);
		return buildJsonResponse(countUpperLetter,countLowerLetter,countSpecialLetter,stringToCheck);
	}

	private String buildJsonResponse(int countUpperLetter, int countLowerLetter,
		int countSpecialLetter, String stringToCheck) {
		return "String:" + stringToCheck + " contains:\n"
				+	countUpperLetter + " upper letters\n" +
				+   countLowerLetter + "lower letters\n" +
			 	+  	countSpecialLetter +" special letters\n";
	}

}
