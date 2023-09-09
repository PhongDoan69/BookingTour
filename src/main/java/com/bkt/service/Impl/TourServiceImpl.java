/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bkt.service.Impl;

import com.bkt.pojo.Tour;
import com.bkt.repository.TourRepository;
import com.bkt.service.TourService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kyan2
 */
@Service
public class TourServiceImpl implements TourService{
    @Autowired
    private TourRepository tourRepo;
    @Autowired
    private Cloudinary cloudinary;
    
    @Override
    public List<Tour> getTours(Map<String, String> params) {
        return this.tourRepo.getTours(params);
    }

    @Override
    public int countTours() {
      return this.tourRepo.countTours();
    }

    @Override
    public boolean addOrUpdateTour(Tour t) {
        //p.setImage("https://res.cloudinary.com/dxxwcby8l/image/upload/v1647248652/dkeolz3ghc0eino87iec.jpg");
        if (!t.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(t.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                t.setImageCover(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(TourServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.tourRepo.addOrUpdateTour(t);
    }

    @Override
    public Tour getTourById(int id) {
        return this.tourRepo.getTourById(id);
    }

    @Override
    public boolean deleteTour(int id) {
        return this.tourRepo.deleteTour(id);
    }

    @Override
    public List<Tour> getTourByCategory(int id) {
        return this.tourRepo.getTourByCategory(id);
    }
    
}
