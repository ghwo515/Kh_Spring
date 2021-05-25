<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="frmEmp">
	사원:<input type="text" name="empno"><br>
	이름:<input type="text" name="ename"><br>
	부서번호:<input type="text" name="deptno"><br>
	<button type="button" id="insert">등록</button>
	</form>
<script>
	document.getElementById("insert").onclick = empinsert;
	function empinsert(){
		var frm = document.getElementById("frmEmp");
		frm.action = "insert";
		frm.method = "post";
		frm.submit();
	}
	
	
</script>
</body>
</html>