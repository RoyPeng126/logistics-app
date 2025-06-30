package com.roy.logistics_app.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class DriverTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String driverName;

    @Column(nullable = false)
    private String currentLocation;

    @Column(nullable = false)
    private String shipmentId;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    public DriverTracking() {
    }

    public DriverTracking(String driverName, String currentLocation, String shipmentId, LocalDateTime timestamp) {
        this.driverName = driverName;
        this.currentLocation = currentLocation;
        this.shipmentId = shipmentId;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
} 
