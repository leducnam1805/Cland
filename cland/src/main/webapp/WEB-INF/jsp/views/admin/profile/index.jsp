<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/components/taglib.jsp" %>
    
<div class="content-box-large">
 				<div class="row">
  				<div class="panel-heading">
  					<div class="panel-title ">Thông tin cá nhân</div>
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
			</div>

			<div class="row">
 				<div class="panel-body">
 					<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
					<thead>
						<tr>
							<th>Tên tài khoản</th>
							<th>Tên đầy đủ</th>
							<th>Loại tài khoản</th>
							<th>Chức năng</th>
						</tr>
					</thead>
					<tbody>
		<c:choose>
			<c:when test="${not empty sessionScope.user}">
					<tr class="odd gradeX">
						<td>${sessionScope.user.username}</td>
						<td>${sessionScope.user.fullname}</td>
						<td>${sessionScope.user.role.name}</td>
						<td class="center text-center">
							<a href="${pageContext.request.contextPath}/profile/update/${sessionScope.user.id}" title="" class="btn btn-primary"><span class="glyphicon glyphicon-pencil "></span> Sửa</a>
						</td>
					</tr>
			</c:when>
			<c:otherwise>
				<p>Không tìm thấy dữ liệu</p>
			</c:otherwise>				
		</c:choose>
						
					</tbody>
				</table>

 				</div>
 				</div><!-- /.row -->
 			</div><!-- /.content-box-large -->