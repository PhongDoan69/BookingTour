/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bkt.service;

import com.bkt.pojo.Tour;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kyan2
 */
public interface TourService {
    List<Tour> getTours(Map<String, String> params);
    int countTours();
    boolean addOrUpdateTour(Tour p);
    Tour getTourById(int id);
    boolean deleteTour(int id);
    List<Tour> getTourByCategory(int id);
}
