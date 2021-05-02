<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/components/taglib.jsp" %>
<section id="header_area">
			<div class="wrapper header">
				<div class="clearfix header_top">
					<div class="clearfix logo floatleft">
						<a href="index.html"><h1><span>C</span>Land</h1></a>
					</div>
					<%-- <div class="clearfix search floatright">
						<form method="post">
							<input type="text" placeholder="Search" name="lname" value="${land.lname}"/>
							<input type="submit" />
						</form>
					</div> --%>
				</div>
				<div class="header_bottom">
					<nav>
						<ul id="nav">
							<li><a href="${pageContext.request.contextPath}/index">Trang chủ</a></li>
							<li id="dropdown"><a href="javascript:void(0)">Bất động sản</a>
							<c:choose>
								<c:when test="${not empty catList}">
									<ul>
										<c:forEach items="${catList}" var="catList">
											<li><a href="${pageContext.request.contextPath}/cat/${catList.cid}">${catList.cname}</a></li>
										</c:forEach>
									</ul>
								</c:when>
							</c:choose>
							</li>
							<%-- <li><a href="${pageContext.request.contextPath}/single">Giới thiệu</a></li> --%>
							<li><a href="${pageContext.request.contextPath}/contact">Liên hệ</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</section>