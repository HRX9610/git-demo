<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页</title>
</head>
<body>
  <h3>用户登录</h3>
  <form action="${pageContext.request.contextPath}/doLogin" method="post">
    
	    <p>
	    	用户名：<input type="text" name="username"/>
	    </p>
	    <p>
			密 码：<input type="password" name="password"/>
	    </p>
	    <p>
	       <input type="submit" value="提   交" />
	       ${errorMsg}
	    </p>
   
   </form>
</body>
</html>