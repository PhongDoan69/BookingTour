/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bkt.controllers;

import com.bkt.pojo.TourImage;
import com.bkt.service.TourImageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kyan2
 */
@RestController
@RequestMapping("/api")
public class ApiTourImageController {
    
    @Autowired
    private TourImageService tourImageService;
    
    @RequestMapping("/tour_image/{tourId}")
    @CrossOrigin
    public ResponseEntity<List<TourImage>> list(@PathVariable("tourId") int id) {
        return new ResponseEntity<>(this.tourImageService.listTourImageByTourId(id), HttpStatus.OK);
    }
}
