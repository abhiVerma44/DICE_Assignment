package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
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

	
	    @Value("${api.key}")
	    private String apiKey;

	    private final RestTemplate restTemplate;

	    public WeatherController(RestTemplateBuilder restTemplateBuilder) {
	        this.restTemplate = restTemplateBuilder.build();
	    }

	    @GetMapping("/forecast-summary")
	    public ResponseEntity<String> getForecastSummary(@RequestParam("city") String city) {
	    	
	        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;
	        
	        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
	        
	        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
	    }

	    @GetMapping("/hourly-forecast")
	    
	    public ResponseEntity<String> getHourlyForecast(@RequestParam("city") String city) {
	    	
	        String url = "http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&appid=" + apiKey;
	        
	        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
	        
	        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
	    }

	    @Bean
	    public RestTemplate restTemplate(RestTemplateBuilder builder) {
	    	
	        return builder.build();
	    }
}
