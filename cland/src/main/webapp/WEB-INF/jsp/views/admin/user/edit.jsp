<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/components/taglib.jsp" %>
    <style>
	    .errors{
	    	color:red;
	    }
    </style>
<div class="row">
		<div class="col-md-12 panel-info">
			<div class="content-box-header panel-heading">
				<div class="panel-title ">sửa người dùng</div>
			</div>
			<div class="content-box-large box-with-header">
			<form action="${pageContext.request.contextPath}/admin/user/update/${user.id}" method="post" id="user-form">
				<div>
					<div class="row mb-10"></div>
					
					<div class="row">
						<div class="col-sm-6">
							<div class="form-group">
								<label for="username">Tên người dùng</label>
								<input readonly="readonly" name="username" value="${user.id}" id="username" type="hidden" class="form-control">
								<input readonly="readonly" name="username" value="${user.username}" id="username" type="text" class="form-control" placeholder="Nhập tên người dùng">
								<form:errors path="us.username"/>
							</div>
							<div class="form-group">
								<label for="fullname">Tên đầy đủ</label>
								<input name="fullname" id="fullname" value="${user.fullname}" type="text" class="form-control" placeholder="Nhập tên đầy đủ">
								<form:errors path="us.fullname"/>
							</div>
							<div class="form-group">
								<label for="password">Mật khẩu</label>
								<input name="password" id="password" type="password" class="form-control" placeholder="Nhập mật khẩu">
								<form:errors path="us.password"/>
							</div>
							<div class="form-group">
								<label for="cat">Loại người dùng:</label>
								<c:choose>
									<c:when test="${not empty roleList}">
									  <select id="role" name="rid" class="form-control">
										<c:forEach items="${roleList}" var="role">
											<c:choose>
												<c:when test="${role.id == user.role.id }">
													<option selected="selected" value="${role.id}">${role.name}</option>
												</c:when>
												<c:otherwise>
													<option value="${role.id}">${role.name}</option>
												</c:otherwise>
											</c:choose>
											
										</c:forEach>
									  </select>
									</c:when>
								</c:choose>
							</div>
						</div>
			
						<div class="col-sm-6"></div>
					</div>
			
					<hr>
			
					<div class="row">
						<div class="col-sm-12">
							<input type="submit" value="Sửa" class="btn btn-success" />
							<input type="reset" value="Nhập lại" class="btn btn-default" />
						</div>
					</div>
			
				</div>
				</form>
			</div>
		</div>
	</div><!-- /.row col-size -->
	<script>
$().ready(function() {
	$("#user-form").validate({
		onfocusout: false,
		onkeyup: false,
		onclick: false,
		rules: {
			"username": {
				required: true,
				minlength: 4,
				maxlength: 50
			},
			"fullname": {
				required: true,
				minlength: 4,
				maxlength: 50
			},
			"password": {
				required: true,
				minlength: 4,
				maxlength: 50
			}
		},
		messages: {
			"username": {
				required: "Bắt buộc nhập tên người dùng",
				minlength: "Hãy nhập ít nhất 4 ký tự",
				maxlength: "Hãy nhập tối đa 50 ký tự"
			},
			"fullname": {
				required: "Bắt buộc nhập tên đầy đủ",
				minlength: "Hãy nhập ít nhất 4 ký tự",
				maxlength: "Hãy nhập tối đa 50 ký tự"
			},
			"password": {
				required: "Mật khẩu không được để trống",
				minlength: "Hãy nhập ít nhất 4 ký tự",
				maxlength: "Hãy nhập tối đa 50 ký tự"
			},
		}
	});
});
</script>