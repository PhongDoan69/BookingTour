/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bkt.repository.Impl;

import com.bkt.pojo.News;
import com.bkt.repository.NewsRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kyan2
 */
@Repository
@Transactional
public class NewsRepositoryImpl implements NewsRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public boolean addNews(News n) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (n != null) {
                s.save(n);
                return true;
            } 
            
            return false;
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateNews(News n) {
        return false;
    }

    @Override
    public List<News> listNews() {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<News> q = b.createQuery(News.class);
        Root root = q.from(News.class);
        q.select(root);
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }

}
