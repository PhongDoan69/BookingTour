/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bkt.repository.Impl;

import com.bkt.pojo.News;
import com.bkt.pojo.Tour;
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
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kyan2
 */
@Repository
@Transactional
@PropertySource("classpath:configs.properties")
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
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<News> criteriaQuery = criteriaBuilder.createQuery(News.class);
        Root<News> root = criteriaQuery.from(News.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("isDelete"), 1));
        Query query = session.createQuery(criteriaQuery);

        return query.getResultList();
    }

    @Override
    public boolean deleteNews(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        News n = this.getNewsById(id);

        try {
            n.setIsDelete(0);
            s.save(n);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public News getNewsById(int id) {
       Session session = this.factory.getObject().getCurrentSession();
        
       return session.get(News.class, id);
    }

}
