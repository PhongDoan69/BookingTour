/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bkt.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kyan2
 */
@Entity
@Table(name = "order_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderDetail.findAll", query = "SELECT o FROM OrderDetail o"),
    @NamedQuery(name = "OrderDetail.findByOrderDetailId", query = "SELECT o FROM OrderDetail o WHERE o.orderDetailId = :orderDetailId"),
    @NamedQuery(name = "OrderDetail.findByCountAdult", query = "SELECT o FROM OrderDetail o WHERE o.countAdult = :countAdult"),
    @NamedQuery(name = "OrderDetail.findByCountChild", query = "SELECT o FROM OrderDetail o WHERE o.countChild = :countChild"),
    @NamedQuery(name = "OrderDetail.findByPriceAdult", query = "SELECT o FROM OrderDetail o WHERE o.priceAdult = :priceAdult"),
    @NamedQuery(name = "OrderDetail.findByPriceChild", query = "SELECT o FROM OrderDetail o WHERE o.priceChild = :priceChild"),
    @NamedQuery(name = "OrderDetail.findByTotalPrice", query = "SELECT o FROM OrderDetail o WHERE o.totalPrice = :totalPrice")})
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_detail_id")
    private Integer orderDetailId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "count_adult")
    private BigDecimal countAdult;
    @Basic(optional = false)
    @NotNull
    @Column(name = "count_child")
    private BigDecimal countChild;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price_adult")
    private BigDecimal priceAdult;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price_child")
    private BigDecimal priceChild;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_price")
    private BigDecimal totalPrice;
    @Lob
    @Size(max = 65535)
    @Column(name = "note")
    private String note;
    
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrderTable orderId;
    
    @JoinColumn(name = "tour_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tour tourId;

    public OrderDetail() {
    }

    public OrderDetail(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public OrderDetail(Integer orderDetailId, BigDecimal countAdult, BigDecimal countChild, BigDecimal priceAdult, BigDecimal priceChild, BigDecimal totalPrice) {
        this.orderDetailId = orderDetailId;
        this.countAdult = countAdult;
        this.countChild = countChild;
        this.priceAdult = priceAdult;
        this.priceChild = priceChild;
        this.totalPrice = totalPrice;
    }

    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public BigDecimal getCountAdult() {
        return countAdult;
    }

    public void setCountAdult(BigDecimal countAdult) {
        this.countAdult = countAdult;
    }

    public BigDecimal getCountChild() {
        return countChild;
    }

    public void setCountChild(BigDecimal countChild) {
        this.countChild = countChild;
    }

    public BigDecimal getPriceAdult() {
        return priceAdult;
    }

    public void setPriceAdult(BigDecimal priceAdult) {
        this.priceAdult = priceAdult;
    }

    public BigDecimal getPriceChild() {
        return priceChild;
    }

    public void setPriceChild(BigDecimal priceChild) {
        this.priceChild = priceChild;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public OrderTable getOrderId() {
        return orderId;
    }

    public void setOrderId(OrderTable orderId) {
        this.orderId = orderId;
    }

    public Tour getTourId() {
        return tourId;
    }

    public void setTourId(Tour tourId) {
        this.tourId = tourId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderDetailId != null ? orderDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderDetail)) {
            return false;
        }
        OrderDetail other = (OrderDetail) object;
        if ((this.orderDetailId == null && other.orderDetailId != null) || (this.orderDetailId != null && !this.orderDetailId.equals(other.orderDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bkt.pojo.OrderDetail[ orderDetailId=" + orderDetailId + " ]";
    }
    
}
