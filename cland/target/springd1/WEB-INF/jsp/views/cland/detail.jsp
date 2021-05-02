<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@include file="/WEB-INF/jsp/components/taglib.jsp" %>
    <c:url value="/resources/image" var="urlUpload"/>
<div class="clearfix content">
				
	<h1>${land.lname}</h1>
	<div class="clearfix post-meta">
		<p><span><i class="fa fa-clock-o"></i> Địa chỉ: ${land.address}</span> <span><i class="fa fa-folder"></i> Diện tích: ${land.area}m2</span></p>
	</div>
	
	<div class="vnecontent">
		<p>${land.description}</p>
	</div>
	
</div>
<div class="more_themes">
	<h2>Bất động sản liên quan <i class="fa fa-thumbs-o-up"></i></h2>
	<c:choose>
		<c:when test="${not empty landList}">
	<div class="more_themes_container">
		<c:forEach items="${landList}" var="land">
		<div class="single_more_themes floatleft">
			<c:choose>
				<c:when test="${not empty land.picture}">
					<img src="${urlUpload}/${land.picture}" alt="" style="width:100%;height:150px;"/>
				</c:when>
				<c:otherwise>
					<img src="${urlUpload}/no-image.jpg" style="width:100%;height:150px;" />
				</c:otherwise>	
			</c:choose>
			<a href="${pageContext.request.contextPath}/detail/${land.lid}"><h2>${land.lname}</h2></a>
		</div>
		</c:forEach>
	</div>
		</c:when>
		<c:otherwise>
			<div class="alert alert-primary" role="alert">
			  Chưa có bài viết
			</div>
		</c:otherwise>
	</c:choose>
</div>