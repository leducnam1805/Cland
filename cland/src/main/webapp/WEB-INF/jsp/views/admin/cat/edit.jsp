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
				<div class="panel-title ">Sửa loại nhà đất</div>
			</div>
			<div class="content-box-large box-with-header">
			<form action="${pageContext.request.contextPath}/admin/cat/update/${category.cid}" method="post" id="cat-form">
				<div>
					<div class="row mb-10"></div>
					
					<div class="row">
						<div class="col-sm-6">
							<div class="form-group">
							<input name="cid" id="cid" value="${category.cid}" type="hidden" class="form-control">
								<label for="name">Tên nhà đất</label>
								<input name="cname" id="name" value="${category.cname}" type="text" class="form-control" placeholder="Nhập loại nhà đất">
								<form:errors path="cat.cname" cssClass="errors"/>
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