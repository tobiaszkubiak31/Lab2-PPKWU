package lab2.lab.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringStatisticController {

	@GetMapping("/countLowerLetter")
	public int countLowerLetterEndpoint(@RequestParam(value = "stringToCheck") String stringToCheck) {
		return countLowerLetterInString(stringToCheck);
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


}
