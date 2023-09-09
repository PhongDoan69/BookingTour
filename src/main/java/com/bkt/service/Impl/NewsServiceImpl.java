/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bkt.service.Impl;

import com.bkt.pojo.News;
import com.bkt.repository.NewsRepository;
import com.bkt.service.NewsService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author kyan2
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepo;

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public boolean addNews(News n) {
        if (!n.getFile().isEmpty()) {
            
            String folderName = "news";

            
            Map params = ObjectUtils.asMap(
                    "folder", folderName
            );
            
                   
            try {
                Map res = this.cloudinary.uploader().upload( n.getFile().getBytes(), params);
                    
                String link = res.get("secure_url").toString();
                
                n.setImageCover(link);
                   
                this.newsRepo.addNews(n);
                
                return true;
            } catch (IOException ex) {
                Logger.getLogger(TourServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean updateNews(News n) {
        return newsRepo.updateNews(n);
    }

    @Override
    public List<News> listNews() {
        return newsRepo.listNews();
    }

}
