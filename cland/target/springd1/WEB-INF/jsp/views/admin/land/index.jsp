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
						<a href="${pageContext.request.contextPath}/admin/land/add" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;Thêm</a>

					</div>
                	<div class="col-md-4">
                 	 <div class="input-group form">
                       <input type="text" class="form-control" placeholder="Search...">
                       <span class="input-group-btn">
                         <button class="btn btn-primary" type="button">Search</button>
                       </span>
                  	 </div>
                  	</div>
				</div>

				<div class="row">
  				<div class="panel-body">
  					<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
						<thead>
							<tr>
								<th>ID</th>
								<th>Tên</th>
								<th>Danh mục</th>
								<th>Lượt đọc</th>
								<th>Hình ảnh</th>
								<th>Chức năng</th>
							</tr>
						</thead>
						<tbody>
						<c:choose>
							<c:when test="${not empty landList}">
								<c:forEach items="${landList}" var="land">
									<tr class="odd gradeX">
										<td>${land.lid}</td>
										<td>${land.lname}</td>
										<td>${land.cat.cname}</td>
										<td class="center">${land.countViews}</td>
										<td class="center text-center">
											<c:choose>
												<c:when test="${not empty land.picture}">
													<img src="${urlUpload}/${land.picture}" style="width:200px;height:150px;" />
												</c:when>
												<c:otherwise>
													<img src="${urlUpload}/no-image.jpg" style="width:200px;height:150px;" />
												</c:otherwise>
											</c:choose>
										</td>
										<td class="center text-center">
											<a href="${pageContext.request.contextPath}/admin/land/update/${land.lid}" title="" class="btn btn-primary"><span class="glyphicon glyphicon-pencil "></span> Sửa</a>
		                                    <a href="${pageContext.request.contextPath}/admin/land/delete/${land.lid}" onclick="return confirm('Bạn có muốn xóa ${land.lname}')" title="" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span> Xóa</a>
										</td>
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
					      	<li class="<c:if test="${i == currentPage}">active</c:if>"><a href="${pageContext.request.contextPath}/admin/land/index/${i}">${i}<span class="sr-only">(current)</span></a></li>
					      </c:forEach>
					      <li><a href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
					   </ul>
					</nav>
					</c:if>
					<!-- /.pagination -->
					
  				</div>
  				</div><!-- /.row -->
  			</div><!-- /.content-box-large -->