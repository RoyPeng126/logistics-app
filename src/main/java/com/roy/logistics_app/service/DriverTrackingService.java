package com.roy.logistics_app.service;

import com.roy.logistics_app.model.DriverTracking;
import com.roy.logistics_app.repository.DriverTrackingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverTrackingService {

    private final DriverTrackingRepository repository;

    public List<DriverTracking> getAll() {
        return repository.findAll();
    }

    public List<DriverTracking> getByDriver(String driverName) {
        return repository.findByDriverName(driverName);
    }

    public List<DriverTracking> getByShipment(String shipmentId) {
        return repository.findByShipmentId(shipmentId);
    }

    public DriverTracking getLatestByDriver(String driverName) {
        return repository.findTopByDriverNameOrderByTimestampDesc(driverName);
    }

    public DriverTracking getLatestByShipment(String shipmentId) {
        return repository.findTopByShipmentIdOrderByTimestampDesc(shipmentId);
    }

    public List<DriverTracking> getByDriverAndRange(String driverName, LocalDateTime start, LocalDateTime end) {
        return repository.findByDriverNameAndTimestampBetween(driverName, start, end);
    }

    public DriverTracking create(DriverTracking tracking) {
        tracking.setTimestamp(LocalDateTime.now());
        return repository.save(tracking);
    }

    public DriverTracking update(Long id, DriverTracking tracking) {
        DriverTracking existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tracking not found"));
        existing.setDriverName(tracking.getDriverName());
        existing.setCurrentLocation(tracking.getCurrentLocation());
        existing.setShipmentId(tracking.getShipmentId());
        existing.setTimestamp(LocalDateTime.now());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
