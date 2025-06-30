package com.roy.logistics_app.controller;

import com.roy.logistics_app.entity.Tracking;
import com.roy.logistics_app.service.TrackingService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tracking")
@RequiredArgsConstructor
public class TrackingController {

    private final TrackingService trackingService;

    @PostMapping
    public ResponseEntity<Tracking> addTracking(@RequestBody TrackingRequest req) {
        Tracking tracking = trackingService.saveTracking(req.getShipmentId(), req.getLocation(), req.getStatus());
        return ResponseEntity.ok(tracking);
    }

    @GetMapping("/{shipmentId}")
    public ResponseEntity<List<Tracking>> getTracking(@PathVariable Long shipmentId) {
        return ResponseEntity.ok(trackingService.getTrackingForShipment(shipmentId));
    }

    @Data
    static class TrackingRequest {
        private Long shipmentId;
        private String location;
        private String status;
    }
}
