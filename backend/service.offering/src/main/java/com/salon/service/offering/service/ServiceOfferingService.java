package com.salon.service.offering.service;

import com.salon.service.offering.dto.CategoryDTO;
import com.salon.service.offering.dto.SalonDTO;
import com.salon.service.offering.dto.ServiceOfferingDTO;
import com.salon.service.offering.modal.ServiceOffering;

import java.util.Set;

public interface ServiceOfferingService {
    ServiceOffering createServiceOffering(SalonDTO salonDTO, CategoryDTO categoryDTO, ServiceOfferingDTO serviceOfferingDTO);
    ServiceOffering getServiceOffering(Long Id);
    ServiceOffering updateServiceOffering(Long Id, ServiceOffering serviceOffering);
    void deleteServiceOffering(Long Id);
    Set<ServiceOffering> getAllServicesBySalonId(Long salonId, Long categoryId);
    Set<ServiceOffering> getServicesByIds(Set<Long> ids);
    ServiceOffering getServiceOfferingById(Long Id);
}
