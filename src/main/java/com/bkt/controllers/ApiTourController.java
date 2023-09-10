/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bkt.controllers;

import com.bkt.pojo.Tour;
import com.bkt.service.CategoryService;
import com.bkt.service.TourService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author kyan2
 */
@RestController
@RequestMapping("/api")
public class ApiTourController {

    @Autowired
    private TourService tourService;

//    @DeleteMapping("/tours/{id}")
//    @CrossOrigin
//    public ResponseEntity<String> delete(@PathVariable(value = "id") int id) {
//        if(this.tourService.deleteTour(id))
//        {
//            return new ResponseEntity<>("successful", HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>("failure", HttpStatus.BAD_REQUEST);
//    }
    
    @RequestMapping("/tours/")
    @CrossOrigin
    public ResponseEntity<List<Tour>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.tourService.getTours(params), HttpStatus.OK);
    }

    @GetMapping("/tours/category/{categoryId}")
    @CrossOrigin
    public ResponseEntity<List<Tour>> getToursByCategory(@PathVariable int categoryId) {
        if (this.tourService.getTourByCategory(categoryId) != null) {
            return new ResponseEntity<>(this.tourService.getTourByCategory(categoryId), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(path = "/tours/{tourId}/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Tour> getDetailTour(@PathVariable(value = "tourId") int tourId) {
        Tour tour = this.tourService.getTourById(tourId);

        if (tour != null) {
          
            if (tour.getFile() != null && tour.getFile().isEmpty()) {
                tour.setFile(null);
            }
            return new ResponseEntity<>(tour, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PatchMapping("/tours/{tourId}/")
    @CrossOrigin
    public ResponseEntity<String> delete(@PathVariable(value = "id") int id) {
        if (this.tourService.deleteTour(id)) {
            return new ResponseEntity<>("delete successful", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("delete failure", HttpStatus.BAD_REQUEST);
    }
    
    
    @DeleteMapping("/tours/{tourId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTours(@PathVariable(value = "tourId") int id) {
        this.tourService.deleteTour(id);
    }

//    @PostMapping(path = "/products", consumes = {
//        MediaType.MULTIPART_FORM_DATA_VALUE,
//        MediaType.APPLICATION_JSON_VALUE
//    })
//    @ResponseStatus(HttpStatus.CREATED)
//    public void add(@RequestParam Map<String, String> params, @RequestPart MultipartFile[] file) {
//        Tour p = new Tour();
//        p.setName(params.get("name"));
//        p.setDescription(params.get("description"));
//        p.setPrice(Long.parseLong(params.get("price")));
//        p.setCategoryId(this.cateService.getCateById(Integer.parseInt(params.get("categoryId"))));
//        if (file.length > 0)
//            p.setFile(file[0]);
//        this.prodService.addOrUpdateProduct(p);
//    }
}
