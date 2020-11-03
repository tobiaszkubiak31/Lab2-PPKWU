package lab2.lab.api;

import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringStatisticController {

	@GetMapping("/countAllStatistics")
	public String countAllStatisticsEndpoint(@RequestParam(value = "stringToCheck") String stringToCheck,HttpServletResponse response) {
		if(stringToCheck.isEmpty()){
			response.setStatus( HttpServletResponse.SC_BAD_REQUEST  );
			return new JSONObject()
				.put("Error", "String is empty")
				.toString();
		}
		return countAllStatistic(stringToCheck);
	}
	
	@GetMapping("/countLowerLetter")
	public String countLowerLetterEndpoint(@RequestParam(value = "stringToCheck") String stringToCheck,HttpServletResponse response) {
		if(stringToCheck.isEmpty()){
			response.setStatus( HttpServletResponse.SC_BAD_REQUEST  );
			return new JSONObject()
				.put("Error", "String is empty")
				.toString();
		}
		int countLowerLetter = countLowerLetterInString(stringToCheck);
		return new JSONObject()
			.put("checkedString", stringToCheck)
			.put("lowerLetter", countLowerLetter)
			.toString();
	}

	@GetMapping("/countUpperLetter")
	public String countUpperLetterEndpoint(@RequestParam(value = "stringToCheck") String stringToCheck,HttpServletResponse response) {
		if(stringToCheck.isEmpty()){
			response.setStatus( HttpServletResponse.SC_BAD_REQUEST  );
			return new JSONObject()
				.put("Error", "String is empty")
				.toString();
		}
		int countUpperLetter =countUpperLetterInString(stringToCheck);
		return new JSONObject()
			.put("checkedString", stringToCheck)
			.put("upperLetter", countUpperLetter)
			.toString();
	}

	@GetMapping("/countSpecialLetter")
	public String countSpecialLetterEndpoint(@RequestParam(value = "stringToCheck") String stringToCheck,HttpServletResponse response) {
		if(stringToCheck.isEmpty()){
			response.setStatus( HttpServletResponse.SC_BAD_REQUEST  );
			return new JSONObject()
				.put("Error", "String is empty")
				.toString();
		}
		int countUpperLetter = countSpecialLetterInString(stringToCheck);
		return new JSONObject()
			.put("checkedString", stringToCheck)
			.put("specialLetter", countUpperLetter)
			.toString();
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
		return  specialLetterCounter;
	}

	private String countAllStatistic(String stringToCheck) {
		int countUpperLetter = countUpperLetterInString(stringToCheck);
		int countLowerLetter = countLowerLetterInString(stringToCheck);
		int countSpecialLetter = countSpecialLetterInString(stringToCheck);
		return buildJsonResponse(countUpperLetter,countLowerLetter,countSpecialLetter,stringToCheck);
	}

	private String buildJsonResponse(int countUpperLetter, int countLowerLetter,
		int countSpecialLetter, String stringToCheck) {
		return  new JSONObject()
			.put("checkedString", stringToCheck)
			.put("upperLetter", countUpperLetter)
			.put("lowerLetter", countLowerLetter)
			.put("specialLetter", countSpecialLetter)
			.toString();
	}

}
