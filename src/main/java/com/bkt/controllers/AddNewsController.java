/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bkt.controllers;

import com.bkt.pojo.News;
import com.bkt.service.NewsService;
import java.sql.Date;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author kyan2
 */
@Controller
public class AddNewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping("/addNews")
    public String addNewsPage(Model model) {
        News news = new News(); 
      
        model.addAttribute("news", news); 
        return "addNews"; //
    }

    @PostMapping("/addNews")
    public String add(@ModelAttribute(value = "news") News n) {
        if (n != null) {
            LocalDate localDate = LocalDate.now();

            Date date = Date.valueOf(localDate);

            n.setPostDate(date);

            if (this.newsService.addNews(n) == true) {
                return "redirect:/news";
            }
        }

        return "addNews";
    }
}
