/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bkt.handlers;

import com.bkt.pojo.User;
import com.bkt.service.UserService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author kyan2
 */
@Component
public class LoginHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication a) throws IOException, ServletException {
        User u = this.userService.getUserByUn(a.getName());
        Cookie cookie = new Cookie("current-user", u.getId().toString());
        
        res.addCookie(cookie);
       
        System.err.println("id ------------------------------ id " + u.getId().toString());
        res.sendRedirect("/bookingtour/");
    }

}
