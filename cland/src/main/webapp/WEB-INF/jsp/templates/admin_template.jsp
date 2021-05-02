<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/components/taglib.jsp" %>
    <c:url value="/resources/admin" var="contextPath" scope="application"/>
    <!-- header -->
<!DOCTYPE html>
<html>
  <head>
    <title>Admin Cland</title>
    <link rel="shortcut icon" type="image/ico" href="${contextPath}/images/icon-180x180.png" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0;charset=UTF-8">
    <!-- Bootstrap -->
    <link href="${contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- styles -->
    <link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet">
    <link href="${contextPath}/css/style1.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/admin/ckeditor/ckeditor.js"></script>
  	<!-- <script type="text/javascript" src="http://code.jquery.com/jquery-1.7.0.min.js"></script> -->
  	<script src="https://code.jquery.com/jquery.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js" type="text/javascript"></script>
  </head>
  <body>
  	<tiles:insertAttribute name="header"></tiles:insertAttribute>
<!-- /.header -->
    <div class="page-content">
    	<div class="row">
		  <div class="col-md-2">
		  	<tiles:insertAttribute name="leftbar"></tiles:insertAttribute>
		  </div>
		  <div class="col-md-10">
				<tiles:insertAttribute name="content"></tiles:insertAttribute>
		  </div><!-- /.col-md-10 -->
		</div><!-- /.row -->
    </div><!-- /.page-content -->

    <!-- Footer -->
      <tiles:insertAttribute name="footer"></tiles:insertAttribute>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${contextPath}/bootstrap/js/bootstrap.min.js"></script>
    <script src="${contextPath}/js/custom.js"></script>
  </body>
</html>
    <!-- /.footer -->
