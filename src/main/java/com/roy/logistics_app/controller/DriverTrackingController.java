package com.roy.logistics_app.controller;

import com.roy.logistics_app.model.DriverTracking;
import com.roy.logistics_app.service.DriverTrackingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/driver-tracking")
@RequiredArgsConstructor
public class DriverTrackingController {

    private final DriverTrackingService trackingService;

    @GetMapping
    public List<DriverTracking> getAllTracking() {
        return trackingService.getAll();
    }

    @GetMapping("/driver/{driverName}")
    public List<DriverTracking> getByDriverName(@PathVariable String driverName) {
        return trackingService.getByDriver(driverName);
    }

    @GetMapping("/shipment/{shipmentId}")
    public List<DriverTracking> getByShipmentId(@PathVariable String shipmentId) {
        return trackingService.getByShipment(shipmentId);
    }

    @GetMapping("/driver/{driverName}/latest")
    public DriverTracking getLatestByDriver(@PathVariable String driverName) {
        return trackingService.getLatestByDriver(driverName);
    }

    @GetMapping("/shipment/{shipmentId}/latest")
    public DriverTracking getLatestByShipment(@PathVariable String shipmentId) {
        return trackingService.getLatestByShipment(shipmentId);
    }

    @GetMapping("/driver/{driverName}/range")
    public List<DriverTracking> getByDriverAndRange(
            @PathVariable String driverName,
            @RequestParam LocalDateTime start,
            @RequestParam LocalDateTime end) {
        return trackingService.getByDriverAndRange(driverName, start, end);
    }

    @PostMapping
    public DriverTracking createTracking(@RequestBody DriverTracking tracking) {
        return trackingService.create(tracking);
    }

    @PutMapping("/{id}")
    public DriverTracking updateTracking(@PathVariable Long id, @RequestBody DriverTracking tracking) {
        return trackingService.update(id, tracking);
    }

    @DeleteMapping("/{id}")
    public void deleteTracking(@PathVariable Long id) {
        trackingService.delete(id);
    }
}
