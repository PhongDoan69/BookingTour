/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bkt.controllers;

import com.bkt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author kyan2
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    
    @RequestMapping("/users")
    public String list(Model model){
        model.addAttribute("users", this.userService.listUser());
        return "user";
    }
    
   
}
