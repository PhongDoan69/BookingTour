package com.bkt.pojo;

import com.bkt.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-09-10T17:28:39")
@StaticMetamodel(Employee.class)
public class Employee_ { 

    public static volatile SingularAttribute<Employee, User> accountId;
    public static volatile SingularAttribute<Employee, String> gender;
    public static volatile SingularAttribute<Employee, String> fullName;
    public static volatile SingularAttribute<Employee, Integer> employeeId;
    public static volatile SingularAttribute<Employee, Date> dateOfBirth;
    public static volatile SingularAttribute<Employee, String> position;

}