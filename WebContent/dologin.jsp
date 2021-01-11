<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="cn.edu.uibe.domain.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<jsp:useBean id="user" scope="request" class="cn.edu.uibe.domain.User"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>
<jsp:useBean id="userService" class="cn.edu.uibe.service.UserService"></jsp:useBean>
</head>
<body>
<%
   User user2 = userService.login(user);
   if(user2!=null){
	   out.println("登录成功，欢迎"+user2.getEmail());
	   session.setAttribute("userName", user.getUserName());
   }else{
	   out.println("登录失败"); 
   }

%>

${user.userName} ${user.password}
<%
  out.println(user.getUserName());
%>

</body>
</html>


<%
 //和下列代码一样
 Object obj = request.getAttribute("user");
 if(obj==null){
	 obj = new cn.edu.uibe.domain.User();
	 request.setAttribute("user", obj);
 }
 cn.edu.uibe.domain.User u2 = (cn.edu.uibe.domain.User)obj;

%>