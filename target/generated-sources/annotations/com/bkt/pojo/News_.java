package com.bkt.pojo;

import com.bkt.pojo.Comment;
import com.bkt.pojo.Liked;
import com.bkt.pojo.NewsImgae;
import com.bkt.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-09-07T15:42:57")
@StaticMetamodel(News.class)
public class News_ { 

    public static volatile SetAttribute<News, Liked> likedSet;
    public static volatile SetAttribute<News, Comment> commentSet;
    public static volatile SingularAttribute<News, User> postBy;
    public static volatile SingularAttribute<News, Date> postDate;
    public static volatile SetAttribute<News, NewsImgae> newsImgaeSet;
    public static volatile SingularAttribute<News, Integer> id;
    public static volatile SingularAttribute<News, String> title;
    public static volatile SingularAttribute<News, String> content;

}