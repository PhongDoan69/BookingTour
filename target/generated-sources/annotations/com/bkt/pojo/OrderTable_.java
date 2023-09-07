package com.bkt.pojo;

import com.bkt.pojo.OrderDetail;
import com.bkt.pojo.User;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-09-07T15:42:57")
@StaticMetamodel(OrderTable.class)
public class OrderTable_ { 

    public static volatile SingularAttribute<OrderTable, BigDecimal> totalAmount;
    public static volatile SingularAttribute<OrderTable, User> accountId;
    public static volatile SingularAttribute<OrderTable, String> paymentMethod;
    public static volatile SingularAttribute<OrderTable, Integer> id;
    public static volatile SingularAttribute<OrderTable, String> state;
    public static volatile SingularAttribute<OrderTable, Date> orderDate;
    public static volatile SetAttribute<OrderTable, OrderDetail> orderDetailSet;

}