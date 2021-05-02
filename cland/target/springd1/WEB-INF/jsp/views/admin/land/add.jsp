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
				<div class="panel-title ">Thêm loại nhà đất</div>
			</div>
			<div class="content-box-large box-with-header">
			<form method="post" action="${pageContext.request.contextPath}/admin/land/add" enctype="multipart/form-data">
				<div>
					<div class="row mb-10"></div>
					<div class="row">
						<div class="col-sm-6">
							<div class="form-group">
								<label for="name">Tên</label>
								<input name="lname" id="name" type="text" class="form-control" placeholder="">
								<form:errors path="ld.lname" cssClass="errors" />
							</div>
							
							<div class="form-group">
								<label for="mota">Mô tả</label>
								<textarea name="description" id="description" rows="10" cols="80">
					                Mô tả ....
					            </textarea>
							</div>
							<form:errors path="ld.description" cssClass="errors" />
							<script type="text/javascript">
								CKEDITOR.replace('description');
							</script>
							
							<div class="form-group">
								<label for="file">Hình ảnh</label>
								<input name="file" id="file" type="file" class="form-control" placeholder="Hình ảnh">
							</div>
							
							<div class="form-group">
								<label for="cat">Loại:</label>
								<c:choose>
									<c:when test="${not empty catList}">
									  <select id="cat" name="cid" class="form-control">
										<c:forEach items="${catList}" var="cat">
											<option value="${cat.cid}">${cat.cname}</option>
										</c:forEach>
									  </select>
									</c:when>
								</c:choose>
							</div>
							
							<div class="form-group">
								<label for="address">Địa chỉ</label>
								<input name="address" id="address" type="text" class="form-control" placeholder="Địa chỉ">
								<form:errors path="ld.address" cssClass="errors" />
							</div>
							
							<div class="form-group">
								<label for="area">Diện tích</label>
								<input name="area" id="area" type="text" class="form-control" placeholder="Diện tích ex:1000 m2">
								<form:errors path="ld.area" cssClass="errors" />
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
