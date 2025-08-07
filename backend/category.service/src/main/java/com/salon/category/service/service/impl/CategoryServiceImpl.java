package com.salon.category.service.service.impl;

import com.salon.category.service.dto.SalonDTO;
import com.salon.category.service.modal.Category;
import com.salon.category.service.repository.CategoryRepository;
import com.salon.category.service.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository _categoryRepository;
    @Override
    public Category saveCategory(Category category, SalonDTO salonDTO) {
        Category category1 = new Category();
        category1.setSalonId(salonDTO.getId());
        category1.setName(category.getName());
        category1.setImage(category.getImage());
        return _categoryRepository.save(category1);
    }

    @Override
    public Set<Category> getAllCategoryBySalon(Long salonId) {
        return _categoryRepository.findBySalonId(salonId);
    }

    @Override
    public Category getCategoryById(Long Id) throws Exception {
        var category = _categoryRepository.findById(Id).orElse(null);

        if(category == null){
            throw new Exception("No data found");
        }
        return category;
    }

    @Override
    public void deleteCategoryById(Long Id) throws Exception {
        var category = _categoryRepository.findById(Id).orElse(null);

        if(category == null){
            throw new Exception("No data found");
        }
        _categoryRepository.delete(category);
    }
}
