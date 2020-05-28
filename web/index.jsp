<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/5/21
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%--[root@localhost ROOT]# cat testmysql.jsp--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page import="java.sql.SQLException" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Insert title here</title>
</head>
<body>

<%
  try{
    Class.forName("com.mysql.cj.jdbc.Driver");//记载数据库驱动，注册到驱动管理器
    String url="jdbc:mysql://localhost:3306/myemployees ?serverTimezone=UTC";  //根据自己的情况修改mysql数据库ip和端口，mysql是数据库上存在的一个库
    String username="root";   //登录账号
    String password="l5710784";  //登录密码
    Connection conn= null;
    try {
      conn = DriverManager.getConnection(url,username,password);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    if(conn!=null){
      out.println("mysql数据库连接成功！！！");
    }else{
      out.println("数据库连接失败！！！");
    }
  }catch(ClassNotFoundException e){
    e.printStackTrace();
  }
%>
</body>
</html>