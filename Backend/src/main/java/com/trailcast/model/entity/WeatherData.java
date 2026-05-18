package com.trailcast.model.entity;

public class WeatherData {
    private String cityName;
    private String country;
    private String description;
    private double temperature;
    private int humidity;
    private double windSpeed;

    public WeatherData(){}

    public WeatherData(String cityName,String country, String description,
                       double temperature,int humidity,double windSpeed){
        this.cityName=cityName;
        this.country=country;
        this.description=description;
        this.windSpeed=windSpeed;
        this.humidity=humidity;
        this.temperature=temperature;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }
}
