/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bkt.controllers;

import com.bkt.pojo.News;
import com.bkt.service.NewsService;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kyan2
 */
@RestController
@RequestMapping("/api")
public class ApiNewsController {

    @Autowired
    private NewsService newsService;

//    @PostMapping("/news/")
//    @CrossOrigin
//    public ResponseEntity<String> add(@RequestBody News n) {
//
//        LocalDate myObj = LocalDate.now();
//        Date date = Date.from(myObj.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
//        n.setPostDate(date);
//        System.out.println(n.getTitle() + " " + n.getContent() + " " + n.getPostDate());
//        if (this.newsService.addNews(n) == true) {
//            return new ResponseEntity<>("post news succesful.!", HttpStatus.CREATED);
//        }
//        return new ResponseEntity<>("failure.!", HttpStatus.BAD_REQUEST);
//
//    }

}
