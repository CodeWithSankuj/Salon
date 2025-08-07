package com.salon.service.offering.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CategoryDTO {
    private Long Id;

    private String name;

    private String image;

    private Long salonId;
}
