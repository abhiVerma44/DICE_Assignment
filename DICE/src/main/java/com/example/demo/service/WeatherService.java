package com.example.demo.service;

import org.springframework.http.ResponseEntity;

public interface WeatherService {

	public ResponseEntity<String> getCustomForecastSummaryByLocation(String city, String customClientId, String customClientSecret);
	
	public ResponseEntity<String> getCustomHourlyForecastByLocation(String city, String customClientId, String customClientSecret);
}
