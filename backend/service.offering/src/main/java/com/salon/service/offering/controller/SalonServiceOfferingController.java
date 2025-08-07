package com.salon.service.offering.controller;

import com.salon.service.offering.dto.CategoryDTO;
import com.salon.service.offering.dto.SalonDTO;
import com.salon.service.offering.dto.ServiceOfferingDTO;
import com.salon.service.offering.modal.ServiceOffering;
import com.salon.service.offering.service.ServiceOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/service-offering/salon-owner")
public class SalonServiceOfferingController {
    private final ServiceOfferingService _serviceOfferingService;

    @PostMapping
    public ResponseEntity<?> saveServiceOffering(@RequestBody ServiceOfferingDTO serviceOfferingDTO) {
        SalonDTO salonDTO = new SalonDTO();
        salonDTO.setId(1L);

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(serviceOfferingDTO.getCategoryId());
        ServiceOffering serviceOffering = _serviceOfferingService.createServiceOffering(salonDTO, categoryDTO, serviceOfferingDTO);
        return new ResponseEntity<>(serviceOffering, HttpStatus.CREATED);
    }

    @PutMapping("/{serviceId}")
    public ResponseEntity<?> updateServiceOffering(@PathVariable Long serviceId, @RequestBody ServiceOffering serviceOfferingDTO) {

        ServiceOffering serviceOffering = _serviceOfferingService.updateServiceOffering(serviceId, serviceOfferingDTO);
        return new ResponseEntity<>(serviceOffering, HttpStatus.CREATED);
    }
}
