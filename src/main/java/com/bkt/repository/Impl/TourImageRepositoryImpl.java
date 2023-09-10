/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bkt.repository.Impl;

import com.bkt.pojo.Tour;
import com.bkt.pojo.TourImage;
import com.bkt.repository.TourImageRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kyan2
 */
@Repository
@Transactional
public class TourImageRepositoryImpl implements TourImageRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<TourImage> listTourImageByTourId(int id) {
         Session s = this.factory.getObject().getCurrentSession();

        CriteriaBuilder b = s.getCriteriaBuilder();

        CriteriaQuery<TourImage> q = b.createQuery(TourImage.class);

        Root<TourImage> r = q.from(TourImage.class);

        q.select(r).where(b.equal(r.get("tourId"), id));

        Query query = s.createQuery(q);

        return query.getResultList();
    }
    
}
