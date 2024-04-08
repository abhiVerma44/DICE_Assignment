function ForecastSummary() {

    const city = document.getElementById('cityValue').value;

    fetch(`http://localhost:8888/forecast-summary?city=${city}`)
    
        .then(response => response.json())
        .then(data => {
            displayResult(data);
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

function HourlyForecast() {
    const city = document.getElementById('cityValue').value;

    fetch(`http://localhost:8888/hourly-forecast?city=${city}`)

        .then(response => response.json())
        .then(data => {
            displayResult(data);
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

function displayResult(data) {
    const resultDiv = document.getElementById('result');
    resultDiv.innerHTML = JSON.stringify(data, null, 2);
}