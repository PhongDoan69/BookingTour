/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bkt.repository;

import com.bkt.pojo.News;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kyan2
 */
public interface NewsRepository {
    boolean addNews(News n);
    boolean updateNews(News n);
    List<News> listNews();
}
