package com.salon.category.service.service;

import com.salon.category.service.dto.SalonDTO;
import com.salon.category.service.modal.Category;

import java.util.Set;

public interface CategoryService {
    Category saveCategory(Category category, SalonDTO salonDTO);
    Set<Category> getAllCategoryBySalon(Long salonId);
    Category getCategoryById(Long Id) throws Exception;
    void deleteCategoryById(Long Id) throws Exception;

}
