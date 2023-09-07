/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bkt.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "tour_image")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TourImage.findAll", query = "SELECT t FROM TourImage t"),
    @NamedQuery(name = "TourImage.findById", query = "SELECT t FROM TourImage t WHERE t.id = :id"),
    @NamedQuery(name = "TourImage.findByImageUrl", query = "SELECT t FROM TourImage t WHERE t.imageUrl = :imageUrl")})
public class TourImage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "image_url")
    private String imageUrl;
    @JoinColumn(name = "tour_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tour tourId;

    public TourImage() {
    }

    public TourImage(Integer id) {
        this.id = id;
    }

    public TourImage(Integer id, String imageUrl) {
        this.id = id;
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TourImage)) {
            return false;
        }
        TourImage other = (TourImage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bkt.pojo.TourImage[ id=" + id + " ]";
    }
    
}
