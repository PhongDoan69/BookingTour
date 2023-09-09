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

</style>

<c:url value="/news" var="action" />
<c:url value="/addNews" var="addNews" />

<section>
    <div class="container-news">

        <a class="btn btn-primary" href="${addNews}">Thêm tin tức <strong>&#43;</strong></a>
        <div>
            <c:forEach items="${newsList}" var="news">
                <div>${news.title}</div>
            </c:forEach>
        </div>
        
    </div>
</section>
