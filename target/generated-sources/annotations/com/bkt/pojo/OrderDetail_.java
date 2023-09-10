package com.bkt.pojo;

import com.bkt.pojo.OrderTable;
import com.bkt.pojo.Tour;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-09-10T15:58:02")
@StaticMetamodel(OrderDetail.class)
public class OrderDetail_ { 

    public static volatile SingularAttribute<OrderDetail, BigDecimal> countChild;
    public static volatile SingularAttribute<OrderDetail, String> note;
    public static volatile SingularAttribute<OrderDetail, BigDecimal> countAdult;
    public static volatile SingularAttribute<OrderDetail, BigDecimal> totalPrice;
    public static volatile SingularAttribute<OrderDetail, OrderTable> orderId;
    public static volatile SingularAttribute<OrderDetail, Tour> tourId;
    public static volatile SingularAttribute<OrderDetail, BigDecimal> priceAdult;
    public static volatile SingularAttribute<OrderDetail, BigDecimal> priceChild;
    public static volatile SingularAttribute<OrderDetail, Integer> orderDetailId;

}