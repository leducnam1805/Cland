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
				<div class="panel-title ">Sửa loại người dùng</div>
			</div>
			<div class="content-box-large box-with-header">
			<form action="${pageContext.request.contextPath}/admin/role/update/${role.id}" method="post" id="role-form">
				<div>
					<div class="row mb-10"></div>
					
					<div class="row">
						<div class="col-sm-6">
							<div class="form-group">
								<label for="username">Loại người dùng</label>
								<input name="id" value="${role.id}" id="id" type="hidden" class="form-control">
								<input name="name" value="${role.name}" id="name" type="text" class="form-control" placeholder="Nhập loại người dùng">
								<form:errors path="ro.name" cssClass="errors"/>
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