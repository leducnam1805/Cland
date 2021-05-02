<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/components/taglib.jsp" %>
    
    <style>
    	.error{
    		color:red;
    		float:left;
    	}
    </style>
    
   <form method="post" action="${pageContext.request.contextPath}/auth/login" id="form-login">
    <div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-wrapper">
			        <div class="box">
			            <div class="content-wrap">
			            	<img width="100px" height="100px" class="img-circle" src="${contextPath}/images/icon-180x180.png">
			                <h6>Đăng nhập</h6>
			                <c:if test="${not empty error}">
								<div class="error">
								  ${error}
								</div><br>
							</c:if>
			                <div class="form-group">
			                	<label class="text-left pull-left" for="username">Tên đăng nhập</label>
			               		<input class="form-control" name="username" type="text" placeholder="Tên tài khoản">
			                </div>
			                <div class="clearfix"></div>
			                <div class="form-group">
			                	<label class="text-left pull-left" for="password">Mật khẩu</label>
			                	<input class="form-control" name="password" type="password" placeholder="Mật khẩu">
			                </div>
			                
			                <div class="action">
			                    <input class="btn btn-primary signup btn-block" value="Đăng nhập" type="submit"/>
			                </div>                
			            </div>
			        </div>

			        <!-- <div class="already">
			            <p>Don't have an account yet?</p>
			            <a href="javascript:void(0)">Sign Up</a>
			        </div> -->
			    </div>
			</div>
		</div>
	</form>
<script>
$().ready(function() {
	$("#form-login").validate({
		onfocusout: false,
		onkeyup: false,
		onclick: false,
		rules: {
			"username": {
				required: true
			},
			"password": {
				required: true
			}
			
		},
		messages: {
			"username": {
				required: "Bắt buộc nhập tên người dùng"
			},
			"password": {
				required: "Mật khẩu không được để trống"
			},
		}
	});
});
</script>
		