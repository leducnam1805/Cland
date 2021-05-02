<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/components/taglib.jsp" %>
<div class="clearfix sidebar">
	<div class="clearfix single_sidebar category_items">
		<h2>Danh mục bất động sản</h2>
		<c:choose>
			<c:when test="${not empty landListGroup}">
		<ul>
				<c:forEach items="${landListGroup}" var="land">
			<li class="cat-item"><a href="${pageContext.request.contextPath}/cat/${land.cat.cid}">${land.cat.cname}</a>(${land.lid})</li>
				</c:forEach>
		</ul>
			</c:when>
		</c:choose>
	</div>

	<div class="clearfix single_sidebar">
		<div class="popular_post">
			<div class="sidebar_title"><h2>Xem nhiều</h2></div>
			<c:choose>
				<c:when test="${not empty CountViewList}">
			<ul>
					<c:forEach items="${CountViewList}" var="land">
				<li><a href="${pageContext.request.contextPath}/detail/${land.lid}">${land.lname}</a></li>
					</c:forEach>
			</ul>
				</c:when>
			</c:choose>
		</div>
		</div>
	
	<div class="clearfix single_sidebar">
		<h2>Danh mục hot</h2>
		<c:choose>
			<c:when test="${not empty countViewsCatList}">
		<ul>
			<c:forEach items="${countViewsCatList}" var="land">
		<li><a href="${pageContext.request.contextPath}/cat/${land.cat.cid}">${land.cat.cname}<span>(${land.lid})</span></a></li>
			</c:forEach>
		</ul>
			</c:when>
		</c:choose>
	</div>
</div>