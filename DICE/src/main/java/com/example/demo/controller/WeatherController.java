package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.service.WeatherService;

@RestController
public class WeatherController {
	@Autowired
	private WeatherService weatherService;

	@GetMapping("/forecast/summary")
	public ResponseEntity<String> getCustomForecastSummaryByLocation(@RequestParam String city,@RequestHeader("customClientId") String customClientId,
			@RequestHeader("customClientSecret") String customClientSecret) {
		
		System.out.println(customClientId);
		
		if (customClientId == null) {
			
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Client id is not present.");
			
		} else if (customClientSecret == null) {
			
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Client secret key is not present.");
			
		} else {
			
			return weatherService.getCustomForecastSummaryByLocation(city, customClientId, customClientSecret);
		}
	}

//	@GetMapping("/hourly/forecast")
//	public ResponseEntity<String> getCustomHourlyForecastByLocation(@RequestParam String city,
//		
//	}
//	
	@GetMapping("/hourly/forecast")
	
	public ResponseEntity<String> getCustomHourlyForecastByLocation(@RequestParam String city,
			@RequestHeader("customClientId") String customClientId,
			@RequestHeader("customClientSecret") String customClientSecret) {
		if (customClientId == null) {
			
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Client id is not present.");
			
		} else if (customClientSecret == null) {
			
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Client secret key is not present.");
			
		} else {
			
			return weatherService.getCustomHourlyForecastByLocation(city, customClientId, customClientSecret);
		}
	}
}
