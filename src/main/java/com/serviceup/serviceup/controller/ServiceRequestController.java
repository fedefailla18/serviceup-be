package com.serviceup.serviceup.controller;

import com.serviceup.serviceup.model.ServiceRequest;
import com.serviceup.serviceup.service.ServiceRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/service-requests")
@RequiredArgsConstructor
public class ServiceRequestController {

    private final ServiceRequestService serviceRequestService;

    @PostMapping
    public ResponseEntity<ServiceRequest> createServiceRequest(@RequestBody ServiceRequest serviceRequest,
                                                               @RequestParam UUID serviceTypeId,
                                                               Authentication authentication) {
        UUID customerId = UUID.fromString(authentication.getName());
        ServiceRequest createdRequest = serviceRequestService.createServiceRequest(serviceRequest, customerId, serviceTypeId);
        return ResponseEntity.ok(createdRequest);
    }

    @GetMapping("/customer")
    public ResponseEntity<List<ServiceRequest>> getCustomerServiceRequests(Authentication authentication) {
        UUID customerId = UUID.fromString(authentication.getName());
        List<ServiceRequest> requests = serviceRequestService.getServiceRequestsByCustomer(customerId);
        return ResponseEntity.ok(requests);
    }

    @GetMapping("/open")
    public ResponseEntity<List<ServiceRequest>> getOpenServiceRequests() {
        List<ServiceRequest> requests = serviceRequestService.getOpenServiceRequests();
        return ResponseEntity.ok(requests);
    }
}