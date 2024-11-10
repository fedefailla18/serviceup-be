package com.serviceup.serviceup.service;

import com.serviceup.serviceup.model.ServiceRequest;
import com.serviceup.serviceup.model.ServiceRequestStatus;
import com.serviceup.serviceup.model.ServiceType;
import com.serviceup.serviceup.model.User;
import com.serviceup.serviceup.repository.ServiceRequestRepository;
import com.serviceup.serviceup.repository.ServiceTypeRepository;
import com.serviceup.serviceup.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ServiceRequestService {

    private final ServiceRequestRepository serviceRequestRepository;
    private final UserRepository userRepository;
    private final ServiceTypeRepository serviceTypeRepository;

    public ServiceRequest createServiceRequest(ServiceRequest serviceRequest, UUID customerId, UUID serviceTypeId) {
        User customer = userRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        ServiceType serviceType = serviceTypeRepository.findById(serviceTypeId)
                .orElseThrow(() -> new RuntimeException("Service type not found"));

        serviceRequest.setCustomer(customer);
        serviceRequest.setServiceType(serviceType);
        return serviceRequestRepository.save(serviceRequest);
    }

    public List<ServiceRequest> getServiceRequestsByCustomer(UUID customerId) {
        return serviceRequestRepository.findByCustomerId(customerId);
    }

    public List<ServiceRequest> getOpenServiceRequests() {
        return serviceRequestRepository.findByStatus(ServiceRequestStatus.OPEN);
    }
}