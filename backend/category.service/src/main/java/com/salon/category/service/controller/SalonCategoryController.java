package com.salon.category.service.controller;

import com.salon.category.service.dto.SalonDTO;
import com.salon.category.service.modal.Category;
import com.salon.category.service.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/categories/salon-owner")
public class SalonCategoryController {
    private final CategoryService _categoryService;
    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody @Validated Category category){
        SalonDTO salonDTO = new SalonDTO();
        salonDTO.setId(1L);
        return new ResponseEntity<>(_categoryService.saveCategory(category, salonDTO), HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteCategory(@RequestParam Long id) throws Exception {
        _categoryService.deleteCategoryById(id);
        return new ResponseEntity<>("Category deleted",HttpStatus.NO_CONTENT);
    }
}
