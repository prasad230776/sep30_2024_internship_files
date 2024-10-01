package dev.codewithsiva.multipageapp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
@SpringBootApplication
public class MultipageAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultipageAppApplication.class, args);
	}

	@GetMapping("/second")
	public String servePage2(Model model){
		return "second";
	}
	@GetMapping("/time")
	public String serveTime(Model model){
		String timeInString = getTimeInString();
		model.addAttribute("data", timeInString);
		return "time";
	}

	@ResponseBody
	@GetMapping("/api/time")
	public String[] getTime(){
		String timeInString = getTimeInString();
		return new String[]{timeInString};
	}

	private String getTimeInString() {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String timeInString = dateTime.format(formatter);
		return timeInString;
	}

}
