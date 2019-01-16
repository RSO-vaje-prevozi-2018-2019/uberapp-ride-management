package si.fri.rso.samples.ride_management.models.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PickupPoint {

    private String Country;

    private String CountryId;

    private String City;

    private Integer Population;

    private Double Distance;

    private Double Latitude;

    private Double Longitude;

    public String getCountry() {
        return Country;
    }

    @JsonProperty("Country")
    public void setCountry(String country) {
        this.Country = country;
    }

    public String getCountryId() {
        return CountryId;
    }

    @JsonProperty("CountryId")
    public void setCountryId(String countryId) {
        this.CountryId = countryId;
    }

    public String getCity() {
        return City;
    }

    @JsonProperty("City")
    public void setCity(String city) {
        this.City = city;
    }

    public Integer getPopulation() {
        return Population;
    }

    @JsonProperty("Population")
    public void setPopulation(Integer population) {
        this.Population = population;
    }

    public Double getDistance() {
        return Distance;
    }

    @JsonProperty("Distance")
    public void setDistance(Double distance) {
        this.Distance = distance;
    }

    public Double getLatitude() {
        return Latitude;
    }

    @JsonProperty("Latitude")
    public void setLatitude(Double latitude) {
        this.Latitude = latitude;
    }

    public Double getLongitude() {
        return Longitude;
    }

    @JsonProperty("Longitude")
    public void setLongitude(Double longitude) {
        this.Longitude = longitude;
    }
}
