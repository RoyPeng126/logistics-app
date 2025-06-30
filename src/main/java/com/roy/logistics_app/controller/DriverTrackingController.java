package com.roy.logistics_app.controller;

import com.roy.logistics_app.model.DriverTracking;
import com.roy.logistics_app.repository.DriverTrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/driver-tracking")
public class DriverTrackingController {

    @Autowired
    private DriverTrackingRepository trackingRepository;

    @GetMapping
    public List<DriverTracking> getAllTracking() {
        return trackingRepository.findAll();
    }

    @GetMapping("/driver/{driverName}")
    public List<DriverTracking> getByDriverName(@PathVariable String driverName) {
        return trackingRepository.findByDriverName(driverName);
    }

    @GetMapping("/shipment/{shipmentId}")
    public List<DriverTracking> getByShipmentId(@PathVariable String shipmentId) {
        return trackingRepository.findByShipmentId(shipmentId);
    }

    @PostMapping
    public DriverTracking createTracking(@RequestBody DriverTracking tracking) {
        tracking.setTimestamp(LocalDateTime.now());
        return trackingRepository.save(tracking);
    }
}
