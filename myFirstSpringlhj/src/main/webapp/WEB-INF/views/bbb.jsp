<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
bbb 파일입니다.

<P>  The time on the server is ${serverTime}. </P>
<a href="<%=request.getContextPath() %>aaa">aaa로 절대주소 이동</a>
<a href="aaa">aaa로 상대주소 이동</a>
</body>
</html>