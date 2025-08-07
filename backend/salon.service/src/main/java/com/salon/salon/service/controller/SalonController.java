package com.salon.salon.service.controller;

import com.salon.salon.service.dto.SalonDTO;
import com.salon.salon.service.dto.UserDTO;
import com.salon.salon.service.mapper.SalonMapper;
import com.salon.salon.service.modal.Salon;
import com.salon.salon.service.service.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salons")
@RequiredArgsConstructor
public class SalonController {
    private final SalonService salonService;
    @PostMapping
    public ResponseEntity<SalonDTO> createSalons(@RequestBody SalonDTO salonDTO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        salonDTO.setOwnerId(1L);
        Salon salon = salonService.createSalon(salonDTO, userDTO);
        SalonDTO salonDTO1 = SalonMapper.map(salon);
        return ResponseEntity.ok(salonDTO1);
    }

    @PatchMapping("/{salonId}")
    public ResponseEntity<?> updateSalons(@PathVariable Long salonId, @RequestBody SalonDTO salonDTO) {
        try {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(1L);
            Salon salon = salonService.updateSalon(salonDTO, userDTO, salonId);
            SalonDTO salonDTO1 = SalonMapper.map(salon);
            return new ResponseEntity<>(salonDTO1, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("No record found ! ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllSalons() {
        try {
            List<SalonDTO> salons = SalonMapper.map(salonService.getSalons());
            return new ResponseEntity<>(salons, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("No record found ! ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{salonId}")
    public ResponseEntity<?> getSalons(@PathVariable Long salonId) {
        Salon salon = salonService.getSalonById(salonId);
        if(salon == null) return new ResponseEntity<>("No record Found", HttpStatus.NOT_FOUND);
        SalonDTO salonDTO = SalonMapper.map(salon);
        return new ResponseEntity<>(salonDTO, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchSalons(@RequestParam String city) {
        List<Salon> salonList = salonService.searchSalonByCity(city);
        List<SalonDTO> salonDTOs = SalonMapper.map(salonList);
        return new ResponseEntity<>(salonDTOs, HttpStatus.OK);
    }
}
