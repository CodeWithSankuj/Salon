package com.salon.salon.service.service;

import com.salon.salon.service.dto.SalonDTO;
import com.salon.salon.service.dto.UserDTO;
import com.salon.salon.service.modal.Salon;

import java.util.List;

public interface SalonService {
    Salon createSalon(SalonDTO salon, UserDTO user);
    Salon updateSalon(SalonDTO salon, UserDTO user, Long salonId);
    List<Salon> getSalons();
    Salon getSalonById(Long salonId);
    Salon getSalonByOwnerId(Long ownerId);
    List<Salon> searchSalonByCity(String city);
    void deleteSalonById(Long salonId);
}
