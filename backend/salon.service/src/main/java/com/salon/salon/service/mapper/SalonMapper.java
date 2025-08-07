package com.salon.salon.service.mapper;

import com.salon.salon.service.dto.SalonDTO;
import com.salon.salon.service.modal.Salon;

import java.util.ArrayList;
import java.util.List;

public class SalonMapper {
    public static Salon map(SalonDTO salon) {
        Salon salonEntity = new Salon();
        salonEntity.setAddress(salon.getAddress());
        salonEntity.setCloseTime(salon.getCloseTime());
        salonEntity.setName(salon.getName());
        salonEntity.setEmail(salon.getEmail());
        salonEntity.setImages(salon.getImages());
        salonEntity.setCity(salon.getCity());
        salonEntity.setId(salon.getId());
        salonEntity.setPhoneNumber((salon.getPhoneNumber()));
        salonEntity.setOpenTime(salon.getOpenTime());
        salonEntity.setOwnerId(salon.getOwnerId());
        return salonEntity;
    }

    public static SalonDTO map(Salon salon) {
        SalonDTO salonEntity = new SalonDTO();
        salonEntity.setAddress(salon.getAddress());
        salonEntity.setCloseTime(salon.getCloseTime());
        salonEntity.setName(salon.getName());
        salonEntity.setEmail(salon.getEmail());
        salonEntity.setImages(salon.getImages());
        salonEntity.setCity(salon.getCity());
        salonEntity.setId(salon.getId());
        salonEntity.setPhoneNumber((salon.getPhoneNumber()));
        salonEntity.setOpenTime(salon.getOpenTime());
        salonEntity.setOwnerId(salon.getOwnerId());
        return salonEntity;
    }

    public static List<SalonDTO> map(List<Salon> salons) {
        List<SalonDTO> list = new ArrayList<>();
        for (Salon salon : salons) {
            list.add(map(salon));
        }
        return list;
    }
}
