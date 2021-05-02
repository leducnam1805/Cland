<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/components/taglib.jsp" %>
    <style>
	    .errors {
	    	color:red;
	    }
	    .alert-msg{
	    	color:red;
	    }
	    .ex-span{
	    	color:red;
	    	font-style: italic;
	    }
    </style>
<div class="row">
		<div class="col-md-12 panel-info">
			<div class="content-box-header panel-heading">
				<div class="panel-title ">Thêm loại người dùng</div>
			</div>
			<div class="content-box-large box-with-header">
			<c:if test="${not empty msg}">
				<div class="alert-msg" role="alert">
				  ${msg}
				</div>
			</c:if>
			<form method="post" action="${pageContext.request.contextPath}/admin/role/add" id="role-form">
				<div>
					<div class="row mb-10"></div>
					
					<div class="row">
						<div class="col-sm-6">
							<div class="form-group">
								<label for="name">Tên loại người dùng</label>
								<input name="name" id="name" value="${ro.name}" type="text" class="form-control" placeholder="Nhập loại người dùng">
								<form:errors path="ro.name" cssClass="errors"/><br>
								<span class="ex-span">Lưu ý: Loại tài khoản phải bắt đầu bằng ROLE_. Ex: ROLE_ADMIN</span>
							</div>
						</div>
			
						<div class="col-sm-6"></div>
					</div>
			
					<hr>
			
					<div class="row">
						<div class="col-sm-12">
							<input type="submit" value="Thêm" class="btn btn-success" />
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
	$("#role-form").validate({
		onfocusout: false,
		onkeyup: false,
		onclick: false,
		rules: {
			"name": {
				required: true,
				minlength: 4,
				maxlength: 50
			}
		},
		messages: {
			"name": {
				required: "Bắt buộc nhập loại người dùng",
				minlength: "Hãy nhập ít nhất 4 ký tự",
				maxlength: "Hãy nhập tối đa 50 ký tự"
			}
		}
	});
});
</script>