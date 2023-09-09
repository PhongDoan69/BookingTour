<%-- 
    Document   : products
    Created on : Jul 27, 2023, 5:57:29 PM
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
    
    .btn-delete {
        margin-left : 76px;
    }
</style>
<c:url value="/tours" var="action" />
<section>
    <h1 class="text-center text-info mt-1">QUẢN LÝ TOUR DU LỊCH</h1>
    <div>
        <a href="<c:url value="/tours" />" class="btn btn-info">Thêm sản phẩm</a>
    </div>
    <table class="table table-hover">
      
        <div class="row" >
            <c:forEach items="${tours}" var="t">
                <c:set var="tourName" value="${t.tourName}" />
                <c:if test="${tourName.length() > 100}">
                    <c:set var="tourName" value="${fn:substring(tourName, 0, 100)}..." />
                </c:if>
                <div class="card">
                    
                    <img class="card-img-top" src="${t.imageCover}" alt="Card image" />
                    <div class="card-body">
                        <h4 class="card-title">${tourName}</h4>
                        <p class="card-text">
                            <fmt:formatNumber value="${t.price}" type="number" pattern="#,##0.00"/> đ
                        </p>
                        <a href="#" class="btn btn-outline-primary">Xem chi tiết</a>
                        <c:url value="/api/tour/${t.id}" var="delete" />
                        <button class="btn btn-danger btn-delete" onclick="delTour('${delete}')">Xóa</button>
                    </div>
                        
                </div>
            </c:forEach>

        </div>
    
    </table>    
</section>
<script src="<c:url value="/js/main.js" />"></script>
