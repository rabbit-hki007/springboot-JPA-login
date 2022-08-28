<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../common/header.jsp"%>
<br>
<br>
<br>
<br>
<br>
<br>

<!-- Begin page content -->
  
  <div class="container">
  	 <h2>Login</h2>
     <c:if test="${not empty param.error}">
  		<div class="alert alert-danger" role="alert">
  			A simple danger alert—check it out!
		</div>
	</c:if>	
  
	<form action="/user/loginProc" method="post">
		<div class="form-group">
			<label for="username">ID</label> 
			<input type="text" name="username" class="form-control" placeholder="Enter username" id="username">
		</div>
				
		<div class="form-group">
			<label for="password">Password</label> 
			<input type="password" name="password" class="form-control" placeholder="Enter password" id="password">
		</div>
		
		<br>	
		<button id="btn-login" class="btn btn-primary">로그인</button>
		<button id="btn-cancle" class="btn btn-secondary" onclick="location.href='/' ">취소</button>			
	</form>
	

</div>


<%@ include file="../common/footer.jsp"%>


