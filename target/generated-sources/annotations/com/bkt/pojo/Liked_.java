package com.bkt.pojo;

import com.bkt.pojo.News;
import com.bkt.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-09-09T19:17:17")
@StaticMetamodel(Liked.class)
public class Liked_ { 

    public static volatile SingularAttribute<Liked, User> accountId;
    public static volatile SingularAttribute<Liked, News> newsId;
    public static volatile SingularAttribute<Liked, Integer> id;
    public static volatile SingularAttribute<Liked, String> state;

}