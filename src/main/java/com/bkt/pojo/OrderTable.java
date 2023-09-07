/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bkt.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kyan2
 */
@Entity
@Table(name = "order_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderTable.findAll", query = "SELECT o FROM OrderTable o"),
    @NamedQuery(name = "OrderTable.findById", query = "SELECT o FROM OrderTable o WHERE o.id = :id"),
    @NamedQuery(name = "OrderTable.findByOrderDate", query = "SELECT o FROM OrderTable o WHERE o.orderDate = :orderDate"),
    @NamedQuery(name = "OrderTable.findByPaymentMethod", query = "SELECT o FROM OrderTable o WHERE o.paymentMethod = :paymentMethod"),
    @NamedQuery(name = "OrderTable.findByState", query = "SELECT o FROM OrderTable o WHERE o.state = :state"),
    @NamedQuery(name = "OrderTable.findByTotalAmount", query = "SELECT o FROM OrderTable o WHERE o.totalAmount = :totalAmount")})
public class OrderTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_date")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @Size(max = 8)
    @Column(name = "payment_method")
    private String paymentMethod;
    @Size(max = 10)
    @Column(name = "state")
    private String state;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_amount")
    private BigDecimal totalAmount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId")
    private Set<OrderDetail> orderDetailSet;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User accountId;

    public OrderTable() {
    }

    public OrderTable(Integer id) {
        this.id = id;
    }

    public OrderTable(Integer id, Date orderDate) {
        this.id = id;
        this.orderDate = orderDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @XmlTransient
    public Set<OrderDetail> getOrderDetailSet() {
        return orderDetailSet;
    }

    public void setOrderDetailSet(Set<OrderDetail> orderDetailSet) {
        this.orderDetailSet = orderDetailSet;
    }

    public User getAccountId() {
        return accountId;
    }

    public void setAccountId(User accountId) {
        this.accountId = accountId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderTable)) {
            return false;
        }
        OrderTable other = (OrderTable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bkt.pojo.OrderTable[ id=" + id + " ]";
    }
    
}
