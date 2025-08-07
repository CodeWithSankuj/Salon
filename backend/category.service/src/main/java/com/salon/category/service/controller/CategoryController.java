package com.salon.category.service.controller;

import com.salon.category.service.modal.Category;
import com.salon.category.service.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService _cateogryService;
    @GetMapping("/salon/{id}")
    public ResponseEntity<?> getCategoryBySalon(@PathVariable Long id) throws Exception{
        return new ResponseEntity<>(_cateogryService.getAllCategoryBySalon(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id) throws Exception{
        return new ResponseEntity<>(_cateogryService.getCategoryById(id), HttpStatus.OK);
    }
}
