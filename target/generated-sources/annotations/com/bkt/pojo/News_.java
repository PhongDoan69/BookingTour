package com.bkt.pojo;

import com.bkt.pojo.Comment;
import com.bkt.pojo.Liked;
import com.bkt.pojo.NewsImgae;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-09-10T17:28:39")
@StaticMetamodel(News.class)
public class News_ { 

    public static volatile SetAttribute<News, Liked> likedSet;
    public static volatile SetAttribute<News, Comment> commentSet;
    public static volatile SingularAttribute<News, Integer> isDelete;
    public static volatile SingularAttribute<News, String> imageCover;
    public static volatile SingularAttribute<News, Date> postDate;
    public static volatile SetAttribute<News, NewsImgae> newsImgaeSet;
    public static volatile SingularAttribute<News, Integer> id;
    public static volatile SingularAttribute<News, String> title;
    public static volatile SingularAttribute<News, String> content;

}