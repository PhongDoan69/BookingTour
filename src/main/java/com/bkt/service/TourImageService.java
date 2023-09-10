/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bkt.service;

import com.bkt.pojo.TourImage;
import java.util.List;

/**
 *
 * @author kyan2
 */
public interface TourImageService {
    List<TourImage> listTourImageByTourId(int id);
}
