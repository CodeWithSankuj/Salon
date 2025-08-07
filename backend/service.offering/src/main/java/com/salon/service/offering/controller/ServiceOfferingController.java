package com.salon.service.offering.controller;

import com.salon.service.offering.modal.ServiceOffering;
import com.salon.service.offering.service.ServiceOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/service-offering")
@RequiredArgsConstructor
public class ServiceOfferingController {
    private final ServiceOfferingService _serviceOfferingService;
    @GetMapping("/salon/{salonId}")
    public ResponseEntity<?>  getServicesBySalonId(@PathVariable Long salonId, @RequestParam(required = false) Long categoryId) {
        return new ResponseEntity<>(_serviceOfferingService.getAllServicesBySalonId(salonId, categoryId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getServiceOfferingById(@PathVariable Long id) {
        ServiceOffering serviceOffering  = _serviceOfferingService.getServiceOfferingById(id);
        if(serviceOffering == null) return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(serviceOffering, HttpStatus.OK);
    }

    @GetMapping("/list/{ids}")
    public ResponseEntity<?> getServiceOfferingByIds(@PathVariable Set<Long> ids) {
            return new ResponseEntity<>(_serviceOfferingService.getServicesByIds(ids), HttpStatus.OK);
    }
}
