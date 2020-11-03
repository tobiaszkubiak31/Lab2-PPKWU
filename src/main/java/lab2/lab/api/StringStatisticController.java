package lab2.lab.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringStatisticController {
	@GetMapping("/stringStatistic")
	public String calculateStatisticEndpoint(@RequestParam(value = "stringToCheck") String stringToCheck) {
		return checkStringStatistic("Test string static");
	}
	String checkStringStatistic(String stringToCheck){
		return "Test";
	}

}
