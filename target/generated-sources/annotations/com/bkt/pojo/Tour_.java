package com.bkt.pojo;

import com.bkt.pojo.Category;
import com.bkt.pojo.OrderDetail;
import com.bkt.pojo.Review;
import com.bkt.pojo.TourImage;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-09-10T17:28:39")
@StaticMetamodel(Tour.class)
public class Tour_ { 

    public static volatile SingularAttribute<Tour, String> endow;
    public static volatile SingularAttribute<Tour, String> gatheringPlace;
    public static volatile SingularAttribute<Tour, String> suitableSubject;
    public static volatile SingularAttribute<Tour, Integer> numberOfSeatsAvailable;
    public static volatile SingularAttribute<Tour, Integer> isDelete;
    public static volatile SingularAttribute<Tour, String> imageCover;
    public static volatile SetAttribute<Tour, Review> reviewSet;
    public static volatile SingularAttribute<Tour, String> cuisine;
    public static volatile SingularAttribute<Tour, String> timeTour;
    public static volatile SingularAttribute<Tour, String> transport;
    public static volatile SingularAttribute<Tour, String> tourName;
    public static volatile SingularAttribute<Tour, String> concentrate;
    public static volatile SetAttribute<Tour, OrderDetail> orderDetailSet;
    public static volatile SingularAttribute<Tour, String> startTour;
    public static volatile SetAttribute<Tour, TourImage> tourImageSet;
    public static volatile SingularAttribute<Tour, String> schedule;
    public static volatile SingularAttribute<Tour, BigDecimal> price;
    public static volatile SingularAttribute<Tour, String> hotel;
    public static volatile SingularAttribute<Tour, Integer> id;
    public static volatile SingularAttribute<Tour, String> sightSeeing;
    public static volatile SingularAttribute<Tour, Category> categoryId;
    public static volatile SingularAttribute<Tour, String> startingGate;

}