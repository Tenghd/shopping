<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <style type="text/css">
      .c1{ text-align:right ;margin-right:50px }
      .c2{ text-align:right ;margin-right:50px ; color:blue; font-size:150% }
      body{ background-image:url("../image/2.jpg");background-repeat:repeat }
	  
	  span{ font-size:30px; color:red; font-weight:bolder;margin-left:200px }
      .f{ width:150px; height:70px}
	  
	  
	  .d{ text-align:center; word-spacing:20px;width:70%}
      img{ border:none }
	  
	  
	  .b{ background-color:yellow;
          background-image:url("../image/button12.gif") ;
          width:60px;height:30px; border:none
         }
	  
    </style>
  </head>
  <body>&nbsp;  
    
  <!-- Title -->
     <img src="../image/zgc_px.jpg" align="middle" class="f"/>
     <span>欢迎访问我的购物网站</span>
     <hr/>
	 
   <div class="c2"> 欢迎 ! ${sessionScope.user.username }~ </div>
   
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
  
   <!--  按条件搜索表单 -->
   <center>
  <form action="/shopping/a/QueryByNameAndPriceAction" method="post">
   ProductName:<input type="text" name="productName"/>&nbsp;
   Price:<select name="opt">
                 <option value="1">小于</option>
                <option value="2">大于</option>
         </select>
         <input type="text" name="price" size="6" /> &nbsp;&nbsp;
    <input type="submit"   value="" class="b"/>
  </form>
  </center>
   
   <table border="1" bordercolor="blue" cellspacing=0 align="center" width="70%">
     <tr align="center" bgcolor="lightblue">
       <td><b>Id</b></td>
        <td><b>Name</b></td>
		<td><b>图片</b></td>
         <td><b>Price</b></td>
        <td><b><img src="../image/car_new.gif"/></b></td>
     </tr>
     <c:forEach items="${list }" var="p">
        <tr align="center">
          <td>${p.id }</td>
          <td>${p.productName }</td>
		  <td><img src="..${p.picpath }"/></td>
          <td>${p.price }</td>     
          <td align="center"><a href="/shopping/a/AddCartAction?id=${p.id }"><img src="../image/car_new.gif"/></a></td>
        </tr>
	</c:forEach>
		
   </table>
   <p>&nbsp;</p>
   
   <!-- 分页 --> 
   <center>
   <c:if test="${param.currentPage>1 }">
     <a href="/shopping/a/FindByPageAction?currentPage=${param.currentPage-1 }&pageSize=2">上一页</a>
   </c:if>
    &nbsp;
    这是第 
    <c:forEach begin="1" end="${totalPage }" var="p">
   		 <c:if test="${param.currentPage==p }">
   		 	<font color="red">${p }</font> 页
   		 	&nbsp;
   		 </c:if>
   </c:forEach>
   <c:if test="${param.currentPage<totalPage }">
    <a href="/shopping/a/FindByPageAction?currentPage=${param.currentPage+1 }&pageSize=2"">下一页</a>
    &nbsp;
  </c:if>  
</center>
   
  </body>
</html>