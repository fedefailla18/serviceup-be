package com.serviceup.serviceup.repository;

import com.serviceup.serviceup.model.ServiceRequest;
import com.serviceup.serviceup.model.ServiceRequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, UUID> {

    List<ServiceRequest> findByStatus(ServiceRequestStatus status);

    List<ServiceRequest> findByCustomerId(UUID consumerId);

}
