/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bkt.repository.Impl;

import com.bkt.pojo.Category;
import com.bkt.repository.CategoryRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
public class CategoryRepositoryImpl implements CategoryRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

  
    @Override
    public List<Category> getCates() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("Category.findAll");
        
        return q.getResultList();
    }
    
    @Override
    public boolean deleteCategory(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Transaction tx = null;

        try {
            tx = s.beginTransaction();
            Category category = s.get(Category.class, id);

            if (category != null) {
                // Thay đổi thuộc tính is_delete thành false
                category.setIsDelete(0);
                s.update(category);
                tx.commit();
                return true;
            } else {
                return false; // Không tìm thấy Category với id cụ thể.
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace(); // Xử lý lỗi hoặc ghi log lỗi ở đây.
            return false;
        }
    }

}
