package com.salon.service.offering.dto;

import lombok.Data;

@Data
public class ServiceOfferingDTO {
    private Long id;

    private String name;

    private String description;

    private int price;

    private int duration;

    private Long salonId;

    private Long categoryId;

    private String image;
}
