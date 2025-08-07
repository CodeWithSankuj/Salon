package com.salon.service.offering.service.impl;

import com.salon.service.offering.dto.CategoryDTO;
import com.salon.service.offering.dto.SalonDTO;
import com.salon.service.offering.dto.ServiceOfferingDTO;
import com.salon.service.offering.modal.ServiceOffering;
import com.salon.service.offering.repository.ServiceOfferingRepository;
import com.salon.service.offering.service.ServiceOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceOfferingServiceImpl implements ServiceOfferingService {
    private final ServiceOfferingRepository _serviceOfferingRepository;

    @Override
    public ServiceOffering createServiceOffering(SalonDTO salonDTO, CategoryDTO categoryDTO, ServiceOfferingDTO serviceOfferingDTO) {
        ServiceOffering serviceOffering = new ServiceOffering();
        serviceOffering.setSalonId(serviceOfferingDTO.getId());
        serviceOffering.setName(serviceOfferingDTO.getName());
        serviceOffering.setImage(serviceOfferingDTO.getImage());
        serviceOffering.setDescription(serviceOfferingDTO.getDescription());
        serviceOffering.setDuration(serviceOfferingDTO.getDuration());
        serviceOffering.setPrice(serviceOfferingDTO.getPrice());
        serviceOffering.setSalonId(salonDTO.getId());
        serviceOffering.setCategoryId(categoryDTO.getId());
        return _serviceOfferingRepository.save(serviceOffering);
    }

    @Override
    public ServiceOffering getServiceOffering(Long Id) {
        return null;
    }

    @Override
    public ServiceOffering updateServiceOffering(Long Id, ServiceOffering serviceOffering) {
        ServiceOffering serviceOffering1 = _serviceOfferingRepository.findById(Id).orElse(null);
        if(serviceOffering1 == null) return null;
        serviceOffering1.setSalonId(serviceOffering.getSalonId());
        serviceOffering1.setName(serviceOffering.getName());
        serviceOffering1.setImage(serviceOffering.getImage());
        serviceOffering1.setDescription(serviceOffering.getDescription());
        serviceOffering1.setDuration(serviceOffering.getDuration());
        serviceOffering1.setPrice(serviceOffering.getPrice());
        return _serviceOfferingRepository.save(serviceOffering1);
    }

    @Override
    public void deleteServiceOffering(Long Id) {

    }

    @Override
    public Set<ServiceOffering> getAllServicesBySalonId(Long salonId, Long categoryId) {
        Set<ServiceOffering>  serviceOfferings = _serviceOfferingRepository.findBySalonId(salonId);
        if(categoryId != null) {
            serviceOfferings = serviceOfferings.stream().filter(x -> x.getCategoryId().equals(categoryId)).collect(Collectors.toSet());
        }
        return serviceOfferings;
    }

    @Override
    public Set<ServiceOffering> getServicesByIds(Set<Long> ids) {
        List<ServiceOffering> serviceOfferings = _serviceOfferingRepository.findAllById(ids);
        return new HashSet<>(serviceOfferings);
    }

    @Override
    public ServiceOffering getServiceOfferingById(Long Id) {
            return _serviceOfferingRepository.findById(Id).orElse(null);
    }
}
