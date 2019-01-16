package si.fri.rso.samples.ride_management.models.dtos;


import java.time.Instant;

public class Ride {

    private Integer id;

    private String initialDepartureTime;

    private Integer initialPayment;

    private Integer initialPassengersNum;

    private String status;

    private Integer driverId;

    private Double initialLatitute;
    private Double initialLongitude;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInitialDepartureTime() {
        return initialDepartureTime;
    }

    public void setInitialDepartureTime(String initialDepartureTime) {
        this.initialDepartureTime = initialDepartureTime;
    }

    public Integer getInitialPayment() {
        return initialPayment;
    }
    public void setInitialPayment(Integer initialPayment) {
        this.initialPayment = initialPayment;
    }


    public Integer getInitialPassengersNum() {
        return initialPassengersNum;
    }
    public void setInitialPassengersNum(Integer initialPassengersNum) {
        this.initialPassengersNum = initialPassengersNum;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }



    public Integer getDriverId() {
        return driverId;
    }
    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }


    public Double getInitialLatitute() {
        return initialLatitute;
    }

    public void setInitialLatitute(Double initialLatitute) {
        this.initialLatitute = initialLatitute;
    }

    public Double getInitialLongitude() {
        return initialLongitude;
    }

    public void setInitialLongitude(Double initialLongitude) {
        this.initialLongitude = initialLongitude;
    }
}
