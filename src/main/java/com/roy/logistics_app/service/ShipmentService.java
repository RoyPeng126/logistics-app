package com.roy.logistics_app.service;

import com.roy.logistics_app.entity.Shipment;
import com.roy.logistics_app.repository.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;

    public Shipment createShipment(Shipment shipment) {
        shipment.setStatus("PENDING");
        return shipmentRepository.save(shipment);
    }

    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }
}

