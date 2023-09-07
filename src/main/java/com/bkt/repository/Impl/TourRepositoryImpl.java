/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bkt.repository.Impl;

import com.bkt.pojo.Tour;
import com.bkt.repository.TourRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
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
public class TourRepositoryImpl implements TourRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

   
    @Autowired
    private Environment env;

    @Override
    public List<Tour> getTours(Map<String, String> params) {

        Session s = this.factory.getObject().getCurrentSession();

        CriteriaBuilder b = s.getCriteriaBuilder();

        CriteriaQuery<Tour> q = b.createQuery(Tour.class);

        Root<Tour> r = q.from(Tour.class);

        q.select(r);

//        if (params != null && !params.isEmpty()) {
//            List<Predicate> predicates = new ArrayList<>();
//
//            String kw = params.get("kw");
//            if (kw != null && !kw.isEmpty()) {
//                predicates.add(b.like(r.get("tour_name").as(String.class), String.format("%%%s%%", kw)));
//            }
//
//            String fromPriceStr = params.get("fromPrice");
//            if (fromPriceStr != null && !fromPriceStr.isEmpty()) {
//
//                BigDecimal fromPrice = new BigDecimal(fromPriceStr);
//                predicates.add(b.greaterThanOrEqualTo(r.get("price").as(BigDecimal.class), fromPrice));
//            }
//
//            String toPriceStr = params.get("toPrice");
//            if (toPriceStr != null && !toPriceStr.isEmpty()) {
//
//                BigDecimal toPrice = new BigDecimal(toPriceStr);
//                predicates.add(b.lessThanOrEqualTo(r.get("price").as(BigDecimal.class), toPrice));
//            }
//
//            // Combine all predicates with 'AND' operator
//            if (!predicates.isEmpty()) {
//                q.where(b.and(predicates.toArray(new Predicate[0])));
//            }
//        }

        q.getOrderList();
        q.orderBy(b.desc(r.get("id")));

        Query query = s.createQuery(q);

//        if (params != null && !params.isEmpty()) {
//            String page = params.get("page");
//            if (page != null && !page.isEmpty()) {
//                int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
//                query.setMaxResults(pageSize);
//                query.setFirstResult((Integer.parseInt(page) - 1) * pageSize);
//            }
//        }
        return query.getResultList();
    }

    @Override
    public int countTours() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT COUNT(*) FROM Tour");

        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public boolean addOrUpdateTour(Tour t) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (t.getId() == null) {
                s.save(t);
            } else {
                s.update(t);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Tour getTourById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Tour.class, id);
    }

    @Override
    public boolean deleteTour(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Tour t = this.getTourById(id);

        try {
            s.delete(t);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

   

}
