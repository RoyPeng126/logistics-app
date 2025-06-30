package com.roy.logistics_app.service;

import com.roy.logistics_app.entity.Shipment;
import com.roy.logistics_app.entity.Tracking;
import com.roy.logistics_app.repository.ShipmentRepository;
import com.roy.logistics_app.repository.TrackingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrackingService {

    private final TrackingRepository trackingRepository;
    private final ShipmentRepository shipmentRepository;

    public Tracking saveTracking(Long shipmentId, String location, String status) {
        Shipment shipment = shipmentRepository.findById(shipmentId)
            .orElseThrow(() -> new RuntimeException("Shipment not found"));
        Tracking tracking = new Tracking();
        tracking.setShipment(shipment);
        tracking.setLocation(location);
        tracking.setStatus(status);
        tracking.setTimestamp(LocalDateTime.now());
        return trackingRepository.save(tracking);
    }

    public List<Tracking> getTrackingForShipment(Long shipmentId) {
        return trackingRepository.findByShipmentId(shipmentId);
    }
}
