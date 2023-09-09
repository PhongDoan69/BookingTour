/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bkt.controllers;

import com.bkt.pojo.Tour;
import com.bkt.service.TourService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author admin
 */
@Controller
public class TourController {
    @Autowired
    private TourService tourService;
    
    @GetMapping("/tours")
    public String list(Model model, 
            @RequestParam Map<String, String> params) {
        model.addAttribute("tours", this.tourService.getTours(params));
        
        return "tours";
    }
    
    @GetMapping("/tours/{tourId}")
    public String update(Model model, @PathVariable(value = "tourId") int id) {
        model.addAttribute("tour", this.tourService.getTourById(id));
        
        return "tours";
    }
    
    @PostMapping("/tours")
    public String add(@ModelAttribute(value = "tour") @Valid Tour t, BindingResult rs) {
        if (!rs.hasErrors())
            if (this.tourService.addOrUpdateTour(t) == true)
                return "redirect:/";
        
        return "tours";
    }
    
    
}
