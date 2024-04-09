# Weather Service Project
## This project provides RESTful endpoints to fetch weather forecasts from the OpenWeatherMap API.

# Overview
## This project consists of two RESTful services built with Spring Boot:

- WeatherController: Provides endpoints to fetch weather forecasts from the OpenWeatherMap API.
- CustomWeatherController: Extends the functionality of WeatherController by adding custom endpoints with additional security checks.
### Endpoints
#### WeatherController
- GET /forecast-summary: Returns a summary of the weather forecast for a specified city.
- GET /hourly-forecast: Returns hourly weather forecasts for a specified city.
#### CustomWeatherController
- GET /Custom-forecast/summary: Returns a summary of the weather forecast for a specified city. Requires custom client ID and client secret headers for authentication.
- GET /Custom-hourly/forecast: Returns hourly weather forecasts for a specified city. Requires custom client ID and client secret headers for authentication.
## Setup
- To set up the project locally, follow these steps:

- Clone the repository.
- Configure the api.key property in application.properties with your OpenWeatherMap API key.
- Build the project using Maven or Gradle.
- Run the application locally using Spring Boot.

## Usage
#### To use the endpoints, make HTTP requests to the appropriate URLs with the required parameters. Ensure that you include the necessary headers for authentication when accessing custom endpoints.

#### Example:
GET /forecast-summary?city=London
