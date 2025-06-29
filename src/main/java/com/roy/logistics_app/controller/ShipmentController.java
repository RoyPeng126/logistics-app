package com.roy.logistics_app.controller;

import com.roy.logistics_app.entity.Shipment;
import com.roy.logistics_app.service.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipments")
@RequiredArgsConstructor
public class ShipmentController {

    private final ShipmentService shipmentService;

    @PostMapping
    public ResponseEntity<Shipment> createShipment(@RequestBody Shipment shipment) {
        return ResponseEntity.ok(shipmentService.createShipment(shipment));
    }

    @GetMapping
    public ResponseEntity<List<Shipment>> getShipments() {
        return ResponseEntity.ok(shipmentService.getAllShipments());
    }
}

