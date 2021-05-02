   <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/components/taglib.jsp" %>
    <c:url value="/resources/image" var="urlUpload"/>
<div class="content-box-large">
  				<div class="row">
	  				<div class="panel-heading">
	  					<div class="panel-title ">Quản lý tin</div>
		  			</div>
				</div>
				<hr>	
			<c:if test="${not empty msg}">
				<div class="alert alert-primary" role="alert">
				  ${msg}
				</div>
			</c:if>
				<div class="row">
					<div class="col-md-8">

					</div>
                	<div class="col-md-4">
                	<form method="GET">
	                 	 <div class="input-group form">
	                       <input type="text" class="form-control" name="q" placeholder="Search...">
	                       <span class="input-group-btn">
	                         <button class="btn btn-primary" type="submit">Search</button>
	                       </span>
	                  	 </div>
	                 </form>
                  	</div>
				</div>

				<div class="row">
  				<div class="panel-body">
  					<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
						<thead>
							<tr>
								<th>ID</th>
								<th>Tên</th>
								<th>Email</th>
								<th>Địa chỉ</th>
								<th>Nội dung</th>
							</tr>
						</thead>
						<tbody>
						<c:choose>
							<c:when test="${not empty contactList}">
								<c:forEach items="${contactList}" var="contact">
									<tr class="odd gradeX">
										<td>${contact.cid}</td>
										<td>${contact.fullname}</td>
										<td>${contact.email}</td>
										<td>${contact.subject}</td>
										<td>${contact.content}</td>
									</tr>
								</c:forEach>
							</c:when>
						</c:choose>
						
						</tbody>
					</table>

					<!-- Pagination -->
					
					<c:if test="${totalPage > 1}">
						<nav class="text-center" aria-label="...">
					   <ul class="pagination">
					      <li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
					      <c:forEach begin="1" end="${totalPage}" var="i">
					      	<c:choose>
					      		<c:when test="${not empty search}">
					      			<li class="<c:if test="${i == currentPage}">active</c:if>"><a href="${pageContext.request.contextPath}/admin/contact/index/${i}?q=${search}">${i}<span class="sr-only">(current)</span></a></li>
					      		</c:when>
					      		<c:otherwise>
					      			<li class="<c:if test="${i == currentPage}">active</c:if>"><a href="${pageContext.request.contextPath}/admin/contact/index/${i}">${i}<span class="sr-only">(current)</span></a></li>
					      		</c:otherwise>
					      	</c:choose>
					      </c:forEach>
					      <li><a href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
					   </ul>
					</nav>
					</c:if>
					<!-- /.pagination -->
					
  				</div>
  				</div><!-- /.row -->
  			</div><!-- /.content-box-large -->