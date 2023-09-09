<%-- 
    Document   : index
    Created on : Jul 13, 2023, 6:12:38 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="javax.servlet.http.Cookie" %>
<%
    String userId = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userId")) {
                userId = cookie.getValue();
                break;
            }
        }
    }
%>

<style>
    #content {
        top: 300px;
        color: blue;
        position: absolute;
        left: 600px;
    }

</style>
<c:url value="/" var="action" />
<section class="container" style="height: 465px">
    <div id="content">
        <h2>Chào ${pageContext.request.userPrincipal.name}</h2>
        <h1>Trang Ch? Admin</h1>
    </div>

</section>