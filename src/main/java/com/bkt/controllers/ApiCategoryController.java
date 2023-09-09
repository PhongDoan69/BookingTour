/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bkt.controllers;

import com.bkt.pojo.Category;
import com.bkt.pojo.Tour;
import com.bkt.service.CategoryService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author kyan2
 */
@Controller
@RequestMapping("/api")
public class ApiCategoryController {

    @Autowired
    private CategoryService cateService;

    @RequestMapping("/categories/")
    @CrossOrigin
    public ResponseEntity<List<Category>> list() {
        if (this.cateService.getCates() != null) {
            return new ResponseEntity<>(this.cateService.getCates(), HttpStatus.OK);

        } 
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

}
