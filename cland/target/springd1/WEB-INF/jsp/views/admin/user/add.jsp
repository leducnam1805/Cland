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
				<div class="panel-title ">Thêm người dùng</div>
			</div>
			<div class="content-box-large box-with-header">
			<form method="post">
				<div>
					<div class="row mb-10"></div>
					
					<div class="row">
						<div class="col-sm-6">
							<div class="form-group">
								<label for="username">Tên người dùng</label>
								<input name="username" id="username" value="${us.username}" type="text" class="form-control" placeholder="Nhập tên người dùng">
								<form:errors path="us.username" cssClass="errors"/>
							</div>
							<div class="form-group">
								<label for="fullname">Tên đầy đủ</label>
								<input name="fullname" id="fullname" value="${us.fullname}" type="text" class="form-control" placeholder="Nhập tên đầy đủ">
								<form:errors path="us.fullname" cssClass="errors"/>
							</div>
							<div class="form-group">
								<label for="password">Mật khẩu</label>
								<input name="password" id="password" type="password" class="form-control" placeholder="Nhập mật khẩu">
								<form:errors path="us.password" cssClass="errors"/>
							</div>
							<div class="form-group">
								<label for="cat">Loại người dùng:</label>
								<c:choose>
									<c:when test="${not empty roleList}">
									  <select id="role" name="rid" class="form-control">
										<c:forEach items="${roleList}" var="role">
											<option value="${role.id}">${role.name}</option>
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
							<input type="submit" value="Thêm" class="btn btn-success" />
							<input type="reset" value="Nhập lại" class="btn btn-default" />
						</div>
					</div>
			
				</div>
				</form>
			</div>
		</div>
	</div><!-- /.row col-size -->