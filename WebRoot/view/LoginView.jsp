<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <style type="text/css">
	
      body{  background-image:url("../image/2.jpg");background-repeat:repeat }
	  
	  span{ font-size:30px; color:red; font-weight:bolder;margin-left:200px }
      .f{ width:150px; height:70px}
	  
	  .d{ text-align:center; word-spacing:20px;width:70%}
      img{ border:none }
	  
      td.TableBody1{background-color: #FFFFFF;line-height : normal ;}
      td.TableBody2{background-color: #E4F3FF;line-height : normal ;}
      .tableBorder1{width:97%;border: 1px; background-color: #AFB2C4;}
	  
    </style>
  </head>
  <body>&nbsp;  
  
  <!-- Title -->
     <img src="../image/zgc_px.jpg" align="middle" class="f"/>
     <span>欢迎访问我的购物网站</span>
     <hr/>
   
   <!--  Menu Bar  -->
   <center>
   <div class="d">
     <a href="/shopping/a/FindByPageAction?currentPage=1&pageSize=2"><img src="../image/index.gif"/></a>
     <a href="/shopping/view/UserManageView.jsp"><img src="../image/reg.gif"/></a>
     <a href="/shopping/view/ShopCarView.jsp"><img src="../image/cart.gif"/></a>
     <a href=""><img src="../image/order.gif"/></a>
     <a href="/shopping/SafeOutAction"><img src="../image/exit.gif"/></a>
   </div> 
  </center>
  
  <!-- 正文  -->
   
   <form  method="post" action="/shopping/LoginAction">
<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
  
  <tr bgcolor="lightblue">
    <td height=25 colspan=2 align="center" valign="middle" ><font color="#ffffff"><b>输入您的用户名、密码登录</b></font></td>
  </tr>
  <tr>
    <td valign="middle" class="tablebody1">请输入您的用户名</td>
    <td valign="middle" class="tablebody1"><input name="username" type="text"/>
      &nbsp; <a href="/shopping/view/CreateUserView.jsp">没有注册？</a> </td>
  </tr>
  <tr>
    <td valign="middle" class="tablebody1">请输入您的密码</td>
    <td valign="middle" class="tablebody1"><input name="password" type="password"> &nbsp; ${param.errorMsg }</td>
  </tr>
  <tr>
    <td class="tablebody2" valign="middle" colspan=2 align=center><input type="submit" value="登 录"></td>
  </tr>
</table>
</form>
   &nbsp;<br/>
   </body>
   </html>