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
public class TourImageRepositoryImpl implements TourImageRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<TourImage> listTourImageByTourId(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = s.getCriteriaBuilder();
        CriteriaQuery<TourImage> criteriaQuery = criteriaBuilder.createQuery(TourImage.class);
        Root<TourImage> root = criteriaQuery.from(TourImage.class);

        criteriaQuery.select(criteriaBuilder.construct(
            TourImage.class,
            root.get("id"), 
            root.get("imageUrl")
        ));
        criteriaQuery.where(criteriaBuilder.equal(root.get("tourId"), id)); // Điều kiện truy vấn theo tourId

        return s.createQuery(criteriaQuery).getResultList();

    }

}
