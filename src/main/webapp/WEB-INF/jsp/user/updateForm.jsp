<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../common/header.jsp"%>

<br>
<br>
<br>
<br>

<div class="container">
      <H2> ${principal} </H2>
      <H2> 회원정보수정 </H2>
	<form>
		<input type="hidden" id="id" value="${principal.users.id}" />
		<div class="form-group">
			<label for="username">ID</label> 
			<input type="text" value="${principal.users.username }" class="form-control" placeholder="Enter username" id="username" readonly>
		</div>
		
		<div class="form-group">
			<label for="password">Password</label> 
			<input type="password" class="form-control" placeholder="패스워드를 입력하세요" id="password">
		</div>
		
		<div class="form-group">
			<label for="passwordConfirm">Password 확인</label> 
			<input type="password" class="form-control" placeholder="패스워드를 다시 입력하세요" id="passwordConfirm">
		</div>
		
		<br>
	</form>
	
	<button id="btn-update" class="btn btn-primary">회원정보수정</button>
	
    <div class="form-group">
			<label for="role_code">권한코드</label> 
			<input type="text" value="${principal.users.role_code}" class="form-control" placeholder="권한코드를 입력" id="role_code" readonly>
		</div>
</div>

<script src="/js/user.js"></script>
<%@ include file="../common/footer.jsp"%>


