<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/components/taglib.jsp" %>
    
<div class="content-box-large">
 				<div class="row">
  				<div class="panel-heading">
  					<div class="panel-title ">Quản lý người dùng</div>
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
					<a href="${pageContext.request.contextPath}/admin/user/add" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;Thêm</a>

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
							<th>Tên đầy đủ</th>
							<th>Loại người dùng</th>
							<th>Chức năng</th>
						</tr>
					</thead>
					<tbody>
		<c:choose>
			<c:when test="${not empty userList}">
				<c:forEach items="${userList}" var="user">
					<tr class="odd gradeX">
						<td>${user.id}</td>
						<td>${user.username}</td>
						<td>${user.fullname}</td>
						<td>${user.role.name}</td>
						<td class="center text-center">
							<a href="${pageContext.request.contextPath}/admin/user/update/${user.id}" title="" class="btn btn-primary"><span class="glyphicon glyphicon-pencil "></span> Sửa</a>
	                                 <a onclick="return confirm('Bạn có muốn xóa ${user.fullname}')" href="${pageContext.request.contextPath}/admin/user/delete/${user.id}" title="" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span> Xóa</a>
						</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<p>Có lỗi</p>
			</c:otherwise>				
		</c:choose>
						
					</tbody>
				</table>

 				</div>
 				</div><!-- /.row -->
 			</div><!-- /.content-box-large -->