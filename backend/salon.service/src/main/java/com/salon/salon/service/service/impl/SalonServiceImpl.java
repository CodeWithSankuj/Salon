package com.salon.salon.service.service.impl;

import com.salon.salon.service.dto.SalonDTO;
import com.salon.salon.service.dto.UserDTO;
import com.salon.salon.service.mapper.SalonMapper;
import com.salon.salon.service.modal.Salon;
import com.salon.salon.service.repository.SalonRepository;
import com.salon.salon.service.service.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalonServiceImpl implements SalonService {
    private final SalonRepository _salonRepository;
    @Override
    public Salon createSalon(SalonDTO salon, UserDTO user) {
        Salon salonEntity = SalonMapper.map(salon);
        return _salonRepository.save(salonEntity);
    }

    @Override
    public Salon updateSalon(SalonDTO salon, UserDTO user, Long salonId) {
        Salon salonEntity = _salonRepository.findById(salonId).orElse(null);
        if(salonEntity!= null && salonEntity.getOwnerId().equals(user.getId())){
            salonEntity = SalonMapper.map(salon);
            salonEntity.setId(salonId);
            return  _salonRepository.save(salonEntity);
        }
        return null;
    }

    @Override
    public List<Salon> getSalons() {
        return _salonRepository.findAll();
    }

    @Override
    public Salon getSalonById(Long salonId) {
        return _salonRepository.findById(salonId).orElse(null);
    }

    @Override
    public Salon getSalonByOwnerId(Long ownerId) {
        return _salonRepository.findByOwnerId(ownerId);
    }

    @Override
    public List<Salon> searchSalonByCity(String city) {
        return _salonRepository.searchSalon(city);
    }

    @Override
    public void deleteSalonById(Long salonId) {
        _salonRepository.deleteById(salonId);
    }
}
