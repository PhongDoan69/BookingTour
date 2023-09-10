/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bkt.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author kyan2
 */
@Entity
@Table(name = "tour")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tour.findAll", query = "SELECT t FROM Tour t"),
    @NamedQuery(name = "Tour.findById", query = "SELECT t FROM Tour t WHERE t.id = :id"),
    @NamedQuery(name = "Tour.findByTourName", query = "SELECT t FROM Tour t WHERE t.tourName = :tourName"),
    @NamedQuery(name = "Tour.findByImageCover", query = "SELECT t FROM Tour t WHERE t.imageCover = :imageCover"),
    @NamedQuery(name = "Tour.findByStartTour", query = "SELECT t FROM Tour t WHERE t.startTour = :startTour"),
    @NamedQuery(name = "Tour.findByConcentrate", query = "SELECT t FROM Tour t WHERE t.concentrate = :concentrate"),
    @NamedQuery(name = "Tour.findByStartingGate", query = "SELECT t FROM Tour t WHERE t.startingGate = :startingGate"),
    @NamedQuery(name = "Tour.findByNumberOfSeatsAvailable", query = "SELECT t FROM Tour t WHERE t.numberOfSeatsAvailable = :numberOfSeatsAvailable"),
    @NamedQuery(name = "Tour.findByGatheringPlace", query = "SELECT t FROM Tour t WHERE t.gatheringPlace = :gatheringPlace"),
    @NamedQuery(name = "Tour.findByTimeTour", query = "SELECT t FROM Tour t WHERE t.timeTour = :timeTour"),
    @NamedQuery(name = "Tour.findByTransport", query = "SELECT t FROM Tour t WHERE t.transport = :transport"),
    @NamedQuery(name = "Tour.findByHotel", query = "SELECT t FROM Tour t WHERE t.hotel = :hotel"),
    @NamedQuery(name = "Tour.findBySuitableSubject", query = "SELECT t FROM Tour t WHERE t.suitableSubject = :suitableSubject"),
    @NamedQuery(name = "Tour.findByEndow", query = "SELECT t FROM Tour t WHERE t.endow = :endow"),
    @NamedQuery(name = "Tour.findByPrice", query = "SELECT t FROM Tour t WHERE t.price = :price")})
public class Tour implements Serializable {

    /**
     * @return the isDelete
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * @param isDelete the isDelete to set
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tour_name")
    private String tourName;
    @Size(max = 255)
    @Column(name = "image_cover")
    private String imageCover;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "startTour")
    private String startTour;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "concentrate")
    private String concentrate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "starting_gate")
    private String startingGate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "number_of_seats_available")
    private int numberOfSeatsAvailable;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "gathering_place")
    private String gatheringPlace;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "timeTour")
    private String timeTour;
    @Size(max = 100)
    @Column(name = "transport")
    private String transport;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "sight_seeing")
    private String sightSeeing;
    @Lob
    @Size(max = 65535)
    @Column(name = "cuisine")
    private String cuisine;
    @Size(max = 100)
    @Column(name = "hotel")
    private String hotel;
    
   
    @Size(max = 100)
    @Column(name = "suitable_subject")
    private String suitableSubject;
    
    @Size(max = 100)
    @Column(name = "endow")
    private String endow;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private BigDecimal price;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "schedule")
    private String schedule;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tourId")
    @JsonIgnore
    private Set<OrderDetail> orderDetailSet;
    
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Category categoryId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tourId")
    @JsonIgnore
    private Set<TourImage> tourImageSet;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tourId")
    @JsonIgnore
    private Set<Review> reviewSet;

    @Transient
    private MultipartFile file;
    
    
    @Column(name = "is_delete")
    private Integer isDelete;
    
    public Tour() {
    }

    public Tour(Integer id) {
        this.id = id;
    }

    public Tour(Integer id, String tourName, String startTour, String concentrate, String startingGate, int numberOfSeatsAvailable, String gatheringPlace, String timeTour, String sightSeeing, String suitableSubject, BigDecimal price, String schedule) {
        this.id = id;
        this.tourName = tourName;
        this.startTour = startTour;
        this.concentrate = concentrate;
        this.startingGate = startingGate;
        this.numberOfSeatsAvailable = numberOfSeatsAvailable;
        this.gatheringPlace = gatheringPlace;
        this.timeTour = timeTour;
        this.sightSeeing = sightSeeing;
        this.suitableSubject = suitableSubject;
        this.price = price;
        this.schedule = schedule;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getImageCover() {
        return imageCover;
    }

    public void setImageCover(String imageCover) {
        this.imageCover = imageCover;
    }

    public String getStartTour() {
        return startTour;
    }

    public void setStartTour(String startTour) {
        this.startTour = startTour;
    }

    public String getConcentrate() {
        return concentrate;
    }

    public void setConcentrate(String concentrate) {
        this.concentrate = concentrate;
    }

    public String getStartingGate() {
        return startingGate;
    }

    public void setStartingGate(String startingGate) {
        this.startingGate = startingGate;
    }

    public int getNumberOfSeatsAvailable() {
        return numberOfSeatsAvailable;
    }

    public void setNumberOfSeatsAvailable(int numberOfSeatsAvailable) {
        this.numberOfSeatsAvailable = numberOfSeatsAvailable;
    }

    public String getGatheringPlace() {
        return gatheringPlace;
    }

    public void setGatheringPlace(String gatheringPlace) {
        this.gatheringPlace = gatheringPlace;
    }

    public String getTimeTour() {
        return timeTour;
    }

    public void setTimeTour(String timeTour) {
        this.timeTour = timeTour;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getSightSeeing() {
        return sightSeeing;
    }

    public void setSightSeeing(String sightSeeing) {
        this.sightSeeing = sightSeeing;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getSuitableSubject() {
        return suitableSubject;
    }

    public void setSuitableSubject(String suitableSubject) {
        this.suitableSubject = suitableSubject;
    }

    public String getEndow() {
        return endow;
    }

    public void setEndow(String endow) {
        this.endow = endow;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    @XmlTransient
    public Set<OrderDetail> getOrderDetailSet() {
        return orderDetailSet;
    }

    public void setOrderDetailSet(Set<OrderDetail> orderDetailSet) {
        this.orderDetailSet = orderDetailSet;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    @XmlTransient
    public Set<TourImage> getTourImageSet() {
        return tourImageSet;
    }

    public void setTourImageSet(Set<TourImage> tourImageSet) {
        this.tourImageSet = tourImageSet;
    }

    @XmlTransient
    public Set<Review> getReviewSet() {
        return reviewSet;
    }

    public void setReviewSet(Set<Review> reviewSet) {
        this.reviewSet = reviewSet;
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
        if (!(object instanceof Tour)) {
            return false;
        }
        Tour other = (Tour) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bkt.pojo.Tour[ id=" + id + " ]";
    }
    
}
