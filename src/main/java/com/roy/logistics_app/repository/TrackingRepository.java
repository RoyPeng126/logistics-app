package com.roy.logistics_app.repository;

import com.roy.logistics_app.entity.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackingRepository extends JpaRepository<Tracking, Long> {
    List<Tracking> findByShipmentId(Long shipmentId);
}
