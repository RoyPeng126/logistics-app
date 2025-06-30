package com.roy.logistics_app.repository;

import com.roy.logistics_app.model.DriverTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DriverTrackingRepository extends JpaRepository<DriverTracking, Long> {
    List<DriverTracking> findByDriverName(String driverName);
    List<DriverTracking> findByShipmentId(String shipmentId);
}
