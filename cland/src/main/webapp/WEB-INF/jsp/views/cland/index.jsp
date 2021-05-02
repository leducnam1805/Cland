<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/components/taglib.jsp" %>
    <c:url value="/resources/image" var="urlUpload"/>
<div class="clearfix slider">
	<ul class="pgwSlider">
		<li><img src="${contextPath}/images/thumbs/megamind_07.jpg" alt="Paris, France" data-description="Eiffel Tower and Champ de Mars" data-large-src="${contextPath}/images/slides/megamind_07.jpg"/></li>
		<li><img src="${contextPath}/images/thumbs/wall-e.jpg" alt="Montréal, QC, Canada" data-large-src="${contextPath}/images/slides/wall-e.jpg" data-description="Eiffel Tower and Champ de Mars"/></li>
		<li>
			<img src="${contextPath}/images/thumbs/up-official-trailer-fake.jpg" alt="Shanghai, China" data-large-src="${contextPath}/images/slides/up-official-trailer-fake.jpg" data-description="Shanghai ,chaina">
		</li>
	</ul>
</div>

<div class="clearfix content">
	<div class="content_title"><h2>Bài viết mới</h2></div>
	<c:choose>
		<c:when test="${not empty landList}">
			<c:forEach items="${landList}" var="land">
	<div class="clearfix single_content">
		<div class="clearfix post_date floatleft">
			<div class="date">
				<h3><fmt:formatDate pattern="dd" value="${land.dateCreate}" /></h3>
				<p>Tháng <fmt:formatDate pattern="MM" value="${land.dateCreate}" /> </p>
			</div>
		</div>
		<div class="clearfix post_detail">
			<h2><a href="">${land.lname}</a></h2>
			<div class="clearfix post-meta">
				<p><span><i class="fa fa-clock-o"></i> Địa chỉ: ${land.address}</span> <span><i class="fa fa-folder"></i> Diện tích: ${land.area} m2</span></p>
			</div>
			<div class="clearfix post_excerpt">
				<c:choose>
					<c:when test="${not empty land.picture}">
						<img src="${urlUpload}/${land.picture}" alt=""/>
					</c:when>
					<c:otherwise>
						<img src="${urlUpload}/no-image.jpg" style="width:200px;height:150px;" />
					</c:otherwise>
				</c:choose>
			
				<p>${land.description}</p>
			</div>
			<a href="${pageContext.request.contextPath}/detail/${land.lid}">Đọc thêm</a>
		</div>
	</div>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<div class="alert alert-primary" role="alert">
			  Chưa có bài viết
			</div>
		</c:otherwise>
	</c:choose>
	
</div>

<div class="pagination">

<c:if test="${totalPage > 1}">
	<nav>
		<ul>
			<li><a href=""> << </a></li>
			<c:forEach begin="1" end="${totalPage}" var="i">
	      	<li class="<c:if test="${i == currentPage}">active</c:if>"><a href="${pageContext.request.contextPath}/index/${i}">${i}</a></li>
	      </c:forEach>
			<li><a href=""> >> </a></li>
		</ul>
	</nav>
</c:if>

</div>