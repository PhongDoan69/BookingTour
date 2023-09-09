<%-- 
    Document   : addNews
    Created on : Sep 9, 2023, 6:50:15 PM
    Author     : kyan2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value ="/addNews" var="addNews"/>
<style>
    .title {
        font-size: 50px;
        font-weight: bold;
        text-align: center;
        color: blue;
    }
    
    
     .form-add-news {
        border: 1px solid black;
        padding: 20px;
    }
</style>
<section>
    <div class="title">Thêm tin tức</div>
    <div class="form-add-news">
            
            <form:form method="post" action="${action}" modelAttribute="news" enctype="multipart/form-data">

                <div class="form-floating mb-3 mt-3">
                    <form:input type="text" class="form-control" 
                                path="title" id="title" placeholder="Tiêu đề..." />
                    <label for="title">Tiêu đề</label>
                    <form:errors path="title" element="div" cssClass="text-danger" />
                </div>
                <div class="form-floating">
                    <form:textarea class="form-control" id="cont" name="text" 
                                   path="content" placeholder="Mô tả"></form:textarea>
                        <label for="cont">Mô tả</label>
                    <form:errors path="content" element="div" cssClass="text-danger" />
                </div>
                <div class="form-floating mb-3 mt-3">
                    <form:input type="file" class="form-control" 
                                path="file" id="file"  />
                    <label for="file">Ảnh </label>
                </div>
                <button class="btn btn-info" type="submit">Thêm</button>
            </form:form>

        </div>
    
</section>