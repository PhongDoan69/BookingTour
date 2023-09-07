package com.bkt.service.Impl;


import com.bkt.pojo.Category;
import com.bkt.repository.CategoryRepository;
import com.bkt.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository cateRepo;

    @Override
    public List<Category> getCates() {
        return cateRepo.getCates();
    }

  
}
