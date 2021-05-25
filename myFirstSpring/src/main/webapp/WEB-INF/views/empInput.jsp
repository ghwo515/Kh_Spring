<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="frmEmp" enctype="multipart/form-data">
	사번:<input type="text" name="empno"> <br>
	이름:<input type="text" name="ename"> <br>
	부서번호:<input type="text" name="deptno"> <br>
	파일:<input type="file" name="upfile"> <br>
	<button type="button" id="insert">등록</button>
</form>
<script>
	document.getElementById("insert").onclick=empinsert;
	function empinsert(){
		var frm = document.getElementById("frmEmp");
		// 현재 이 파일의 위치 /emp/input
		//frm.action = "emp/insert";     // /emp/emp/insert
		//frm.action = "insert";     // /emp/insert
		frm.action = "insert2";     // /emp/insert file 저장		
		frm.method = "post"; 
		frm.submit();
	}	
</script>
</body>
</html>