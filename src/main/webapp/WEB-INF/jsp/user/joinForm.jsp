<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../common/header.jsp"%>

<br>
<br>
<br>
<br>

<%@include file ="../common/header.jsp" %>



<script type="text/javascript">	



</script>

<div class="container-sm">
    <h2>회원가입</h2>
	<div>
  			<span id="chkMsg"></span>
	</div>		
	<form>
	    <div class=id_check>
             <span id="chkMsg"></span>
        </div>	
		<div class="form-group">
			<label for="username">ID</label> 
			<input type="text" class="form-control" placeholder="사용자 ID를 입력하세요" id="username" >
		</div>
		
		<div class="form-group">
			<label for="password">Password</label> 
			<input type="password" class="form-control" placeholder="패스워드를 입력하세요" id="password">
		</div>
		
		<div class="form-group">
			<label for="passwordconfirm">Password 재확인 </label> 
			<input type="password" class="form-control" placeholder="패스워드를 다시 입력하세요" id="passwordConfirm">
		</div>
		
	</form>
	<br>
	<button id="btn-save" class="btn btn-primary">회원가입</button>
	<button id="btn-cancle" class="btn btn-secondary" onclick="location.href='/' ">취소</button>
</div>

<script src="/js/user.js"></script>
<script src="<c:url value='/js/jquery-3-6-0.js' />"></script>
<%@ include file="../common/footer.jsp"%>


