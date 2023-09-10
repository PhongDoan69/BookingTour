/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bkt.service.Impl;

import com.bkt.pojo.TourImage;
import com.bkt.repository.TourImageRepository;
import com.bkt.service.TourImageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kyan2
 */
@Service
public class TourImageServiceImpl implements TourImageService{
    @Autowired
    private TourImageRepository tourImageRepo;
    
  

    @Override
    public List<TourImage> listTourImageByTourId(int id) {
         return this.tourImageRepo.listTourImageByTourId(id);
    }
    
}
