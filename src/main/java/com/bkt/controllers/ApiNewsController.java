/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bkt.controllers;

import com.bkt.pojo.News;
import com.bkt.service.NewsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @DeleteMapping("/news/{newsId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNews(@PathVariable(value = "newsId") int id) {
        this.newsService.deleteNews(id);
    }
    
    

    @RequestMapping("/news/")
    @CrossOrigin
    public ResponseEntity<List<News>> list() {
        return new ResponseEntity<>(this.newsService.listNews(), HttpStatus.OK);
    }
    
    
    @RequestMapping(path = "/news/{newsId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<News> getDetailNews(@PathVariable(value = "newsId") int newsId) {
       return new ResponseEntity<>(this.newsService.getNewsById(newsId), HttpStatus.OK);
    }
}
