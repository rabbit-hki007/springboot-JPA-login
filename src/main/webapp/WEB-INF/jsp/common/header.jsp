<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal"/>
</sec:authorize>

<!DOCTYPE html>
<html lang="ko" class="h-100">
  <head>
   
    <title>메인페이지</title>
    <meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="/css/bootstrap.min.css">
	<script src="<c:url value='/js/jquery-3-6-0.js' />"></script>
	
    <!-- Bootstrap core CSS -->
	<%-- <link href="<c:url value='/css/bootstrap.min.css' />" rel="stylesheet"> --%>
	
    <!-- Custom styles for this template -->
    <%-- <link href="<c:url value='../css/sticky-footer-navbar.css' />" rel="stylesheet"> --%>
    <%-- <script src="<c:url value='../js/bootstrap.bundle.min.js' />"></script>
	<script src="<c:url value='../js/jquery-3-6-0.js' />"></script> --%>
    
 
  </head>
  <body class="d-flex flex-column h-100">
    
	<header>
  		<!-- Fixed navbar -->
  		<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    		<div class="container-fluid">
    			<a class="navbar-brand" href="#">테스트프로그램</a>
    			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
      				<span class="navbar-toggler-icon"></span>
    			</button>
    		<div class="collapse navbar-collapse" id="navbarColor01">
      			<ul class="navbar-nav me-auto">
        			<li class="nav-item">
          				<a class="nav-link active" href="/">Home
            				<span class="visually-hidden">(current)</span>
          				</a>
        			</li>
        			<li class="nav-item">
          				<a class="nav-link" href="#">기본메뉴1</a>
        			</li>
        			<li class="nav-item">
          				<a class="nav-link" href="#">기본메뉴2</a>
        			</li>
        			<li class="nav-item">
          				<a class="nav-link" href="#">기본메뉴3</a>
        			</li>
        			
        			<sec:authorize access="hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')">
        			<li class="nav-item dropdown">
          				<div class="dropdown">
		  					<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">메니저용</button>
		  					<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
		    					<li><a class="dropdown-item" href="#">Action</a></li>
		    					<li><a class="dropdown-item" href="#">Another action</a></li>
		    					<li><a class="dropdown-item" href="#">Something else here</a></li>
		  					</ul>
						</div>
					</li>
					</sec:authorize>
					
					<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
					<li class="nav-item dropdown">
          				<div class="dropdown">
		  					<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">관리자용</button>
		  					<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
		    					<li><a class="dropdown-item" href="#">회원관리</a></li>
		    					<li><a class="dropdown-item" href="#">공지사항관리</a></li>	    
		  					</ul>
						</div>
        			</li>
        			</sec:authorize>
      			</ul>
      
      <div class="text-end">
          <sec:authorize access="isAnonymous()">
          	<button type="button" class="btn btn-outline-light me-2" onclick="location.href='/user/loginForm' ">로그인</button>
          	<button type="button" class="btn btn-warning" onclick="location.href='/user/joinForm' ">회원가입</button>
          </sec:authorize>
          
          	<sec:authorize access="isAuthenticated()">
            	<span style="color: white;">${principal.users.username }님 환영합니다</span>
          	<sec:authorize access="hasRole('ROLE_USER')">
            	<span style="color: yellow;">권한:일반사용자</span>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_MANAGER')">
				<span style="color: yellow;">권한:매니저</span>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<span style="color: yellow;">권한:관리자</span>
			</sec:authorize>
          	<button type="button" class="btn btn-outline-light me-2" onclick="location.href='/logout' ">로그아웃</button>
          	<button type="button" class="btn btn-warning" onclick="location.href='/user/updateForm' ">회원정보수정</button>
          </sec:authorize>
      </div>
      </div>
  </div>
  </nav>
</header>