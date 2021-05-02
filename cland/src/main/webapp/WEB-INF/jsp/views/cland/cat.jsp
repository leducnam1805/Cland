<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/components/taglib.jsp" %>
    <c:url value="/resources/image" var="urlUpload"/>
<div class="clearfix content">
	<div class="content_title"><h2>Bất động sản</h2></div>
	<div class="clearfix single_work_container">
		<c:choose>
			<c:when test="${not empty land}">
				<c:forEach items="${land}" var="land">
					<div class="clearfix single_work">
						<c:choose>
							<c:when test="${not empty land.picture}">
						<img class="img_top" src="${urlUpload}/${land.picture}" alt="" style="width:100%"/>
							</c:when>
							<c:otherwise>
						<img src="${urlUpload}/no-image.jpg" style="width:100%;height:150px;" />
							</c:otherwise>
						</c:choose>
						<h2>${land.cat.cname}</h2>
						<a href="${pageContext.request.contextPath}/detail/${land.lid}"><p class="caption">${land.lname}</p></a>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<p style="margin-left:20px;color:red">Không có dữ liệu</p>
			</c:otherwise>
		</c:choose>
		<!-- <div class="clearfix work_pagination">
			<nav>
				<a class="newer floatleft" href=""> < -- Trang trước</a>
				<a class="older floatright" href="">Trang kế -- ></a>
			</nav>
		</div> -->
	</div>
</div>