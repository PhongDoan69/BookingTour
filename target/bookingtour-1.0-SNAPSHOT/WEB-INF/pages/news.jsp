<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html> 
<style>


    .container-news {
        position: relative;
        z-index: 2;
        height: 100%;
        padding: 0;
    }

    .btn-delete {
        right: 0;
        top: 0;
        padding: 0 5px;
        position: absolute;
    }

    .card-item{
        margin: 10px;

    }
    
    
</style>

<c:url value="/api/news" var="action" />
<c:url value="/addNews" var="addNews" />

<section>
    <div class="container-news">

        <a class="btn btn-primary" href="${addNews}">Thêm tin tức <strong>&#43;</strong></a>
        <div class="row">
            <c:forEach items="${newsList}" var="news">
                <div class="card card-item" style="width:400px">


                    <img class="card-img-top" src="${news.imageCover}" alt="Card image">
                    <div class="card-body">
                        <h4 class="card-title">${news.title}</h4>
                       
                    </div>
                        <c:url value="`${action}/${news.id}`" var="apiDel"/>
                        <button class="btn btn-danger btn-delete" onclick="deleteNews(${apiDel})">Xóa</button>
                </div>
            </c:forEach>
        </div>

    </div>
</section>
 <script src="<c:url value="/js/news.js" />"></script>