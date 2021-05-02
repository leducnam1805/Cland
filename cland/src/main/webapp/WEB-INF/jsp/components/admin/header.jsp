<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/components/taglib.jsp" %>
    
<div class="header">
     <div class="container">
        <div class="row">
           <div class="col-md-5">
              <!-- Logo -->
              <div class="logo">
                 <h1><a href="index.html">VNE-Admin</a></h1>
              </div>
           </div>
           <div class="col-md-5">
              <div class="row">
                <div class="col-lg-12"></div>
              </div>
           </div>
           <div class="col-md-2">
              <div class="navbar navbar-inverse" role="banner">
                  <nav class="collapse navbar-collapse bs-navbar-collapse navbar-right" role="navigation">
                    <ul class="nav navbar-nav">
	                    <c:choose>
	                    	<c:when test="${not empty sessionScope.user}">
                    	  <li class="dropdown">
	                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">${sessionScope.user.username} <b class="caret"></b></a>
	                        <ul class="dropdown-menu animated fadeInUp">
	                          <li><a href="${pageContext.request.contextPath}/profile/${sessionScope.user.id}">Trang cá nhân</a></li>
	                          <li><a href="${pageContext.request.contextPath}/auth/logout">Đăng xuất</a></li>
	                        </ul>
	                      </li>
	                    	</c:when>
	                    	<c:otherwise>
	                   	  <li class="dropdown">
	                        <a href="${pageContext.request.contextPath}/auth/login">Đăng nhập <b class="caret"></b></a>
	                      </li>
	                    	</c:otherwise>
	                    </c:choose>
                    </ul>
                  </nav>
              </div>
           </div>
        </div>
     </div>
</div>