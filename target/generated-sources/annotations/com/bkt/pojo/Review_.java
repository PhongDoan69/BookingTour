package com.bkt.pojo;

import com.bkt.pojo.Tour;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-09-10T15:58:02")
@StaticMetamodel(Review.class)
public class Review_ { 

    public static volatile SingularAttribute<Review, Tour> tourId;
    public static volatile SingularAttribute<Review, Integer> rating;
    public static volatile SingularAttribute<Review, Integer> id;
    public static volatile SingularAttribute<Review, String> content;

}