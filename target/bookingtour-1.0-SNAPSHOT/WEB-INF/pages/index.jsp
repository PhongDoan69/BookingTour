<%-- 
    Document   : index
    Created on : Jul 13, 2023, 6:12:38 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<style>
    .card {
        width: 300px;
        margin: 10px;
    }

    .card-img-top {
        width: 100%;
        height: 250px;
    }

    .card-title {
        font-size: 15px;
        height:  100px;
    }

    .card-text {
        color: red;
        font-weight: bold;
    }

</style>
<c:url value="/" var="action" />
<section class="container">
    <h1 class="text-center text-success mt-1  ">DANH SÁCH SẢN PHẨM</h1>
    <h2 claas="test">title</h2>
    <div>
        <a href="<c:url value="/tours" />" class="btn btn-info">Thêm sản phẩm</a>
    </div>
    <c:if test="${pages > 1}">
        <ul class="pagination mt-1">
            <li class="page-item"><a class="page-link" href="${action}">Tất cả</a></li>
                <c:forEach begin="1" end="${pages}" var="i">
                    <c:url value="/" var="pageUrl">
                        <c:param name="page" value="${i}" />
                    </c:url>
                <li class="page-item"><a class="page-link" href="${pageUrl}">${i}</a></li>
                </c:forEach>        
        </ul>
    </c:if>

    <table class="table table-hover">
      
        <div class="row" >
            <c:forEach items="${tours}" var="t">
                <c:set var="tourName" value="${t.tourName}" />
                <c:if test="${tourName.length() > 100}">
                    <c:set var="tourName" value="${fn:substring(tourName, 0, 100)}..." />
                </c:if>
                <div class="card">
                    <img class="card-img-top" src="${t.imageCover}" alt="Card image">
                    <div class="card-body">
                        <h4 class="card-title">${tourName}</h4>
                        <p class="card-text">
                            <fmt:formatNumber value="${t.price}" type="number" pattern="#,##0.00"/> đ
                        </p>
                        <a href="#" class="btn btn-outline-primary">Xem chi tiết</a>
                    </div>
                        
                </div>
            </c:forEach>

        </div>
    
    </table>    
</section>
<script src="<c:url value="/js/main.js" />"></script>