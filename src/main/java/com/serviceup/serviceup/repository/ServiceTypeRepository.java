package com.serviceup.serviceup.repository;

import com.serviceup.serviceup.model.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ServiceTypeRepository extends JpaRepository<ServiceType, UUID> {

    Optional<ServiceType> findById(UUID serviceTypeId);

}
