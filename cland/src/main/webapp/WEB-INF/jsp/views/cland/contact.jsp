<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/components/taglib.jsp" %>
  <style>
    .errors{
    	color:red
    }
  </style>
<div class="clearfix content">
				
	<div class="contact_us">
	
		<h1>Liên hệ với chúng tôi</h1>
		
		<p>
		TRUNG TÂM ĐÀO TẠO LẬP TRÌNH VINAENTER EDU<br />
		Trụ sở: 154 Phạm Như Xương, Liên Chiểu, Đà Nẵng<br />
		Web: <a href="http://vinaenter.edu.vn" title="">www.vinaenter.edu.vn</a>
		</p>
		<form method="post" id="contact-form">
			<p><input type="text" name="fullname" class="wpcf7-text" placeholder="Họ tên *"/></p>
			<form:errors path="ct.fullname" cssClass="errors"/>
			<p><input type="text" name="email" class="wpcf7-email" placeholder="Email *"/></p>
			<form:errors path="ct.email" cssClass="errors"/>
			<p><input type="text" name="subject" class="wpcf7-text" placeholder="Chủ đề *"/></p>
			<form:errors path="ct.subject" cssClass="errors"/>
			<p><textarea class="wpcf7-textarea" name="content" placeholder="Nội dung *"></textarea></p>
			<form:errors path="ct.content" cssClass="errors"/>
			<p><input type="Submit" class="wpcf7-submit" value="Gửi liên hệ"/></p>
		</form>
		
	</div>
	
</div>
<script>
$().ready(function() {
	$("#contact-form").validate({
		onfocusout: false,
		onkeyup: false,
		onclick: false,
		rules: {
			"fullname": {
				required: true,
				minlength: 4,
				maxlength: 50
			},
			"email": {
				required: true,
			},
			"subject": {
				required: true,
				minlength: 8
				
			},
			"content":{
				required: true,
			}
		},
		messages: {
			"fullname": {
				required: "Bắt buộc nhập Họ và tên",
				minlength: "Hãy nhập ít nhất 4 ký tự",
				maxlength: "Hãy nhập tối đa 255 ký tự"
			},
			"email": {
				required: "Bắt buộc nhập email"
			},
			"subject":{
				required: "Bắt buộc nhập chủ đề",
				minlength: "Hãy nhập ít nhất 8 ký tự",
			},
			"content": {
				required: "Bắt buộc nhập nội dung",
			}
		}
	});
});
</script>
