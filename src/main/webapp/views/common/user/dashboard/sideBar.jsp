<%-- 
    Document   : sideBar
    Created on : Oct 9, 2023, 9:12:01 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<ul class="sidebar navbar-nav">
    <li class="nav-item active">
        <a class="nav-link" href="${pageContext.request.contextPath}/dashboard">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Dashboard</span>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/dashboard?page=orderDetailsSearching">
            <i class="fas fa-fw fa-table"></i>
            <span>Tra cứu mã vận đơn</span>
        </a>
    </li>
</ul>
