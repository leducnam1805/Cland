<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/components/taglib.jsp" %>
    <style>
	    .errors{
	    	color:red;
	    }
	    .acc_username{
	    	color:red;
	    }
    </style>
<div class="row">
	<c:choose>
		<c:when test="${not empty user}">
	<div class="col-md-12 panel-info">
			<div class="content-box-header panel-heading">
				<div class="panel-title ">Sửa tài khoản <span class="acc_username">${user.username}</span></div>
			</div>
			<div class="content-box-large box-with-header">
			<form action="${pageContext.request.contextPath}/profile/update/${user.id}" method="post" id="user-form">
				<div>
					<div class="row mb-10"></div>
					
					<div class="row">
						<div class="col-sm-6">
							<div class="form-group">
								<input name="id" id="id" value="${user.id}" type="hidden" class="form-control">
								<label for="fullname">Tên đầy đủ</label>
								<input name="fullname" id="fullname" value="${user.fullname}" type="text" class="form-control" placeholder="Nhập tên đầy đủ">
								<form:errors path="us.fullname" cssClass="errors"/>
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
		</c:when>
		<c:otherwise>
	<div class="col-md-12 panel-info">
		<div class="content-box-header panel-heading">
			<div class="panel-title ">Không tìm thấy dữ liệu</div>
		</div>
	</div>
		</c:otherwise>
	</c:choose>
	</div><!-- /.row col-size -->
	<script>
$().ready(function() {
	$("#cat-form").validate({
		onfocusout: false,
		onkeyup: false,
		onclick: false,
		rules: {
			"cname": {
				required: true,
				minlength: 4,
				maxlength: 50
			}
		},
		messages: {
			"cname": {
				required: "Bắt buộc nhập loại bất động sản",
				minlength: "Hãy nhập ít nhất 4 ký tự",
				maxlength: "Hãy nhập tối đa 50 ký tự"
			}
		}
	});
});
</script>