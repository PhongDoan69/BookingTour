/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bkt.controllers;

import com.bkt.service.CategoryService;
import com.bkt.service.TourService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author kyan2
 */
@Controller
@ControllerAdvice
public class IndexController {
    @Autowired
    private CategoryService cateService;
    @Autowired
    private TourService tourService;
    @Autowired
    private Environment env;
    
   
    @RequestMapping("/")    
    public String index(Model model, 
            @RequestParam Map<String, String> params) {
        model.addAttribute("tours", this.tourService.getTours(params));
        
        int count = this.tourService.countTours();
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        model.addAttribute("pages", Math.ceil(count*1.0/pageSize));
        
        return "index";
    }
}
