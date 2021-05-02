<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <div class="sidebar content-box" style="display: block;">
       <!-- Nav-bar -->
		<ul class="nav">
		    <!-- Main menu -->
		    <li class="current"><a href="${pageContext.request.contextPath}/admin/index"><i class="glyphicon glyphicon-home"></i> Trang chủ</a></li>
		    <li><a href="${pageContext.request.contextPath}/admin/cat/index"><i class="glyphicon glyphicon-list"></i> Danh mục</a></li>
		    <li><a href="${pageContext.request.contextPath}/admin/role/index"><i class="glyphicon glyphicon-book"></i> Loại Người dùng</a></li>
		    <li><a href="${pageContext.request.contextPath}/admin/user/index"><i class="glyphicon glyphicon-book"></i> Người dùng</a></li>
		    <li><a href="${pageContext.request.contextPath}/admin/land/index"><i class="glyphicon glyphicon-book"></i> Tin</a></li>
		    <li><a href="${pageContext.request.contextPath}/admin/contact/index"><i class="glyphicon glyphicon-book"></i> Liên hệ</a></li>
		    <li class="submenu">
		         <a href="#">
		            <i class="glyphicon glyphicon-list"></i> Pages
		            <span class="caret pull-right"></span>
		         </a>
		         <!-- Sub menu -->
		         <ul>
		            <li><a href="${pageContext.request.contextPath}/admin/login">Login</a></li>
		            <li><a href="javascript:void(0)">Signup</a></li>
		        </ul>
		    </li>
		</ul>
	<!-- /.nav-bar -->
    </div>