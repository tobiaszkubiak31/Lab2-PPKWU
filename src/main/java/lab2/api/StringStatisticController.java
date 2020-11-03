package lab2.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringStatisticController {
	@GetMapping("/stringStatistic")
	public String testController() {
		return "Test string static";
	}
}
